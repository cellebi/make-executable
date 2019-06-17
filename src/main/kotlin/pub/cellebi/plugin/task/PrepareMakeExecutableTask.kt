package pub.cellebi.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class PrepareMakeExecutableTask : DefaultTask() {
    @TaskAction
    fun prepareMakeExecutableTask() {
        println("hello")
    }
}