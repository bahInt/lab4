package lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.pattern.Patterns;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import lab4.actors.RouterActor;

import java.util.concurrent.CompletionStage;

public class TaskTestingApp {
    private static final int PORT = 8088;
    private static final String HOST = "localhost";
    private static final String SYS_NAME = "webtest";
    private static final Object LOG_SOURCE = System.out;

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create(SYS_NAME);
        ActorRef routerActor = system.actorOf(Props.create(RouterActor.class), "router");
        LoggingAdapter l = Logging.getLogger(system, LOG_SOURCE);
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        //final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
        //final CompletionStage<ServerBinding> binding = http.bindAndHandle()
        System.out.printf("Server online at https://%s%d/\nPress ENTER to stop\n", HOST, PORT);
        System.in.read();
        //binding.thenCompose(ServerBinding::unbind).thenAccept(unbound -> system.terminate());

    }
}
