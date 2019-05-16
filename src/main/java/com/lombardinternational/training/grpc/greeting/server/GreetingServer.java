package com.lombardinternational.training.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC server");

        //Initiate the server
        final Server server = ServerBuilder.forPort(50051)
                .build();

        //start the server and define that the server has to received the order termination to stop
        server.start();
        Runtime.getRuntime().addShutdownHook( new Thread(() -> {
            System.out.println("Shutdown order received");
            server.shutdown();
            System.out.println("Server shutdown");
        }));


        server.awaitTermination();
    }
}
