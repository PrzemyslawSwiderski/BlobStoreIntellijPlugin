package com.intellij.ide.blobstore

import org.jclouds.ContextBuilder
import org.jclouds.blobstore.BlobStore
import org.jclouds.blobstore.BlobStoreContext
import org.jclouds.filesystem.reference.FilesystemConstants
import java.lang.System.setProperty
import java.util.*


object BlobStoreFactory {

    fun getFilesystemBlobStore(baseDir: String): BlobStore {
        return ContextBuilder.newBuilder("filesystem")
                .overrides(
                        Properties().also { setProperty(FilesystemConstants.PROPERTY_BASEDIR, baseDir) }
                )
                .buildView(BlobStoreContext::class.java)
                .blobStore
    }

    const val CURRENT_DIR_CONTAINER = "."
}