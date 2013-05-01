package argonaut.doc

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object DecodeExample extends App {
  case class Person(name: String, age: Int, greeting: String)

  implicit def PersonCodecJson: CodecJson[Person] =
    casecodec3(Person.apply, Person.unapply)("name", "age", "greeting")

  val json = """
    { "name" : "Toddler", "age" : 2, "greeting": "gurgle!" }
  """


  // Decode ignoring error messages
  val option: Option[Person] =
    Parse.decodeOption[Person](json)

  // Decode getting either error message or value (ignoring if it was parse or decode error)
  val result1: String \/ Person =
    Parse.decodeEither[Person](json)

  // Decode getting validation of error message or value
  val result2: Validation[String, Person] =
    Parse.decodeValidation[Person](json)

  // Decode getting either parse error message or decode error message with history or value
  val result3: (String \/ (String, CursorHistory)) \/ Person =
    Parse.decode[Person](json)

  // decode handling success and parse failure and decode failure with functions
  val greeting1: String =
    Parse.decodeWith[String, Person](json,
      _.greeting,
      msg => "got an error parsing: " + msg,
      { case (msg, history) => "got an error decoding: " + msg + " - " + history.shows }
    )

  // decode handling success and either parse failure or decode failure with functions
  val greeting2: String =
    Parse.decodeWithEither[String, Person](json,
      _.greeting,
      {
        case -\/(msg) => "got an error parsing: " + msg
        case \/-((msg, history)) => "got an error decoding: " + msg + " - " + history.shows
      }
    )

  // decode handling success and failure message (ignoring if it was parse or decode).
  val greeting3: String =
    Parse.decodeWithMessage[String, Person](json, _.greeting, msg => "got an error: " + msg)

  // decode handling success and or providing a default for failure
  val greeting4: String =
    Parse.decodeOr[String, Person](json, _.greeting, "howdy")
}
