package pub.cellebi.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import pub.cellebi.plugin.config.ExecutorConfigExtension
import pub.cellebi.plugin.task.MakeExecutableTask
import pub.cellebi.plugin.task.PrepareMakeExecutableTask

class ExecutorPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val config = project.extensions.create("makeExecutable", ExecutorConfigExtension::class.java)
        project.tasks.register("makeJarExecutable", MakeExecutableTask::class.java) {
            it.options = config.options.joinToString(" ").trim()
            it.target = project.file("${project.buildDir}/libs/${project.name}-${project.version}.jar")
            it.executableFile = project.file("${project.buildDir}/dist/${config.name}")
            it.dependsOn("prepareMakeExecutable")
        }
        project.tasks.register("prepareMakeExecutable", PrepareMakeExecutableTask::class.java)
    }
}