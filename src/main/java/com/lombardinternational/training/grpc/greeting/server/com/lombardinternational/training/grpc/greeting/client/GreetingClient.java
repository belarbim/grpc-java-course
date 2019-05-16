package com.lombardinternational.training.grpc.greeting.server.com.lombardinternational.training.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm the client");


        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .build();

        final DummyServiceGrpc.DummyServiceBlockingStub dummyServiceBlockingStub = DummyServiceGrpc.newBlockingStub(channel);
        System.out.println("ShutingDown channel");
        channel.shutdown();
    }
}
