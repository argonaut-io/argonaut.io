package argonaut.doc

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object JsonHCursor extends App {
  // Create a two level nested object.
  val innerObject: Json =
    ("innerkey1", jString("innervalue1")) ->:
    ("innerkey2", jString("innervalue2")) ->:
    jEmptyObject

  val complexObject: Json =
    ("outerkey1", innerObject) ->:
    ("outerkey2", jFalse) ->:
    jEmptyObject

  // The history basic cursor, handle traversal management yourself
  val cursor = complexObject.hcursor

  val updated = (cursor --\ "outerKey" --\ "innerkey2").withFocus(
    _.withString(_ + " is innervalue2")
  )

  println("we traversed: " + updated.history.shows)

  println("we got: " + updated.undo)

  // Handle failure cases

  val lastSuccess =
    (cursor --\ "outerKey" --\ "innerkey2" --\ "oops" --\ "off the rails").reattempt.focus

  val firstSuccess =
    (cursor --\ "outerKey" --\ "oldkey2") ||| (cursor --\ "outerKey" --\ "newkey2")
}
