package controllers;

import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.cluster.Cluster;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import scala.compat.java8.FutureConverters;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    
	ActorSystem system;

	@Inject
    public HomeController(ActorSystem actorSystem) {
		this.system = actorSystem;
        this.system.actorOf(SimpleClusterListener.props(), "client");
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        Cluster cluster = Cluster.get(system);
        List<Address> addresses = Arrays.asList("akka-seed-0.akka-seed", "akka-seed-1.akka-seed")
                .stream()
                .map(ip -> new Address("akka.tcp", "ClusterSystem", ip, 2551))
                .collect(Collectors.toList());
        cluster.joinSeedNodes(addresses);
    }

    public CompletionStage<Result> ping() {
		System.out.println("akka.tcp://ClusterSystem@" + ClusterMembers.get("worker") + ":2551/user/worker");
        ActorSelection selection = system.actorSelection("akka.tcp://ClusterSystem@" + ClusterMembers.get("worker") + ":2551/user/worker");
		
		return FutureConverters.toJava(Patterns.ask(selection, new String(), 60000))
                .thenApply(val -> {
                    return Results.ok("PING SUCCESSFUL - AWESOME CLUSTERED SERVICE IS UP");
                }).exceptionally(t -> {t.printStackTrace(); return Results.internalServerError();});
    }
}
