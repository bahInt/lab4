package lab4.actors;

import akka.actor.*;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {
    private ActorRef storage;

    public RouterActor() {
        storage = getContext().actorOf(Props.create(StorageActor.class), STORAGE_NAME);
        getContext().watch(storage);
    }

    public Receive createReceive() {
        return ReceiveBuilder.create()
    }
}
