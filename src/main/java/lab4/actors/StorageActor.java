package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.GetMessage;
import lab4.assists.PutMessage;
import lab4.assists.ResultMessage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, ArrayList<String>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(PutMessage.class, r -> {
                    ArrayList<String> results = storage.get(r.getPackID());
                    if(results != null) results.add(r.getResult());
                })
                .match(GetMessage.class, r ->
                        sender().tell(new ResultMessage(r.getPackID(), storage.get(r.getPackID())), self()))
                .build();
    }
}
