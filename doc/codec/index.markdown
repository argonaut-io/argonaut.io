---
layout: default
title: argonaut
---

<div id="main">
  <script type="text/javascript">
   examples([
    'EncodeJsonExample',
    'EncodeJsonDefaultExample',
    'DecodeJsonExample',
    'DecodeJsonDefaultExample',
    'CodecJsonExample',
    'CodecJsonDefaultExample'
    ]);
  </script>


  <h1>Json Codecs</h1>

  <div id="content">

    <h2>Codecs</h2>

    There are two critical aspects to codecs, encode a data type to json, and
    decode a data type from json.

    Encoding is handled by the <code>EncodeJson</code> type class.

    Decoding is handled by the <code>DecodeJson</code> type class.

    Both can be defined at once using the <code>CodecJson</code> type class.

    <h2>EncodeJson</h2>

    <p>
      Defining an encode json instance is straight forward, you just need
      to provide a function that takes your type and produces a json
      object.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_EncodeJsonExample">
    </pre>

    <p>
      We also provide a set of very convenient methods for building EncodeJson
      instances.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_EncodeJsonDefaultExample">
    </pre>


    <h2>DecodeJson</h2>

    <p>
      Defining a decode json instance is more involved, as you have to
      handle the chance of failure where you may not be able to decode
      your type.
    </p>
    <p>
      <code>DecodeJson</code> works on a <a href="/doc/zipper">HCursor</a>. This
      allows codecs to be combined whilst mainting efficiency and
      tracking cursor movements for nice error messages.
    </p>

    <p>
      Defining a <code>DecodeJson</code> directly you need to build your data
      type from a cursor and return a
      <a href="http://argonaut.io/scaladocs/#argonaut.DecodeResult">DecodeResult</a>.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_DecodeJsonExample">
    </pre>

    <p>
      We also provide a set of very convenient methods for building DecodeJson
      instances.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_DecodeJsonDefaultExample">
    </pre>

    <h2>CodecJson</h2>

    <p>
      CodecJson allows you to construct both an encode and decode at
      the same time.
    </p>

    <p>
      Defining a <code>CodecJson</code> you pass two arguments, the first is as per <code>EncodeJson</code>,
      the second is as per <code>DecodeJson</code>.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_CodecJsonExample">
    </pre>

    <p>
      We also provide a set of very convenient methods for building CodecJson
      instances.
    </p>

    <pre class="prettyprint lang-scala linenums" id="example_CodecJsonDefaultExample">
    </pre>


  </div>


</div>
