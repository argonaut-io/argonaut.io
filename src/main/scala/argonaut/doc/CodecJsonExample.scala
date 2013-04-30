package argonaut.doc

import argonaut._, Argonaut._

object CodecJsonExample extends App {

  case class Person(name: String, age: Int)

  // Explicit CodecJson instance.

  implicit def PersonCodecJson: DecodeJson[Person] =
    CodecJson(
      (p: Person) =>
        ("name" := p.name) ->:
        ("age" := p.age) ->:
        jEmptyObject,
      c => for {
        name <- (c --\ "name").as[String]
        age <- (c --\ "age").as[Int]
      } yield Person(name, age))
}
