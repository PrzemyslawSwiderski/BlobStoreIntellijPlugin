package com.intellij.ide.blobstore

import com.intellij.openapi.Disposable
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.SimpleToolWindowPanel

class BlobStoreExplorer(private val project: Project) : SimpleToolWindowPanel(true, true), DataProvider, Disposable {

    fun init() {
        toolbar = createToolbar(project).component
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun createToolbar(project: Project): ActionToolbar {
        val group = DefaultActionGroup()
        group.add(ActionManager.getInstance().getAction(IdeActions.ACTION_CALL_HIERARCHY))
        group.add(ActionManager.getInstance().getAction(IdeActions.ACTION_FIND))
        group.addSeparator()

        return ActionManager.getInstance().createActionToolbar("BlobStore", group, true)
    }

}