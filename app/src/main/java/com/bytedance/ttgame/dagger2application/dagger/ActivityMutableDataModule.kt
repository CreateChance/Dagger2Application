package com.bytedance.ttgame.dagger2application.dagger

import com.bytedance.ttgame.dagger2application.models.ActivityMutableData1
import com.bytedance.ttgame.dagger2application.models.ActivityMutableData2
import dagger.Module
import dagger.Provides

/**
 *
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Module
class ActivityMutableDataModule {

    @Provides
    fun provideActivityMutableData1(): ActivityMutableData1 {
        return ActivityMutableData1()
    }

    @Provides
    fun provideActivityMutableData2(): ActivityMutableData2 {
        return ActivityMutableData2()
    }
}