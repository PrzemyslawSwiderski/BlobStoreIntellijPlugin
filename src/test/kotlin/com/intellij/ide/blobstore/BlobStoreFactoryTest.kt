package com.intellij.ide.blobstore

import assertk.assertThat
import assertk.assertions.exists
import assertk.assertions.hasSize
import com.intellij.ide.blobstore.BlobStoreFactory.CURRENT_DIR_CONTAINER
import com.intellij.util.io.createFile
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.nio.file.Path


class BlobStoreFactoryTest {

    @Nested
    inner class FilesystemBlobStoreTests {

        @TempDir
        lateinit var tmpFolder: Path

        @Test
        fun `Should save blob to filesystem`() {
            // given
            val sampleText = "test"
            val sampleTextFileName = "testFile.txt"
            val sampleContainerName = "."

            // when
            val fsBlobStore = BlobStoreFactory.getFilesystemBlobStore(tmpFolder.toString())
            val blobToSave = fsBlobStore.blobBuilder(sampleTextFileName).payload(sampleText).build()
            fsBlobStore.putBlob(CURRENT_DIR_CONTAINER, blobToSave)

            // then
            assertThat(File("$tmpFolder/$sampleTextFileName")).exists()
        }

        @Test
        fun `Should list files`() {
            // given
            val testFilesCount = 7
            tmpFolder.also { path ->
                (1..testFilesCount).forEach { tmpFolder.resolve("testFile$it.txt").createFile() }
            }

            // when
            val fsBlobStore = BlobStoreFactory.getFilesystemBlobStore(tmpFolder.toString())
            val data = fsBlobStore.list(CURRENT_DIR_CONTAINER)

            // then
            assertThat(data).hasSize(testFilesCount)
        }
    }

}