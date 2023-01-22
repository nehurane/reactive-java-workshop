package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),//terminal event
                () -> System.out.println("Completed!")//terminal event
        );
        
        ReactiveSources.userMono().subscribe(
                user -> System.out.println(user),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete!")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
    
static class MySubscriber<T> extends BaseSubscriber<T> {
   public void hookOnSubscribe(Subscription subscription) {
       System.out.println("Subscribe Happened");
       request(2);
   }
   
   public void hookOnNext(T value){
       System.out.println(value.toString() + " received ");
       request(1);
   }
}

}