package argonaut.doc

import argonaut._, Argonaut._

object EncodeJsonDefaultExample extends App {

  case class Person(name: String, age: Int)

  // Provide a function to convert to a tuple and names for each field.
  // This constructs the most obvious codec building an object with a
  // field for each element. Note the arrity, <2>, can be anything up
  // until <22>.

  implicit def PersonEncodeJson: EncodeJson[Person] =
    jencode2L((p: Person) => (p.name, p.age))("name", "age")
}
