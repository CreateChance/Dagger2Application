package com.bytedance.ttgame.dagger2application.dagger

import com.bytedance.ttgame.mylibrary_api.ILibraryApi
import com.bytedance.ttgame.mylibrary_impl.LibraryApiImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * library api 和 impl 绑定模块
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
@Module
abstract class LibraryApiImplModule {
    @Binds
    abstract fun bindApiImpl(impl: LibraryApiImpl): ILibraryApi

    companion object {
        @Provides
        @ApplicationScope
        @JvmStatic
        fun provideApiImpl(): LibraryApiImpl {
            return LibraryApiImpl()
        }
    }
}