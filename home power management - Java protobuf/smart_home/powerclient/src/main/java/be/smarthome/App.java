package be.smarthome;

import be.smarthome.PowerManagementServiceGrpc.PowerManagementServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();
        PowerManagementServiceBlockingStub stub 
            = PowerManagementServiceGrpc.newBlockingStub(channel);

        PowerConsumer consumerResponse1 = stub.newSolarProductionValue(SolarProduction.newBuilder()
            .setSolarProductionValue(7)
            .build());
        System.out.println("Set solar production value:");
        System.out.println(consumerResponse1);
        System.out.println(" ");
        
        System.out.println("Set power consumption value:");
        PowerConsumer consumerResponse2 = stub.newPowerConsumptionValue(PowerConsumption.newBuilder()
            .setPowerConsumptionValue(7)
            .build());
        System.out.println(consumerResponse2);   

        channel.shutdown();
    }
}
