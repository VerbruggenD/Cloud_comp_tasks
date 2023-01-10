package be.smarthome;

import be.smarthome.PowerManagementServiceGrpc.PowerManagementServiceImplBase;

public class PowerManagementServiceImpl extends PowerManagementServiceImplBase {

    public void newSolarProductionValue(be.smarthome.SolarProduction request, 
            io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> observer) {
        Integer solarProductionValue = request.getSolarProductionValue();

        // generate static fake power consumers

        int consumption = 5;

        boolean enabled = false;
        if ((solarProductionValue - consumption) >= 3) {
            enabled = true;
        }

        PowerConsumer response = PowerConsumer.newBuilder()
                .setId("wasmachine")
                .setThreshold(3)
                .setEnabled(enabled)
                .setCriticalDevice(true)
                .build();

        observer.onNext(response);
        observer.onCompleted();
    }

    public void newPowerConsumptionValue(be.smarthome.PowerConsumption request,
            io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> observer) {
        Integer powerConsumptionValue = request.getPowerConsumptionValue();

        // generate static fake power consumers

        int production = 7;

        boolean enabled = false;
        if (powerConsumptionValue - production >= 3) {
            enabled = true;
        }

        PowerConsumer response = PowerConsumer.newBuilder()
            .setId("wasmachine")
            .setThreshold(3)
            .setEnabled(enabled)
            .setCriticalDevice(true)
            .build();

        observer.onNext(response);
        observer.onCompleted();
    }
    
}
