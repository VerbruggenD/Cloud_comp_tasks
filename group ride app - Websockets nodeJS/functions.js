var mySocket;

const msgTypes = {
    changeWaypoint: "changeWayPoint",
    changeDestPoint: "changeDestPoint",
    textMessage: "textMessage",
    changeName: "changeName",
    destResponse: "destResponse",
    waypointResponse: "waypointResponse",
    pollResponse: "pollResponse"
}
var msgToSend = { "type": "", "data": "" }

function openWS() {
    if (mySocket == null || mySocket.readyState == WebSocket.CLOSED) {
        mySocket = new WebSocket("ws://127.0.0.1:3001");
        mySocket.addEventListener('open',
            evt => {
                //alert("Socket opened!");
                console.log("Socket opened!");
            }
        );
        mySocket.addEventListener('message', evt => {
            //console.log(evt);
            thisDriver = JSON.parse(evt.data);
            //console.log(thisDriver);
            console.log("Recieved " + thisDriver.type + " msg from " + thisDriver.driver + ": " + thisDriver.data);

            switch(thisDriver.type) {
                case msgTypes.changeDestPoint:
                    //console.log("Recieved " + thisDriver.type + " msg from " + thisDriver.driver + ": " + thisDriver.data);

                    if (confirm('Poll for ' + thisDriver.type + ' to ' + thisDriver.data)) {
                        console.log("yes");
                        wsSendPoll("yes", msgTypes.pollResponse);
                    }
                    else {
                        console.log("no");
                        wsSendPoll("no", msgTypes.pollResponse);
                    }
                break;

                case msgTypes.changeWaypoint:
                    //console.log("Recieved " + thisDriver.type + " msg from " + thisDriver.driver + ": " + thisDriver.data);

                    if (confirm('Poll for ' + thisDriver.type + ' to ' + thisDriver.data)) {
                        console.log("yes");
                        wsSendPoll("yes", msgTypes.pollResponse);
                    }
                    else {
                        console.log("no");
                        wsSendPoll("no", msgTypes.pollResponse);
                    }
                break;

                case msgTypes.pollResponse:
                    //console.log(thisDriver);
                    
                break;

                case msgTypes.textMessage:
                    document.getElementById("textMessages").value += "msg from " + thisDriver.driver + ": " + thisDriver.data + "\n";
                break;

                case msgTypes.waypointResponse:
                    document.getElementById("waypoints").value = thisDriver.data;
                break;

                case msgTypes.destResponse:
                    document.getElementById("destinations").value = thisDriver.data;
                break;
            }



            if (thisDriver.type === msgTypes.changeDestPoint || thisDriver.type == msgTypes.changeWaypoint) {
                
            }

            
        })
    }
}

function closeWS() {
    mySocket.close();
}

function wsSendPoll(text, msgType) {
    if (mySocket.readyState == WebSocket.OPEN) {
        msgToSend.type = msgType;
        msgToSend.data = text;
        mySocket.send(JSON.stringify(msgToSend));
        console.log(msgType + " msg sent");
    }
}

function wsSendInput(input, msgType) {
    var textInput = document.getElementById(input).value;
    if (mySocket.readyState == WebSocket.OPEN) {
        msgToSend.type = msgType;
        msgToSend.data = textInput;
        mySocket.send(JSON.stringify(msgToSend));
        console.log(msgType + " msg sent");
    }
    else {
        openWS();
        wsSendInput(input, msgType);
    }
}

function sendName() {
    wsSendInput('driverName', msgTypes.changeName);
}

function sendText() {
    wsSendInput('textMessage', msgTypes.textMessage);
}

function sendDestination(type) {
    if (type == 'main') {
        wsSendInput('mainDest', msgTypes.changeDestPoint);
    }
    else {
        wsSendInput('wayPointDest', msgTypes.changeWaypoint);
    }
}

function pollDestination(msgTypes) {
    if (msgType == msgTypes.changeDestPoint) {
        alert("persone x asks to change destination to: test");
    }
    else if (msgType == msgTypes.changeWaypoint) {
        alert("persone x asks to change waypoint to: test");
    }
}