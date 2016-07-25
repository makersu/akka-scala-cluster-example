package com.example

import akka.actor.{ActorSystem, Props}
import akka.routing.BalancingPool
import akka.cluster.client.ClusterClientReceptionist

object ApplicationMain extends App {

  val system = ActorSystem("EarthClusterSystem")

  val clusterController = system.actorOf(Props[ClusterController], "clusterController")

  //router at /user/EarthService
  val earthServiceWorkers = system.actorOf(BalancingPool(5).props(Props[ArticleParseActor]), "EarthService")

  ClusterClientReceptionist(system).registerService(earthServiceWorkers)

}