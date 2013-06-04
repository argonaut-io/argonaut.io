package argonaut.doc

import scalaz._, Scalaz._
import argonaut._, Argonaut._


object QuickStartExample extends App {
  val input = """
    [
      { "name": "Mark", "age": 191 },
      { "name": "Fred", "age": 33, "greeting": "hey ho, lets go!" },
      { "name": "Barney", "age": 35, "address": {
        "street", "rock street", "number": 10, "post_code": 2039
      }}
    ]
  """

  // parse the string as json, attempt to decode it to a list of person,
  // otherwise just take it as an empty list.
  val people = input.decodeOption[List[Person]].getOrElse(Nil)

  // work with your data types as you normally would
  val nice = people.map(person =>
    person.copy(greeting = person.greeting.orElse(Some("Hello good sir!"))))

  // convert back to json, and then to a pretty printed string, alternative
  // ways to print may be nospaces, spaces2, or a custom format
  println(nice.asJson.spaces4)
}


case class Address(street: String, number: Int, postcode: Int)

object Address {
  // Define codecs easily from case classes
  implicit def AddressCodecJson: CodecJson[Address] =
    casecodec3(Address.apply, Address.unapply)("street", "number", "post_code")
}

case class Person(name: String, age: Int, address: Option[Address], greeting: Option[String])

object Person {
  implicit def AddressCodecJson: CodecJson[Person] =
    casecodec4(Person.apply, Person.unapply)("name", "age", "address", "greeting")
}
