package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.GetMessage;
import lab4.assists.PutMessage;

public class ExecutorActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(PutMessage.class, r -> {
                    storage.put(r.getPackID(), r.getResult());
                })
                .match(GetMessage.class, r ->
                        sender().tell(new PutMessage(r.getPackID(), storage.get(r.getPackID())), self()))
                .build();
    }
