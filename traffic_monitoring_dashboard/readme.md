# Traffic monitoring system

This API allows costumers to subscribe to traffic monitoring services and visualize it for giving realtime updates to emergency vehicles and truckers from the dispatch station. Because the service is implemeted with websockets there is a certain garantee for the updates. Also is the network status of the dashboard visualized for veryfying the status by the dispatch station. As mentioned above the focus for the integration of this service is based on subscriptions, possibilities that come to mind are waze, police reports, sensors of smart traffic lights ( for a certain amount of time no change in traffic when cars are detected), automated camera monitoring (everywhere with avg speed check zones) and feedback from public transportation drivers. Today some of these options are available or implemented in some way, but for example of public transportation. The bus drivers get updates for accidents and obstacles from other bus drivers, they use their dispatch network for that. They could easily sell that data in a form of a subscription to trucking companies and apps like waze.

## Delivery

This service is not in a docker container or similar, I am just running it from the terminal for now.

All requirements can be found in the `requirements.txt` file. 

```
pip install -r requirements.txt
python3 server.py
```

## Features
- Subscribtion based (only waze and police are available and faked)
- Can filter on subscribtions
- Real-time updates and status checking
- Event based with socketIO 
- Bootstrap client with hosting via python
- Possibility to also add your own datasharing with subscription (not implemented yet)
    - Then it is possible to reduce the bill for subscriptions based on info you deliver to the other services


As stated above, the services for data delivery to this dashboard are faked at the moment. With random streatnames and type of problem with a timer function.