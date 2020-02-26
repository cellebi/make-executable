package pub.cellebi.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.charset.Charset

open class MakeExecutableTask : DefaultTask() {

    @Input
    var options = "";

    @InputFile
    var target: File? = null

    @OutputFile
    var executableFile: File? = null

    @TaskAction
    fun execute() {
        if (executableFile!!.exists()) {
            project.delete(executableFile)
        }
        FileOutputStream(executableFile!!).buffered().use { writer ->
            writer.write(
                """#!/usr/bin/env sh
exec java $options -jar "$0" "$@"

            """.trimMargin().toByteArray(Charset.forName("ASCII"))
            )
            FileInputStream(target!!).buffered().use { reader ->
                val byteBuffer = ByteArray(1024)
                while (true) {
                    val readSize = reader.read(byteBuffer)
                    if (readSize == -1) {
                        break
                    }
                    writer.write(byteBuffer, 0, readSize)
                }
            }
        }
        executableFile!!.setExecutable(true, false)
    }
}