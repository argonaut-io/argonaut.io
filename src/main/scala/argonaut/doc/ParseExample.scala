package argonaut.doc

import argonaut._

object ParseExample extends App {

  val json = """
    { "name" : "Toddler", "age" : 2, "greeting": "gurgle!" }
  """

  // Parse getting either error message or json
  val result: Either[String, Json] =
    Parse.parse(json)

  // Parse ignoring error messages
  val option: Option[Json] =
    Parse.parseOption(json)

  // Parse handling success and failure with functions
  val greeting1: String =
    Parse.parseWith(json, _.field("greeting").flatMap(_.string).getOrElse("Hello!"), msg => msg)

  // Parse handling success and providing a default for failure
  val greeting2: String =
    Parse.parseOr(json, _.field("greeting").flatMap(_.string)getOrElse("Hello!"), "Oi!")

}
