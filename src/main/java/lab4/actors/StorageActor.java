package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.GetMessage;
import lab4.assists.PutMessage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, ArrayList<String>> storage = new HashMap<>();

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
}
