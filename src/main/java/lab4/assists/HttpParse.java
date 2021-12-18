package lab4.assists;

import akka.actor.ActorRef;
import akka.http.javadsl.server.Route;

import static akka.http.javadsl.server.Directives.parameter;

public class HttpParse {
    private final ActorRef router;

    public HttpParse(ActorRef router) {
        this.router = router;
    }

    public Route createRoute() {
        return route(
                get(() -> parameter("packageID", (pID) -> {]
                    ));
    }
}
