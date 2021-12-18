package lab4.assists;

import akka.actor.ActorRef;

public class HttpParse {
    private final ActorRef router;

    public HttpParse(ActorRef router) {
        this.router = router;
    }
}
