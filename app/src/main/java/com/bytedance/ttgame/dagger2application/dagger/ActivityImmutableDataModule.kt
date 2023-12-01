package com.bytedance.ttgame.dagger2application.dagger

import com.bytedance.ttgame.dagger2application.models.ActivityImmutableData1
import com.bytedance.ttgame.dagger2application.models.ActivityImmutableData2
import dagger.Module
import dagger.Provides

/**
 *
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Module
class ActivityImmutableDataModule {

    @ActivityScope
    @Provides
    fun provideActivityImmutableData1(): ActivityImmutableData1 {
        return ActivityImmutableData1()
    }

    @ActivityScope
    @Provides
    fun provideActivityImmutableData2(): ActivityImmutableData2 {
        return ActivityImmutableData2()
    }
}