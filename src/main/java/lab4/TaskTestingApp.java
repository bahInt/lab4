package lab4;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import java.util.concurrent.CompletionStage;

public class TaskTestingApp {
    private static final int PORT = 8088;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("webtest");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        //final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
        //final CompletionStage<ServerBinding> binding = http.bindAndHandle()
        System.out.printf("Server online at https://%s%d/\nPress ENTER to stop\n", HOST, PORT);
        System.in.read();
    }
}
