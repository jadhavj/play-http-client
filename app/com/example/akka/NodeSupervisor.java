package com.example.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.AbstractActor;
import akka.actor.AbstractActor.Receive;
import akka.routing.ConsistentHashingRouter.ConsistentHashableEnvelope;
import java.time.*;

public class NodeSupervisor extends AbstractActor {

	
	/** The node worker. */
	ActorRef nodeWorker = getContext().actorOf(Props.create(NodeWorker.class));

	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
		.match(String.class, message -> {
			System.out.println("Message processed by SUPERVISOR ACTOR " + getSelf() + " @ " + LocalDateTime.now() + "\n");
			nodeWorker.tell(message, getSender());
		})
		.matchAny(message -> unhandled(message))
		.build();
	}

}
		