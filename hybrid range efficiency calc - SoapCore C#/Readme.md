# Hybrid range efficiency calculator

This project estimates the power consumption of a hybrid powered car based on average consumption on highway, city and country roads. To determine which hybrid mode is best suited for the trip with the parameters of kilometers on highway, city and country. The idea behind this is to make hybrid vehicles use their power modes more efficiently, this is today certainly not the case based on personal experience. The current idea of the manufacturers seams that they are required to make hybrid vehicles, but they don't seam to have the motivation to do it well. The future works of this API would be adding a small database of the frequent trips the user drives and the characteristics of the power consumption for the driver. This service could then be implemented in driving apps such as GoogleMaps and Waze. If car manufacturers would open up the hybride mode selection to their application it could be automatically switched when driving. With a learning model implemented that predicts the destination while driving while keeping in mind the possible traffick jams and construction sites this has the potential to increase the efficiency by quite a lot.

## Delivery
This service is hosted on Microsoft Azure, but is not always available to save credits. The link to acces the WSDL directly is given here: `https://smarthybridsoap.azurewebsites.net/Service.asmx`

For this API, I wrote a server-side consumer in PHP using bootstrap for the form in html wich then redirects to the PHP page with the outputs of the service also with bootstrap. Only the create hybrid is used in this consumer due to the time limitations, the calculate efficiency would be done in the exact same way but needs more string replace (reference to php code) and this took a lot of time to insert into the bootstrap code. This consumer is hosted in the XAMPP htdocs on my machine and local only.

## Information about this project
I implemented 3 classes:
- Energie
- Hybrid
- Range

Energie is just a class to create the hybrid more easily, by creating 2 energie classes "electric" and "petrol". Range is then used in the implementation. There is the possibility to create a hybrid and to calculate the the most efficient hybrid mode.

For a real application the electric range should also be considered to maybe switch modes during the trip. And then there should also be a third option for driving in combined mode. For now the calculator only gives a result for starting the trip and to complete it in one mode.

## More future ideas
The cost of energy could also be included to help in todays age with reducing energy cost. We are now at a time that driving fully electric or on petrol almost is the same price per kilometer.