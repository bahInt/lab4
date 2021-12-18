package lab4.actors;

import akka.actor.*;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import lab4.assists.PackageData;

import java.util.ArrayList;
import java.util.List;

public class RouterActor extends AbstractActor {
    private static final String STORAGE_NAME = "storage";

    private Router router;
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
        router = new Router(new RoundRobinRoutingLogic(), routees);
    }

    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(PackageData.class, this::executeTests)
                .match()
                .matchAny(o -> log.info("recieved unknown message")
                .build();
    }
}
