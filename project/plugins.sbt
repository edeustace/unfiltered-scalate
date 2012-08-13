resolvers ++= Seq(
  "coda" at "http://repo.codahale.com",
  Resolver.url("sbt-plugin-releases",
        new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
)

addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.2")

