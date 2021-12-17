package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.TestData;

import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, String> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestData.class, r -> {
                    storage.put(r.getPackID(), r.getResult());
                })
                .build();
    }
}
