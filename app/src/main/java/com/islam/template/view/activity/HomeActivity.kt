package com.islam.template.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.islam.template.R
import com.islam.template.downloader.FileDownloader
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DaggerAppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fileDownloader = FileDownloader(applicationContext.cacheDir.absolutePath)
        fileDownloader.downloadFile(
            url = "https://images.unsplash.com/profile-1464495186405-68089dcd96c3?ixlib=rb-0.3.5\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026fit=crop\\u0026h=128\\u0026w=128\\u0026s=622a88097cf6661f84cd8942d851d9a2",
            fileName = "1.png"
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                iv_home.setImageBitmap(it)
            }, {
                Log.e("errrorrrrrrrrr", it.toString())
            })
    }
}
