package pl.pollub.harnasik.app.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App: Application(){
    companion object {
        var AuthUser: String? = null
    }

    override fun onCreate() {
        super.onCreate()

    }
}