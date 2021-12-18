package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.GetMessage;
import lab4.assists.PutMessage;


import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, ArrayList<String>> storage = new Hashtable<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(PutMessage.class, r -> {
                    ArrayList<String> results = storage.get())
                .match(GetMessage.class, r ->
                        sender().tell(new PutMessage(r.getPackID(), storage.get(r.getPackID())), self()))
                .build();
    }
}
