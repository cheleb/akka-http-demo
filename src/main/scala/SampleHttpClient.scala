package client


import akka.actor.{Actor, ActorLogging}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}

import model.Person
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._


class SampleHttpClient(cb: Person => Unit) extends Actor with ActorLogging {

  val http = Http(context.system)

  import context.dispatcher

  final implicit val materializer: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(context.system))


  override def receive: Receive = {
    case id: Int =>
      import akka.pattern.pipe

      http.singleRequest(HttpRequest(uri = "http://localhost:8080/json"))
        .flatMap(s => Unmarshal(s.entity).to[Person])
        .pipeTo(self)

    case p: Person =>
      cb(p.copy(happy = true))
      context.stop(self)
      log.info("Bye bye")
    case e =>
      log.warning(s"WTF $e")

  }
}
