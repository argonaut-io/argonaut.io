---
layout: default
title: argonaut
---

<div id="banner">
  <div class="guts">
    <div id="project">
      Argonaut
    </div>
    <div id="byline">
      Purely Functional JSON in Scala
    </div>
  </div>
</div>
<div id="main">
  <div class="guts">
    <div id="detail">
      <div id="started" class="section">
        <div class="title">Getting Started</div>
        <div class="details">
          <p>
            The current published version of argonaut is {{ site.release }} and is
            available on <a href="https://oss.sonatype.org">https://oss.sonatype.org</a>.
          </p>
          <p>Depending on argonaut with sbt, stable:</p>
          <pre>"io.argonaut" %% "argonaut" % "{{ site.release }}"     </pre>
          <p>Depending on argonaut with sbt, latest:</p>
          <pre>"io.argonaut" %% "argonaut" % "{{ site.development }}" changing()      </pre>
          <p>Depending on argonaut with sbt, latest milestone:</p>
          <pre>"io.argonaut" %% "argonaut" % "{{ site.milestone }}"  </pre>

          <p>
            Then checkout the <a href="/doc/quickstart">quickstart</a>,
            <a href="/doc">the detailed documention and examples</a>, and
            the <a href="scaladocs/">scaladocs</a>.
          </p>

          <p>
            Note that the 6.0.x release supports scala 2.9.2, 2.9.3, 2.10.* and 2.11.0-RC1 with scalaz 7.0.*.
          </p>

          <p>
            Note that the 6.1.x development stream supports scala 2.10.* with scalaz 7.1.*.
          </p>
 
          <p>
            All minor releases (from 6.0 onwards) are binary compatible, i.e. 6.0.x stream are drop in replacements, and the same will be true for 6.1.x, but
            going from 6.0 to 6.1 _may_ require changes or recompilation.
          </p>

          <p>Release Notes:
            {% for note in site.notes %}
            <a href="https://github.com/argonaut-io/argonaut/blob/master/notes/{{ note }}.markdown">[{{ note }}]</a>
            {% endfor %}
          </p>

        </div>


      </div>
      <div id="help" class="section">
        <div class="title">Features</div>
        <div class="details">
<h6>Concise Codec Definitions <a href="/doc/codec">#</a></h6>
<pre class="prettyprint lang-scala linenums shift">

import argonaut._, Argonaut._

case class Person(name: String, age: Int, things: List[String])

implicit def PersonCodecJson =
  casecodec3(Person.apply, Person.unapply)("name", "age", "things")

</pre>

<h6>Rich library for Parsing, Printing, Conversion and Manipulation <a href="/doc/parsing">#</a></h6>

<pre class="prettyprint lang-scala linenums:9 shift">

val person =
    Person("Bam Bam", 2, List("club"))

val json: Json =
    person.asJson

val prettyprinted: String =
    json.spaces2

val parsed: Option[Person] =
    prettyprinted.decodeOption[Person]

</pre>

<h6>History Preserving Zipper <a href="/doc/zipper">#</a></h6>
<pre class="prettyprint lang-scala linenums:22 shift">

val cursor =
    json.hcursor --\ "field" --\ "nested" --\ "deep" := "new value"

val history =
    cursor.history

val updated =
    -cursor

</pre>

    <script type="text/javascript">
      prettyPrint();
    </script>

        </div>
      </div>

      <div id="help" class="section">
        <div class="title">Getting Help</div>
        <div class="details">
          <p>
            We have an irc channel on freenode - <strong>#argonaut</strong>
          </p>
          <ul>
            <li>IRC Client: <a href="irc://freenode.net/#argonaut">irc://freenode.net/#argonaut</a></li>
            <li>Web Access: <a href="http://webchat.freenode.net/?channels=argonaut">http://webchat.freenode.net/?channels=argonaut</a></li>
          </ul>
          <p>
            Contact one of the developers on twitter: <br/>
            <a href="https://twitter.com/dibblego">@dibblego</a>
            <a href="https://twitter.com/seanparsons">@seanparsons</a>

          </p>
          <p>
            Mailing list:
            <a href="https://groups.google.com/forum/?fromgroups#!forum/argonaut-json">argonaut-json</a> on google groups.
          </p>

        </div>
      </div>

      <div id="source" class="section">
        <div class="title">Source Code</div>
        <div class="details">
          <p>
            You can grab the source code from the github repository at <a href="https://github.com/argonaut-io/argonaut">https://github.com/argonaut-io/argonaut</a>
          </p>
          <p>
            The project is built with <a href="http://www.scala-sbt.org/">sbt</a>. Just run the sbt script in the root
            of the project:
          </p>
          <pre>$ ./sbt compile</pre>
        </div>
      </div>

      <div id="contributing" class="section">
        <div class="title">Contributing</div>
        <div class="details">
          <p>
            All contributions are very welcome. Just fork and
            <a href="https://help.github.com/articles/using-pull-requests">create a pull request</a> on github.
          </p>
          <p>
            To make it easier for us to pull in your changes, try to:
          </p>
          <ul>
            <li>Make a new pull request for each logical change.</li>
            <li>Make each pull request a single coherent commit. Use <code>git rebase -i</code> to squash commits as necessary.</li>
            <li>Add tests if you are adding functionality or fixing a bug.</li>
            <li>Run the tests on all versions of scala using <code>./sbt "+test"</code>.</li>
          </ul>
        </div>
      </div>


      <div id="developers" class="section">
        <div class="title">Developers</div>
        <div class="details">
          <div>
            <h6>Tony Morris</h6>
            <p>
              <a href="https://twitter.com/dibblego">@dibblego</a></br>
              <a href="http://tmorris.net">http://tmorris.net</a>
            </p>
          </div>
          <div>
            <h6>Sean Parsons</h6>
            <p>
              <a href="https://twitter.com/seanparsons">@seanparsons</a></br>
            </p>
          </div>
        </div>
      </div>

      <div id="thankyou" class="section">
        <div class="title">Thanks</div>
        <div class="details">
          <h6>YourKit</h6>
          <p id="thanksyourkit">
            YourKit is kindly supporting argonaut and other open source projects with its
            full-featured <a href="http://www.yourkit.com/java/profiler/index.jsp">Java Profiler</a>.
          </p>
          <h6>Ephox</h6>
          <p>
            Argonaut was orginally conceived, developed and open sourced by
            <a href="http://ephox.com/">Ephox</a>.
          </p>
        </div>
      </div>
    </div>
  </div>

</div>
