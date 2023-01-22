#import eventlet
from enum import Enum
import random
import json
from flask import Flask, render_template
from flask_socketio import SocketIO
from flask_bootstrap import Bootstrap
from flask_cors import CORS, cross_origin
from threading import Timer
from datetime import datetime

server = Flask(__name__)

cors = CORS(server, resources={r"*": {"origins": "*"}})
bootstrap = Bootstrap(server)
socketio = SocketIO(server,cors_allowed_origins='*')

places = ["Kerkstraat", "Molenstraat", "Stationstraat", "Schoolstraat", "Kapelstraat", "Nieuwstraat", "Veldstraat"]

# random.choice(places)

sourceSelection = {
    'waze': True,
    'sensors': True,
    'autoCamera': True,
    'police': True,
    'publicTrans': True
}

problemType = {
    'traffic_jam': "trafic_jam",
    'accident': "accident",
    'flooding': "flooding",
    'obstruction': "obstruction",
    'event': "event"
}

# random.choice(list(problemType.values()))

apiMsg = {
    'apiName': 'xxx',
    'location': 'xxx',
    'problemType': 'xxx',
    'timestamp': 'xxx'
}

class RepeatedTimer(object):
    def __init__(self, interval, function, *args, **kwargs):
        self._timer     = None
        self.interval   = interval
        self.function   = function
        self.args       = args
        self.kwargs     = kwargs
        self.is_running = False
        self.start()

    def _run(self):
        self.is_running = False
        self.start()
        self.function(*self.args, **self.kwargs)

    def start(self):
        if not self.is_running:
            self._timer = Timer(self.interval, self._run)
            self._timer.start()
            self.is_running = True

    def stop(self):
        self._timer.cancel()
        self.is_running = False

class SrcAPI:
    def __init__(self, name, id, url, token, selected):
        self.name = name
        self.id = id
        self.url = url
        self.token = token
        self.selected = selected
    def connect(self):
        self.rt = RepeatedTimer((10+self.id), newData, self) # it auto-starts, no need of rt.start()
        print(self.name + " connected succesfully")
    def disconnect(self):
        self.rt.stop()
        print(self.name + " disconnected succesfully")

def newData(SrcAPI):
    now = datetime.now()
    apiMsg['apiName'] = SrcAPI.name
    apiMsg['location'] = random.choice(places)
    apiMsg['problemType'] = random.choice(list(problemType.values()))
    apiMsg['timestamp'] = now.strftime("%H:%M:%S")
    if(SrcAPI.selected):
        print(apiMsg)
        socketio.emit('message', data=json.dumps(apiMsg))

@server.route('/')
def index():
    if(sourceSelection['waze']):
        waze.connect()
    if(sourceSelection['police']):
        police.connect()
    return render_template('index.html')

@socketio.on('srcSelect')
def srcSelect(json_str):
    data = json.loads(json_str)
    waze.selected = data['waze']
    police.selected = data['police']
    print(data)

@socketio.on('test_json')
def test_json(json_str):
    data = json.loads(json_str)
    print(data)

@socketio.on('test')
def test_socket():
    print("dit is een test")

if __name__ == '__main__':
    waze = SrcAPI('waze',1, "http://waze.com", "asdghwsfgdfg", True)
    police = SrcAPI('police',5, "http://federale_politie.be", "asdghwsfgdfg", True)
    

    socketio.run(server, host='0.0.0.0', port=80, use_reloader=False, debug=True)