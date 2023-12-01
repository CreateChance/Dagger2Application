package com.bytedance.ttgame.dagger2application.dagger

import com.bytedance.ttgame.dagger2application.MainActivity
import com.bytedance.ttgame.dagger2application.SecondActivity
import dagger.Subcomponent

/**
 *
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Subcomponent(modules = [ActivityMutableDataModule::class])
interface ActivitySubcomponent {

    fun inject(target: MainActivity)

    fun inject(target: SecondActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivitySubcomponent
    }
}