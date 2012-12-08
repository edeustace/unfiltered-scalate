import sbt._
import sbt.Keys._

object UnfilteredScalateBuild extends Build {

  lazy val unfilteredScalate = Project(
    id = "unfiltered-scalate",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
      publishMavenStyle := true,
      publishTo <<= version { (v: String) =>
        def isSnapshot = v.trim.endsWith("SNAPSHOT") 
        val finalPath = (if (isSnapshot) "/snapshots" else "/releases")
        Some(
          Resolver.sftp(
            "Ed Eustace",
            "edeustace.com", 
            "/home/edeustace/edeustace.com/public/repository" + finalPath ))

       }
    )
  )
}
