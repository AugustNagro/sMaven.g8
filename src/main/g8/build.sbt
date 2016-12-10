name := "$name$"
organization := "$organization$"
version := "$version$"
scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "$scalacheck_version$" % "test"
)

publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
homepage := Some(url("$project_homepage$"))
licenses := Seq(
  "MIT" -> url("http://www.opensource.org/licenses/mit-license.php"))
scmInfo := Some(
  ScmInfo(browseUrl = url("$mvn_browse_url$"),
          connection = "$mvn_connection$"))
developers := List(
  Developer(id = "$mvn_id$",
            name = "$mvn_name$",
            email = "$email$",
            url = url("$mvn_dev_url$")))

updateOptions := updateOptions.value.withCachedResolution(true)
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-target:jvm-1.8",
  "-encoding",
  "UTF-8",
  "-Xfuture",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused",
  "-feature",
  "-Xlint"
)
