# Smart home power management
This project is meant to switch high consuming devices on and off based on solar production to use as much self produced power as possible. And also eliminating the high costs of the "capacitiets tarieven" of Belgium by spreading the total consumption as much as possible.

## Delivery
This project is not incapsulated in a docker image or in a VM. Which makes the deployment a bit more tricky.

## Information about this project
The implementation of this project is not dynamic in the practical sense, there is no calculation of power usage in function of the solar production. But the return statement is dynamic in the strick sense, it returns everytime a different consumer. There are 2 functions which the user can use, set solar production and set power consumption. Both of these functions should then calculate what device to power on or off based on there working principle and power consumption. With working principle I mean if the device works in a cycle that cannot be interrupted. (E.g. like a dishwasher or washing machine.)