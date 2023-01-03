# Electric range calculator based on temperature
This API calculates the range of a electric powered vehicle based on the outside temperature.
Normally, the temperature would be loaded using a weather service API. In this case, the temperature is a random generated value between -10 and 35 degrees Celsius.

## Functionality
- The user can use 2 different methods, the old way is to use the mileage in the country and city. The new way is using WLTP, it is a standard for fully or partially electric powered vehicles.
- Then using the normal capacity of the battery, the effective average range is calculated.
- Another feature is to also be able to calculate the equivalent battery capacity, this was not implemented in this task.