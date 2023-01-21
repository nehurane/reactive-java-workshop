package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        // Get the value from the Mono into an integer variable
        Optional<Integer> num = ReactiveSources.intNumberMono().blockOptional();
        
        User userM = ReactiveSources.userMono().block();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
