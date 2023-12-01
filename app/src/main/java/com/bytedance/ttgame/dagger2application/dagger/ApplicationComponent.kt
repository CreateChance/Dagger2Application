package com.bytedance.ttgame.dagger2application.dagger

import android.app.Application
import android.content.Context
import com.bytedance.ttgame.dagger2application.DemoApplication
import com.bytedance.ttgame.dagger2application.models.GlobalData1
import com.bytedance.ttgame.dagger2application.models.GlobalData2
import com.bytedance.ttgame.mylibrary_api.ILibraryApi
import dagger.Component

/**
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@ApplicationScope
@Component(modules = [GlobalDataModule::class, AppContextModule::class, LibraryApiImplModule::class])
interface ApplicationComponent {
    fun globalData1(): GlobalData1

    fun globalData2(): GlobalData2

    fun application(): Application

    fun demoApplication(): DemoApplication

    fun appContext(): Context

    fun libraryApi(): ILibraryApi
}