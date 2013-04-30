---
layout: default
title: argonaut
---

<div id="main">

  <script type="text/javascript">
    examples([
    'ParseExample',
    'DecodeExample'
    ]);
  </script>

  <h1>Json Parsing</h1>

  <div id="content">

    <p>
      There is a full suite of parsing and decoding operations. Each operation
      can be called directly via `Parse` or via a syntax implicit on `Strings`.
      The parse operations are also designed to be cleanly added as syntax to third-party
      libraries in a consistent form (see <a href="/doc/integration">argonaut-unfilterd</a>
      for an example.
    </p>


    <h2>Parsing</h2>

    The parse operations convert an input into a `Json` data type with
    various error-handling mechanims.

    <pre class="prettyprint lang-scala linenums" id="example_ParseExample">
    </pre>

    <h2>Parsing and Decoding</h2>

    The decode operations convert an input into a `Json` data type, and
    then attempt to decode the json using a `Codec` with various error-handling mechanims.

    <pre class="prettyprint lang-scala linenums" id="example_DecodeExample">
    </pre>

  </div>
</div>
