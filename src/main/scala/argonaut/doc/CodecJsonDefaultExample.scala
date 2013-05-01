package argonaut.doc

import argonaut._, Argonaut._, CodecJson._

object CodecJsonDefaultExample extends App {

  case class Person(name: String, age: Int)

  // Default CodecJson instance for case classes.

  implicit def PersonCodecJson: DecodeJson[Person] =
    casecodec2(Person.apply, Person.unapply)("name", "age")

  // Note that casecodec2 makes assumptions about the unapply
  // method (namely that it will always return Some), for a
  // an exmplic version of this see:

  def ExplicitPersonCodecJson: DecodeJson[Person] =
    codec2(Person.apply, (Person.unapply _) andThen (_.get))("name", "age")
}
