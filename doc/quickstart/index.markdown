---
layout: default
title: argonaut
---

<div id="main">

  <script type="text/javascript">
    examples([
    'QuickStartExample',
    'RequestResponse'
    ]);
  </script>

  <h1>Quick Start</h1>

  <div id="content">

    <h2>Using Argonaut with SBT</h2>

    <p>Depending on argonaut with sbt, stable:</p>
    <pre>"io.argonaut" %% "argonaut" % "6.0-M6" </pre>
    <p>Depending on argonaut with sbt, latest:</p>
    <pre>"io.argonaut" %% "argonaut" % "6.0-SNAPSHOT" changing()  </pre>

    <h2>What your code will look like?</h2>

    <p>
      To get a feel for the power of argonaut. We present the following
      example that leverages the parser, codecs and zipper to process.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_QuickStartExample">
    </pre>

    <p>
    The remainder of the documentation will build up from the basics to
    give you a complete understanding of the API.
    </p>


    <h2>A Starting Example</h2>

    <p>
      As JSON tends to be at the boundary of most services the common case
      is to process some values from JSON, do some computation with said
      values and then produce more JSON for a response.
    </p>

    This example works directly with the json, skipping the convenience of
    using codecs and the zipper:

    <pre class="prettyprint lang-scala linenums" id="example_RequestResponse">
    </pre>

  </div>

</div>
