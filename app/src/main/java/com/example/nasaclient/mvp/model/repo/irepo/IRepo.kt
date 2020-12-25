package com.example.nasaclient.mvp.model.repo.irepo

import io.reactivex.rxjava3.core.Observable

interface IRepo<T> {
    fun getData(): Observable<T>
}