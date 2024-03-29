package lab4.assists;

import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.util.Timeout;
import lab4.messages.GetMessage;
import scala.concurrent.Future;

import java.time.Duration;


import static akka.http.javadsl.server.Directives.*;

public class HttpParse {
    private final ActorRef router;
    private final static Timeout TIMEOUT = Timeout.create(Duration.ofSeconds(5));
    private static final String SUCCESS_MSG = "Tests executed and stored";

    public HttpParse(ActorRef router) {
        this.router = router;
    }

    public Route createRoute() {
        return route(
                get(() -> parameter("packageID", (pID) -> {
                    Future<Object> future = Patterns.ask(router, new GetMessage(pID), TIMEOUT);
                    return completeOKWithFuture(future, Jackson.marshaller());
                })),
                post(() -> entity(Jackson.unmarshaller(PackageData.class),msg -> {
                    router.tell(msg, ActorRef.noSender());
                    return complete(SUCCESS_MSG);
                }))
        );
    }
}
