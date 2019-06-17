package pub.cellebi.plugin

import org.gradle.api.internal.project.ProjectInternal
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert.*
import org.junit.Test

class ExecutorPluginTest {
    @Test
    fun testApply() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply(ExecutorPlugin::class.java)
        val p = project as ProjectInternal
        p.evaluate()
    }

}