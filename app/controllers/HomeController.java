package controllers;

import play.mvc.*;
import scala.compat.java8.FutureConverters;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import com.google.inject.Inject;
import akka.pattern.Patterns;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    ActorSystem system;

    public CompletionStage<Result> ping() {
        ActorSelection selection = system.actorSelection("akka:tcp://ClusterSystem@akka-worker:2551/user/worker");
		
		return FutureConverters.toJava(Patterns.ask(selection, new String(), 60000))
                .thenApply(val -> {
                    return Results.ok("PING SUCCESSFUL - AWESOME CLUSTERED SERVICE IS UP");
                }).exceptionally(t -> {t.printStackTrace(); return Results.internalServerError();});
    }
}
