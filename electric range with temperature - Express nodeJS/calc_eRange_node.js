const express = require('express')
const cors = require('cors')
const app = express()
const port = 3000

const corsOptions = {
    origin: '*',
}

function getRandom(min, max) {
    return Math.random() * (max - min) + min;
  }

app.use(express.json());
app.use(cors(corsOptions));

app.post('/test/:test2', cors(), (req, res) => {
    const testValue = req.body.test;
    const test2 = req.params.test2;
    res.end('Hello ' + testValue + " met POST! " + test2);
})

app.post('/', cors(corsOptions), (req, res) => {
    const testValue = req.body.fullname;
    res.end('Hello ' + testValue +" met POST! ");
})

//////////////

app.post('/calcRange', cors(corsOptions), (req, res) => {
    // faking temperature instead of calling an external API function
    var temperature = getRandom(-10, 35);
    // parameters from the POST request
    const city = Number(req.body.city);
    const country = Number(req.body.country);
    const battery_capacity = Number(req.body.battery);

    // implementing the range calculation based on:
    //      - temperature
    //      - avg consumption in city or WLTP (depending on the age of the car)
    //      - avg consumption in country if car is older then 2020

    var consumption = 0;
    var WLTP = city;

    if(country == "") consumption = (((-1)/4) * temperature) + (WLTP + 10);
    else consumption = (((-1)/4) * temperature) + (city*(3/4)) + (country*(1/4)) + 2;

    var range = (battery_capacity/consumption)*100;     // (kWh / ( kWh / 100km)) = km

    //res.end("temp: " + temperature +  " consumption: " + consumption);
    res.end("range: " + range);
})

//////////////

app.get('/', cors(corsOptions), (req, res) => {
    res.send('Hello World!')
})

app.get('/test/:test', (req, res) => {
    const testValue = req.params.test;
    res.end('Hello ' + testValue + '!');
})

app.use((req, res, next) => {
    res.status(404).send(req,url + 'Not Found');
})

app.listen(port, () => {
    console.log(`Calculator listening on port ${port}`)
})
