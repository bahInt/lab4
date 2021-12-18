package lab4.actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import lab4.messages.ExecMessage;
import lab4.messages.PutMessage;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), self());

    private String execute(ExecMessage r) {
        String result;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }

    private void sendToStorage(ExecMessage r) {
        sender().tell(new PutMessage(r.getPackID(), execute(r)), self());
    }


    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ExecMessage.class, this::sendToStorage)
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }
}