package com.bytedance.ttgame.dagger2application.dagger

import dagger.Component

/**
 *
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@ActivityScope
@Component(modules = [ActivityImmutableDataModule::class, ActivitySubcomponentModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun activitySubcomponentFactory(): ActivitySubcomponent.Factory
}