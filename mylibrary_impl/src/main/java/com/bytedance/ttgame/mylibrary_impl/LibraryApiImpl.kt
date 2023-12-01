package com.bytedance.ttgame.mylibrary_impl

import android.util.Log
import com.bytedance.ttgame.mylibrary_api.ILibraryApi

/**
 * api 接口的实现
 *
 * @author 高超（gaochao.cc）
 * @since 2023/12/1
 */
class LibraryApiImpl : ILibraryApi {
    override fun invoke() {
        Log.d("GAOCHAO", "library api 接口实现：${this.javaClass.canonicalName}")
    }
}