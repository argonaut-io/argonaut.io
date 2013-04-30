package argonaut.doc

import argonaut._, Argonaut._

object EncodeJsonExample extends App {

  case class Person(name: String, age: Int)

  // Explicit EncodeJson instance using the object builder syntax
  //   (See http://argonaut.io/doc/json for more detail).

  implicit def PersonEncodeJson: EncodeJson[Person] =
    EncodeJson((p: Person) =>
      ("name" := p.name) ->: ("age" := p.age) ->: jEmptyObject)
}
