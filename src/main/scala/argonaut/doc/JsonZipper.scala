package argonaut.doc

import argonaut._, Argonaut._

object JsonZipper extends App {
  // Create a two level nested object.
  val innerObject: Json =
    ("innerkey1", jString("innervalue1")) ->:
    ("innerkey2", jString("innervalue2")) ->:
    jEmptyObject

  val complexObject: Json =
    ("outerkey1", innerObject) ->:
    ("outerkey2", jFalse) ->:
    jEmptyObject

  // The basic cursor, handle traversal management yourself
  val cursor = complexObject.cursor

  val updatedJson: Option[Json] = for {
    // Drill down into the outerkey1 field.
    outerkey1Field <- cursor.downField("outerkey1")

    // Drill down into the innerkey2 field.
    innerkey2Field <- outerkey1Field.downField("innerkey2")

    // Update the Json element we're focused on.
    updatedInnerkey2Field = innerkey2Field.withFocus(
      _.withString(_ + " is innervalue2")
    )

  // Unwinds to the top and returns Json.
  } yield updatedInnerkey2Field.undo

  println(updatedJson)
}
