repositories {
    mavenCentral()
}


val tasksDependencies = mapOf(
    "spotlessKotlin" to listOf("compileKotlin")
)

tasksDependencies.forEach { (taskName, dependencies) ->
    tasks.findByName(taskName)?.dependsOn(dependencies)
}
