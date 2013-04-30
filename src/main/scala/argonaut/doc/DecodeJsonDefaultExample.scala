package argonaut.doc

import argonaut._, Argonaut._

object DecodeJsonDefaultExample extends App {

  case class Person(name: String, age: Int)

  // Provide a function to convert from arguments and names for each field.
  // This constructs the most obvious codec building an object with a
  // field for each element. Note the arrity, <2>, can be anything up
  // until <22>. Note that case class apply methods fit the bill nicely.

  implicit def PersonDecodeJson: DecodeJson[Person] =
    jdecode2L(Person.apply)("name", "age")
}
