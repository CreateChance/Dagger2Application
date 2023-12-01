package com.bytedance.ttgame.dagger2application.dagger

import com.bytedance.ttgame.dagger2application.models.GlobalData1
import com.bytedance.ttgame.dagger2application.models.GlobalData2
import dagger.Module
import dagger.Provides

/**
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Module
class GlobalDataModule {
    @ApplicationScope
    @Provides
    fun provideGlobalData1(): GlobalData1 {
        return GlobalData1()
    }

    @ApplicationScope
    @Provides
    fun provideGlobalData2(): GlobalData2 {
        return GlobalData2()
    }
}