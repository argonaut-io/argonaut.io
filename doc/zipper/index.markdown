---
layout: default
title: argonaut
---

<div id="main">

  <script type="text/javascript">
    examples([
    'LensExample',
    'JsonZipper',
    'JsonHCursor',
    ]);
  </script>

  <h1>Json Access, Traversal and Update</h1>

  <div id="content">

    <h2>Lenses</h2>

    <p>
      Argonaut includes lenses as a method of accessing and updating fields within instances of the Json type,
      as lenses compose it's also possible to modify deeply nested fields.
    </p>

    <p>
      Lenses are provided in the <code>argonaut-monocle</code> package.
    </p>

    <p>
      Note that Json is an immutable data type modification using lenses produces new values each time.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_LensExample">
    </pre>


    <h2>Cursor</h2>

    <p>
      A <a href="http://argonaut.io/scaladocs/#argonaut.Cursor">Cursor</a> (otherwise known as a zipper)
      provides the ability to move around the structure of the Json as if it were structured as a tree.
      Operations like left and right are available to move forwards and backwards through a JSON array.
      The downField method drops down into a given field of an object. Methods that modify elements
      such as delete or withFocus operate in relation to the current position of the cursor.
    </p>

    <p>
      The <a href="http://argonaut.io/scaladocs/#argonaut.Cursor">Cursor</a> is the most
      primitive zipper, but allowing access to traversal and update, but forces you to
      handle potential failure (using Option).
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_JsonZipper">
    </pre>

    <h2>History Cursor and Attempt</h2>

    <p>
      A <a href="http://argonaut.io/scaladocs/#argonaut.HCursor">HCursor</a> (History Cursor)
      works with an <a href="http://argonaut.io/scaladocs/#argonaut.ACursor">ACursor</a>
      to provide a more convenient chaining of operations and also allow for more
      advanced tracking of operations and potential recovery from failure.
    </p>
    <p>
      The <a href="http://argonaut.io/scaladocs/#argonaut.Cursor">Cursor</a> is the most
      primitive zipper, but allowing access to traversal and update, but forces you to
      handle potential failure (using Option).
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_JsonHCursor">
    </pre>

  </div>

</div>
