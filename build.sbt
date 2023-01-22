ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "HomeWork1",
    libraryDependencies += "com.github.scopt" %% "scopt" % "4.1.0",
    libraryDependencies +="com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.13.5",
    libraryDependencies +="com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.13.5",
    libraryDependencies += "io.scalaland" %% "chimney" % "0.6.2"
  )
