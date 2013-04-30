package argonaut.doc

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object RequestResponse extends App {
  val requestJson =
    """
      |{
      |   "userid": "1"
      |}
      |""".stripMargin

  // parse the json and prepend a name field
  val updatedJson: Option[Json] = for {
    parsed <- requestJson.parseOption
  } yield ("name", jString("testuser")) ->: parsed

  // If there was a failure at any point, provide a default.
  val responseJson: Json = updatedJson.getOrElse{
    jSingleObject("error", jString("Something went wrong."))
  }

  println(responseJson.nospaces)
}
