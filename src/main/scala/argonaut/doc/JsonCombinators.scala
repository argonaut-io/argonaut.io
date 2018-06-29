package argonaut.doc

import argonaut._, Argonaut._

object JsonCombinators extends App {
  // withString modifies a string value otherwise leaves the Json instance unchanged.
  val appendedString: Json =
    jString("JSO").withString(_ + "N")

  // withObject modifies an object value otherwise leaves the Json instance unchanged.
  val modifiedObject: Json =
    jSingleObject("field", jTrue).withObject(_ - "field")

  // withArray modifies an array value otherwise leaves the Json instance unchanged.
  val modifiedArray: Json =
    jSingleArray(jTrue).withArray(_ :+ jFalse)

  // get the value if, and only if, the json is a number
  val numberAccess: Option[JsonNumber] =
    jNumber(20).number

  // get the value if, and only if, the json is a boolean
  val booleanAccess: Option[Boolean] =
    jTrue.bool

  // get the value if, and only if, the json is a string
  val stringAccess: Option[String] =
    jTrue.string

  // get the value if, and only if, the json is an array
  val arrayAccess: Option[List[Json]] =
    jSingleArray(jTrue).array

  // get the value if, and only if, the json is an object
  val objectAccess: Option[JsonObject] =
    jSingleObject("field", jTrue).obj

  // pluck a field out of nested json structures
  val nestedObjectAccess: Option[Json] =
    jSingleObject("field",
      jSingleObject("nested", jTrue)) -|| List("field", "nested")

  // Many more in Json.scala -->
  // https://github.com/argonaut-io/argonaut/blob/v6.2.2/argonaut/shared/src/main/scala/argonaut/Json.scala
}
