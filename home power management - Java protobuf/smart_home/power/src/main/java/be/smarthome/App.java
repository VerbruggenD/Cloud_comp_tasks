package be.smarthome;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");

        Server server = ServerBuilder
            .forPort(8080)
            .addService(new PowerManagementServiceImpl()).build();
        server.start();
        System.out.println("Server started");
        server.awaitTermination();
    }
}
