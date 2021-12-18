package lab4.actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import lab4.messages.ExecMessage;
import lab4.messages.PutMessage;

public class ExecutorActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), self());

    private void sendToStorage(ExecMessage r) {
        sender().tell(new PutMessage(r.getPackID()));
    }


    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ExecMessage.class, this::sendToStorage)
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }
}