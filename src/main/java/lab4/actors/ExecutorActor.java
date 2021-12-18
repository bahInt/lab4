package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class ExecutorActor extends AbstractActor {
    private void sendToStorage(ExecMessage r) {
    }
}

    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ExecMessage.class, this::sendToStorage)
                
                .build();
    }
