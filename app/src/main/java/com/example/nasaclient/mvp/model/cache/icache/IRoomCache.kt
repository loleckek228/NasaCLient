package com.example.nasaclient.mvp.model.cache.icache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface IRoomCache<T> {
    fun getData(): Observable<T?>
    fun insertData(data: T): Completable
}