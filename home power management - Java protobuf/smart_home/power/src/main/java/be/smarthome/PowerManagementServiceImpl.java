package be.smarthome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.smarthome.PowerManagementServiceGrpc.PowerManagementServiceImplBase;

public class PowerManagementServiceImpl extends PowerManagementServiceImplBase {

    public void newSolarProductionValue(be.smarthome.SolarProduction request, 
            io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> observer) {
        Integer solarProductionValue = request.getSolarProductionValue();

        // generate static fake power consumers

        int consumption = 5;

        ArrayList<String> consumerList = new ArrayList<String>();
        consumerList.add("wasmachine");
        consumerList.add("boiler");
        consumerList.add("droogkast");
        consumerList.add("thuis batterij");

        // Create a Random object
        Random rand = new Random();

        // Generate a random index
        int randomIndex = rand.nextInt(consumerList.size());

        String consumer = consumerList.get(randomIndex);

        boolean criticalDevice = false;
        if (consumer.equals("wasmachine") || consumer.equals("droogkast")) {
            criticalDevice = true;
        }

        boolean enabled = false;
        if ((solarProductionValue - consumption) >= 3) {
            enabled = true;
        }

        PowerConsumer response = PowerConsumer.newBuilder()
                .setId(consumerList.get(randomIndex))
                .setThreshold(3)
                .setEnabled(enabled)
                .setCriticalDevice(criticalDevice)
                .build();

        observer.onNext(response);
        observer.onCompleted();
    }

    public void newPowerConsumptionValue(be.smarthome.PowerConsumption request,
            io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> observer) {
        Integer powerConsumptionValue = request.getPowerConsumptionValue();

        // generate static fake power consumers

        int production = 7;

        ArrayList<String> consumerList = new ArrayList<String>();
        consumerList.add("wasmachine");
        consumerList.add("boiler");
        consumerList.add("droogkast");
        consumerList.add("thuis batterij");

        // Create a Random object
        Random rand = new Random();

        // Generate a random index
        int randomIndex = rand.nextInt(consumerList.size());

        String consumer = consumerList.get(randomIndex);

        boolean enabled = false;
        if (powerConsumptionValue - production >= 3) {
            enabled = true;
        }

        boolean criticalDevice = false;
        if (consumer.equals("wasmachine") || consumer.equals("droogkast")) {
            criticalDevice = true;
        }

        PowerConsumer response = PowerConsumer.newBuilder()
            .setId(consumer)
            .setThreshold(3)
            .setEnabled(enabled)
            .setCriticalDevice(criticalDevice)
            .build();

        observer.onNext(response);
        observer.onCompleted();
    }
    
}
