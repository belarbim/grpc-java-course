package com.lombardinternational.training.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm the client");
        final GreetingClient greetingClient = new GreetingClient();
        greetingClient.run();

    }

    private void run() {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        callGreetServiceUnary(channel);
        System.out.println("ShutingDown channel");
        channel.shutdown();

    }

    private void callGreetServiceUnary(ManagedChannel channel) {
        final GreetServiceGrpc.GreetServiceBlockingStub greetServiceBlockingStub = GreetServiceGrpc.newBlockingStub(channel);

        final Greeting greeting = Greeting.newBuilder().setFirstName("Mohamed").setLastName("Belarbi").build();
        final GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();
        final GreetResponse greetResponse = greetServiceBlockingStub.greet(greetRequest);

        System.out.println(greetResponse.getResult());
    }
}
