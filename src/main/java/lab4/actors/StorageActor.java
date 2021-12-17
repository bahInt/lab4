package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class StorageActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        private Map<>

        return ReceiveBuilder.create()
                .match(TestResult.class, r -> {

                })
                .build();
    }
}
