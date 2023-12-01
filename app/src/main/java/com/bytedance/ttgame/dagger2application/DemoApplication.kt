package com.bytedance.ttgame.dagger2application

import android.app.Application
import com.bytedance.ttgame.dagger2application.dagger.AppContextModule
import com.bytedance.ttgame.dagger2application.dagger.ApplicationComponent
import com.bytedance.ttgame.dagger2application.dagger.DaggerApplicationComponent

/**
 * custom application class.
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
class DemoApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().appContextModule(
            AppContextModule(this, this, this)
        ).build()
    }
}