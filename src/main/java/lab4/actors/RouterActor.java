package lab4.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class RouterActor extends AbstractActor {
    public RouterActor() {}

    public Receive createReceive() {
        return ReceiveBuilder.create()
    }
}
