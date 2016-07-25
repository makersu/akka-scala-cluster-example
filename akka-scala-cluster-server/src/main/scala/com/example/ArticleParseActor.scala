package com.example

import akka.actor.Actor
/**
  * Created by marksu on 7/24/16.
  */
class ArticleParseActor extends Actor{
  override def receive: Receive = {
    case htmlString: String =>
      println("htmlString!")
      val body: String = ArticleParser(htmlString)
      sender() ! body
    case _ =>
      println("msg!")
  }
}

object ArticleParser {
  def apply(html: String) : String =
    de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(html)
}
