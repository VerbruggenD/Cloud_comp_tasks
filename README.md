# Cloud_comp_tasks
This repo hosts my API tasks for the Masters course "Cloud computing" for University Hasselt and Catholic University Leuven. 

The instruction is to create 8 API with different languages, frameworks and methods. With 5x a service based on the combinations of the course and 3x a mix and match of language and method.

## Docker images
The Docker images can be found on my docker hub repository "cloud_computing".
https://hub.docker.com/repository/docker/dieterverbruggen/cloud_computing/
All images are available in the same repo with the tags specifying which image it is.
The individual pull requests are available in the readmes of the projects. The same goes for the other docker commands.

## 5x API structure from the course:
  1. Rest with php in laravel
 	- fineCalculator with database
  2. Soap with C# in .NET
  	- Hybrid efficiency calc
  3. Websocket with node.js
  	- group ride communication app
  4. GraphQL with python
	- movie and series search engine across streaming platforms
  5. Protobuf with Java
	- smart home power management
  
## 3x API structure not from the course:
1. Rest met python: html for bootstrap generator
2. Rest met node.js en express	-> electric range calculation (based on Temp)
3. 3. ..........
  
## Delivery of the APIs:
- The laravel project including the SQL database needs to be presented during an online meet.
- One project needs to be enclosed in a virtual machine, this also is presented in the online meet.
- From the remaining APIs 4 of them need to be enclosed in a docker.
- The remaining APIs only need to be zipped with minimal steps to extract them and run. If the process to deploy the API on a different device is to complex and prone for problems it is recommended to use a docker.

## 4x docker:
- Node.js rest: electric range calculation
- Node.js websockets: group ride communication app
- Python graphQL: movie and series search engine across streaming platforms
- Python rest: html for bootstrap generator
  
## General idea of the APIs, not consistend with the application (due to complexity and time limit)
1. FineCalculator with database:
  - Calculating fines for the driver's projected income based on value of the car.
  - To make the process of fining people more faire based on income, to eliminate the lawlessnes for the rich.
  - In the project included is a database and extensive consumer where the user can select the make and model of the care with selection boxes.
  
2. Hybrid efficiency calculator:
  - Tries to solve the problem of todays age that the electric consumption of hybrid cars is not so efficient than manufacturers claim.
  - By using learned data over a period it is possible to calculate the most efficient method of driving based on distance in a certain speed range.
  - Is very important because the limits of todays technologies, currently the mode of electric and combined must be selected manually.
  - In the project included is a method to calc which mode is more efficient based on range data and a trip consisting of:
  - Km's on highway, city and country

3. Group ride communication app:
  - Is a way of communicating when a few cars are doing a group ride or trip.
  - It is possible to send messages.
  - It is possible to poll for a change of plans, which are:
  	- Request a waypoint during the ride (for bathroom breaks, getting fod, etc)
   	- Request to change the destination
  - Then based on the outcome of the poll the destination in GPS can be automatically changed (this is not implemented).
  
4. Html for bootstrap generator:
  - Help developers to generate a standard template for their website to accelerate the development.
  - With the use of bootstrap a structure is made using rows and columns.
  - In the fields are the inputs and outputs placed or styling like pictures.
  - With standard snippets this structure can be generated and nested in the correct order.
  - In this project is the actual fields not implemented due to complexity and time limit but can be integrated in the same way.
  - The instructions for generation are as followed, ['row', 'col', 'row', 'col', 'end'] where the order of these instruction defines the structure.
  
5. Electric range calculator:
  - This API tries to calculate a very important flaw of electric and hybrid vehicules, the reduced range due to weather conditions.
  - It is very important to know the range based on temperature outside.
  - This can give more information about which heating options can be used for your trip to ensure a comfortable ride while still reaching the destination.
  - The implementation of the heating options is not implemented, only the reduction in apparent battery capacity.
  
6. Movie and series search engine across streaming platforms:
  - This API tries to solve the hassle of having multiple subsciptions to streaming services but not knowing wat you want to watch.
  - By searching the services from one engine the user experience can be dramatically improved.
  - The content will still be launched on the corresponding service.
  - This project only searches the content on fake streaming services. Return a fake link of the content.

7. Smart power management service:
  - This API tries to solve one of the problems with solar production being in the day and most people work in the day
  - Also tries to solve a big problem in Belgium called "capaciteits tarief" for billing more for energy in peak moments
  - A faked implementation of devices being turned on/off based on solar production and power consumption
  - Based on a threshold of the device and difference in energy the device will turn on and off
  - Important datafield is 'critical' some devices use a cycle and may not be turned whenever

8. Hier nog iets
