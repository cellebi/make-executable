package pub.cellebi.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.lang.IllegalStateException

open class PrepareMakeExecutableTask : DefaultTask() {

    @TaskAction
    fun prepareMakeExecutableTask() {
        val makeExecutableTask = project.tasks.getByName("makeJarExecutable") as MakeExecutableTask
        showStatus(makeExecutableTask)
        if (!validate(makeExecutableTask)) {
            logger.warn("Validate failed")
            throw IllegalStateException("Plugin config is invalid")
        }
        logger.quiet("Validate pass")
    }

    private fun showStatus(makeExecutableTask: MakeExecutableTask) {
        logger.quiet(
            """
            Show MakeExecutable status:
            target jar: ${makeExecutableTask.target}
            jar options: ${makeExecutableTask.options}
            product jar: ${makeExecutableTask.executableFile}
        """.trimIndent()
        )
    }

    private fun validate(makeExecutableTask: MakeExecutableTask): Boolean {
        logger.quiet("Begin validate...")
        if (makeExecutableTask.target == null) {
            return false
        }
        return makeExecutableTask.target!!.exists()
                && makeExecutableTask.target!!.name.endsWith("jar")
    }
}