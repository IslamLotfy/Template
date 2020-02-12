package com.islam.template.downloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.Observable
import io.reactivex.Single
import java.io.File
import java.io.FileOutputStream
import java.net.URL


class FileDownloader constructor(private val cacheDirectory: String) {
    fun downloadFile(url: String, fileName: String): Single<Bitmap> {
        return Single.create { emitter ->
            val connection = URL(url).openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()
            val fileCache = File(cacheDirectory, fileName)
            val fileOutputStream = FileOutputStream(fileCache)
            val buferSize = 16384
            val buffer = ByteArray(buferSize)
            do {
                val numberOfRead = inputStream.read(buffer)
                if (numberOfRead <= 0) break
                fileOutputStream.write(buffer, 0, numberOfRead)
            } while (true)
            try {
                emitter.onSuccess(BitmapFactory.decodeFile(fileCache.absolutePath))
            } catch (e: Exception) {
                emitter.onError(e)
            }

        }
    }

    fun downloadFiles(listFilesUrl: List<String>): Single<List<Bitmap>> {
        return Observable.fromIterable(listFilesUrl)
            .concatMapEager {
                downloadFile(it, it.hashCode().toString()).toObservable()
            }.toList()

    }
}