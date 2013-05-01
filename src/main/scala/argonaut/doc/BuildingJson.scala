package argonaut.doc

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object BuildingJson extends App {
  // Strings are straight forward, but include a few conveniences
  val jsonString: Json       = jString("JSON!")
  val jsonEmptyString: Json  = jEmptyString

  // Numbers again are straight forward
  val jsonNumber: Json       = jNumber(20)
  val jsonZero: Json         = jZero

  // Null
  val jsonNull: Json         = jNull

  // Booleans
  val jsonBoolean: Json      = jBool(true)
  val jsonTrue: Json         = jTrue
  val jsonFalse: Json        = jFalse

  // Arrays
  val jsonArray: Json =
    jArray(List(jsonNumber, jsonString))

  // Object
  val jsonObject: Json =
    jObjectAssocList(List(("key1", jsonNumber), ("key2", jsonString)))

  // Arrays and object creation can be cleaned up with a cons style
  // syntax for clarity and flexibility

  val jsonArrayBuilder: Json =
    jsonString -->>: jsonNumber -->>: jEmptyArray

  val jsonObjectBuilder: Json =
    ("key1", jsonNumber) ->: ("key2", jsonString) ->: jEmptyObject


  // Taking this a step further, we can use codecs to help define objects
  // Note the `:=` operator which takes the value on the right and uses
  // the its corresponding type class to convert it to json.

  val jsonObjectWithCodec: Json =
    ("key1" := 3) ->: ("key2" := "hello") ->: jEmptyObject


  // Often you want to conditionally add a field, in this case
  // the field `option` is only added to the object if the value
  // is set. Note the `:=?` operator which constructs an (String, Option[Json])
  // pair, and the '->?:' operator which will conditionally prepend
  // the field to the object.

  val jsonObjectWithCodecAndOptionals: Json =
    ("key1" := 3) ->: ("option" :=? none[String]) ->?: jEmptyObject

  // The alternative to this, would include the field in the object
  // but set its value to null in the None case.

  val jsonObjectWithCodecAndNullFields: Json =
    ("key1" := 3) ->: ("option" := none[String]) ->: jEmptyObject
}
