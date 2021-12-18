package lab4.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {
    public RouterActor() {
        storage = getContext().actorOf(Props.create(StorageActor.class), STORAGE_NAME);
        getContext().watch(storage);
    }

    public Receive createReceive() {
        return ReceiveBuilder.create()
    }
}
