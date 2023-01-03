var url = "http://127.0.0.1:8000/api";
var makesUrl = url + "/makesStripped";
var modelsUrl = url +"/modelsOfMakeStripped/"
var calcFineUrl = url +"/calculateFine/"

function getMakes() {
    fetch(makesUrl)
        .then(processResponse)
        .then(showMakes)
        .catch(showError)
}

function showError(error) {
    window.console.error(error);
}

function showMakes(json) {
    console.log(json);
    var list = document.getElementById("makes");

    for (id in json) {
        var make = json[id];
        let option = document.createElement("option");
        option.value = make.name;
        list.appendChild(option);
    }
}

function getModels() {
    var make = document.getElementById("carmakes").value;
    document.getElementById("models").value = '';
    fetch(modelsUrl+make)
       .then(processResponse)
       .then(showModels)
       .catch(showError)
}

function processResponse(response) {
    if (response.ok) {
        return response.json();
    }
    else {
        Promise.reject("internet error");
    }
}

function showModels(json) {
    console.log(json);
    var list = document.getElementById("models");
    list.innerHTML = '';
    for (id in json) {
        var model = json[id];
        let option = document.createElement("option");
        option.value = model.titel;
        list.appendChild(option);
    }
}

function calculateFine () {
    var model = document.getElementById("carmodels").value;

    fetch(calcFineUrl + model)
        .then(processResponse)
        .then(showFine)
        .catch(showError)
}

function showFine(json) {
    console.log(json);
    var output = document.getElementById('output');
    output.innerHTML = "<b>" + json + " euro </b>";
}