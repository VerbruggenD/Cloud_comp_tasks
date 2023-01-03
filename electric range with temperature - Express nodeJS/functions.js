function testFunction() {
        var url = "http://127.0.0.1:3000/"
        fetch(url, {
            method: "POST",
            headers: {
                'Accept': 'application/json' ,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                fullname: document.getElementById('fullname').value
            })
        })
            .then(response => { 
                if(response.ok) return response.text();
                else {
                    alert("foutje"); 
                    console.log(response);
                }
                })
            .then(showData);
            }

function showData(txt) {
    document.getElementById("status").innerHTML = "<b>" + txt + "</b>";
}

/*function berekenBMI() {
   

    fetch("http://127.0.0.1:3000/")
        .then(response => { 
            if(response.ok) return response.text();
            else alert("foutje"); 
        })
        .then(showData);
    return false;
}
*/

class RangeData {
    city = "";
    country = "";
    battery = "";
}

function readData(rangeData) {
    rangeData.city = document.getElementById('avg_city').value;
    rangeData.country = document.getElementById('avg_country').value;
    rangeData.battery = document.getElementById('bat_cap').value;
    return rangeData;
}

function calcRange() {
    var rangeData = new RangeData;
    rangeData = readData(rangeData);
    var url = "http://127.0.0.1:3000/calcRange"
        fetch(url, {
            method: "POST",
            headers: {
                'Accept': 'application/json' ,
                'Content-Type': 'application/json'
                },
            body: JSON.stringify(rangeData)
            })
        .then(response => { 
            if(response.ok) return response.text();
            else {
                alert("foutje"); 
                console.log(response);
                }
            })
        .then(showData);

}

function calcCapacity() {

}