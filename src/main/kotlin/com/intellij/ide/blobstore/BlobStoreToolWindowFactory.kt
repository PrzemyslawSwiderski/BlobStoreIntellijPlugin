package com.intellij.ide.blobstore

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory

class BlobStoreToolWindowFactory : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val blobStoreExplorer = BlobStoreExplorer(project)
        blobStoreExplorer.init()
        val contentManager = toolWindow.contentManager
        val content = contentManager.factory.createContent(blobStoreExplorer, null, false)
        contentManager.addContent(content)
        Disposer.register(project, blobStoreExplorer)
    }

}