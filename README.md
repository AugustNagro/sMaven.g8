Template for Scala projects published to Sonatype / Maven Central.

Use `sbt new augustnagro/smaven.g8` to create a minimal template with:

* [Scala][scala] (2.12.2)
* [SBT][sbt] (>= 0.13.15)
* [ScalaCheck][scheck] (latest release)
* Publishing configuration

The settings are detailed [here][post]

License: Creative Commons Zero v1.0
http://choosealicense.com/licenses/cc0-1.0/#

For those new to publishing, read the [sbt docs on publishing][sbtNexus]. A summary follows:
* Make a Sonatype Nexus account [here][nexus]
* Create `~/.sbt/<sbt version>/plugins/gpg.sbt` with:
```scala
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")
```
* Create `~/.sbt/<sbt version>/sonatype.sbt` with:
```scala
credentials += Credentials("Sonatype Nexus Repository Manager",
                           "oss.sonatype.org",
                           "<your username>",
                           "<your password>")
```
* [Make a key pair][keypair]
* Distribute your public key: 

`> pgp-cmd send-key keyname hkp://pool.sks-keyservers.net`
* Run `sbt publishSigned` to push to Nexus
* [Release the Deployment][release] to the central repository

**Notes**
* Add the Sonatype resolver to use snapshot repositories that haven't been published to maven central.

```scala
resolvers += 
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
```
* Cross build the project for different scala versions, if possible. Then run `+publishSigned` instead of `publishSigned`. See the [Cross Building][xbuilding] docs.

[g8]: http://www.foundweekends.org/giter8/
[sjs]: https://www.scala-js.org
[post]: https://augustnagro.com/Giter8-Scala-Templates.html
[scala]: scala-lang.org
[sbt]: http://www.scala-sbt.org/
[scheck]: http://www.scalacheck.org
[nexus]: https://issues.sonatype.org/secure/CreateIssue.jspa?issuetype=21&pid=10134
[release]: http://central.sonatype.org/pages/releasing-the-deployment.html
[keypair]: http://www.scala-sbt.org/sbt-pgp/usage.html
[sbtNexus]: http://www.scala-sbt.org/0.13/docs/Using-Sonatype.html
[xbuilding]: http://www.scala-sbt.org/0.13/docs/Cross-Build.html
