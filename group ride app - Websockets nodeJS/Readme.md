# One trip - groupride interface
This communication platform is designed for car rides with multiple cars.
You can send messages across cars, you can poll changes of destination or a waypoint for food, drinks and so forth.
This API would then be integrated with a GPS app on mobile phones like waze or google maps for automatic change of course.

## Fumctionality:
- changing names
- sending text messages
- polling changes of destinations:
    - for the destination
    - for a waypoint
    - only accepted if everyone said 'yes''
    - times out automatically

Everything is also logged server or client side for the possible lacking finish of the client side consumer.
This API is the most fully developed task of the cloud computing tasks and took by far the most time.
The protocol is on both sides tested and developed, the only bug I can think of right now is that the polls can overlap and this results in ignoring the first poll.