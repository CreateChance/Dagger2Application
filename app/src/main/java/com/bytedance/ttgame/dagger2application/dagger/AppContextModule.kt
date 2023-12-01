package com.bytedance.ttgame.dagger2application.dagger

import android.app.Application
import android.content.Context
import com.bytedance.ttgame.dagger2application.DemoApplication
import dagger.Module
import dagger.Provides

/**
 *
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Module
class AppContextModule(
    private val application: Application,
    private val demoApplication: DemoApplication,
    private val appContext: Context
) {
    @ApplicationScope
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @ApplicationScope
    @Provides
    fun provideDemoApplication(): DemoApplication {
        return demoApplication
    }

    @ApplicationScope
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }
}