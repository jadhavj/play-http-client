package com.example.akka;

import akka.actor.AbstractActor;
import akka.actor.AbstractActor.*;
import akka.pattern.Patterns;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import static akka.dispatch.Futures.future;
import scala.concurrent.*;

/**
 * The Class BulletinBoardMessageWorker.
 */
public class NodeWorker extends AbstractActor {

	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
		.match(String.class, message -> {
			System.out.println("Message processed by WORKER ACTOR " + getSelf() + " @ " + LocalDateTime.now() + "\n");
			Patterns.pipe(future(() -> {return message;}, (ExecutionContext) SimpleClusterMain.dispatcher()), SimpleClusterMain.dispatcher()).to(getSender());
		})
		.matchAny(message -> unhandled(message))
		.build();
	}
	
}
