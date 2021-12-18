package lab4.actors;

import akka.actor.*;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;

import java.util.ArrayList;
import java.util.List;

public class RouterActor extends AbstractActor {
    private ActorRef storage;

    public RouterActor() {
        storage = getContext().actorOf(Props.create(StorageActor.class), STORAGE_NAME);
        getContext().watch(storage);

        List<Routee> routees = new ArrayList<Routee>();
        for (int i = 0; i < 5; i++) {
            ActorRef r = getContext().actorOf(Props.create(ExecutorActor.class));
            getContext().watch(r);
            routees.add(new ActorRefRoutee(r));
        }
    }

    public Receive createReceive() {
        return ReceiveBuilder.create()
    }
}
