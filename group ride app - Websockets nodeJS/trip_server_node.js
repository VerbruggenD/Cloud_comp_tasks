const WebSocket = require('ws')
const wss = new WebSocket.Server({port:3001})
// wss is the websocket server
// ws is the websocket itself

const EventEmitter = require('node:events');
const myEmitter = new EventEmitter();

var teller = 0
var clients = 0
var nrClients = 0;
var drivers = new Map();
var currentPoll = 0;
var timeoutObj;
var destination;

const pollStatusEnum = {    // enum for poll status
    open: "open",
    closed: "closed"
}

var pollStatus = pollStatusEnum.closed; // status variable
var pollResult = false;

var msgToSend = { "driver": "", "type": "" ,"data": "" }    // JSON for messages

class Place {
    description = "";
    latitude = 0;
    longitude = 0;

    constructor(description, latitude, longitude) {
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

const messageType = {
    changeWaypoint: "changeWayPoint",
    changeDestPoint: "changeDestPoint",
    textMessage: "textMessage",
    changeName: "changeName",
    destResponse: "destResponse",
    waypointResponse: "waypointResponse",
    pollResponse: "pollResponse"
}

const responseType = {
    waypoint: "waypoint",
    destination: "destination"
}

class ServerMessage {
    type = "";
    data = "";

    constructor(myMessageType, data) {
        this.type = myMessageType;
        this.data = data;
    }
}

function openPoll() {
    pollStatus = pollStatusEnum.open;
    pollResult = false;
}

function checkPollStatus() {
    return (pollStatus == pollStatusEnum.open);
}

function pollSetTimeOut() {
    timeoutObj = setTimeout(() => {
        console.log('poll done');
        closePoll();
      }, 10000); // closes in 3 secs
}

function closePoll() {
    pollStatus = pollStatusEnum.closed;
    myEmitter.emit('pollClosed');
}

function uuidv4() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }

myEmitter.on('pollClosed', function listener() {
    //console.log('dit is een event');

    if (pollResult == true) {
        if(currentPoll == responseType.destination) {
            wss.clients.forEach(driver => {
                thisDriver = drivers.get(driver);
                msgToSend.type = messageType.destResponse;
                msgToSend.data = destination;
                driver.send(JSON.stringify(msgToSend));
            })
        }
        else {
            wss.clients.forEach(driver => {
                thisDriver = drivers.get(driver);
                msgToSend.type = messageType.waypointResponse;
                msgToSend.data = destination;
                driver.send(JSON.stringify(msgToSend));
            })
        }
    }
    
});

wss.on('connection', ws => {
    console.log("Connection established");

    const id = uuidv4();
    var name = "";
    var metadata = { id, name };

    //console.log(metadata);

    drivers.set(ws, metadata);

    //console.log(drivers);

    // myEmitter.on('pollClosed', function listener() {
    //     console.log('dit is een event');
    //     wss.clients.forEach(driver => {
    //         thisDriver = drivers.get(driver);
    //         msgToSend.type = messageType.pollResponse;
    //         msgToSend.data = pollResult;
    //         driver.send(JSON.stringify(msgToSend));
    //     })
    // });

    ws.on('message', msgString => {
        var message = JSON.parse(msgString);
        //console.log(message);

        var senderDriver = drivers.get(ws);

        switch(message.type) {
            case messageType.changeName:
                //console.log("drivers amount: ");
                //console.log(drivers);
                var name = message.data;
                var thisDriver = drivers.get(ws);
                // console.log("driver name before set: " + thisDriver.name);
                thisDriver.name = name;
                console.log("A new name is set: " + name);
                // console.log("driver name after set: " + thisDriver.name);
                //console.log("drivers amount: ");
                //console.log(drivers);
                break;
            case messageType.textMessage:
                wss.clients.forEach(driver => {
                    thisDriver = drivers.get(driver);
                    
                    if (driver != ws) {
                        msgToSend.driver = senderDriver.name;
                        msgToSend.type = messageType.textMessage;
                        msgToSend.data = message.data;
                        driver.send(JSON.stringify(msgToSend));
                    }
                })
                break;

            case messageType.changeWaypoint:
                // not implemented
                console.log("new msg change waypoint: " + message.data);

                destination = message.data;

                currentPoll = responseType.waypoint;
                wss.clients.forEach(driver => {
                    thisDriver = drivers.get(driver);
                    if (driver != ws) {
                        msgToSend.driver = senderDriver.name;
                        msgToSend.type = messageType.changeWaypoint;
                        msgToSend.data = message.data;
                        driver.send(JSON.stringify(msgToSend));
                    }
                })

                openPoll();
                pollSetTimeOut();
                break;
            
            case messageType.changeDestPoint:
                // not implemented
                console.log("new msg change dest point: " + message.data);

                destination = message.data;

                currentPoll = responseType.destination;
                wss.clients.forEach(driver => {
                    thisDriver = drivers.get(driver);
                    if (driver != ws) {
                        msgToSend.driver = senderDriver.name;
                        msgToSend.type = messageType.changeDestPoint;
                        msgToSend.data = message.data;
                        driver.send(JSON.stringify(msgToSend));
                    }
                })

                openPoll();
                pollSetTimeOut();
                break;

            case messageType.pollResponse:
                // not implemented
                console.log(message.data);

                if (checkPollStatus) {
                    if (timeoutObj) {
                        clearTimeout(timeoutObj);
                    }
    
                    pollSetTimeOut();

                    if (message.data == 'yes') {
                        console.log("poll accepted");

                        pollResult = true;
                    }
    
                    if (message.data != 'yes') {
                        console.log("poll denied");

                        pollResult = false;

                        clearTimeout(timeoutObj);
                        if (pollStatus != pollStatusEnum.closed) {
                            closePoll();
                        }
                    }
                }

            break;

            default:
                // this state should never happen
                console.log("Unknown message type: " + message.type);
                break;
          }

    })
})