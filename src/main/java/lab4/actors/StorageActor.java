package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.assists.GetMessage;
import lab4.assists.PutMessage;


import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, String> storage = new HashMap<>();


}
