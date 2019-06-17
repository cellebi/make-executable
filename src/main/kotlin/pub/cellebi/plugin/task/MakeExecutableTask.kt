package pub.cellebi.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class MakeExecutableTask : DefaultTask() {

    @Input
    var finalName = ""

    @InputFile
    var target: File? = null;

    init {
        //target = project.file(finalName)
    }


    @TaskAction
    fun go() {

    }
}