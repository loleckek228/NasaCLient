package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.model.repo.irepo.IEarthPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.IMarsWeatherRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.mvp.model.state.MarsWeatherState
import com.example.nasaclient.mvp.view.MarsWeatherView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MarsWeatherPresenter(private val compositeDisposable: CompositeDisposable = CompositeDisposable()) :
    MvpPresenter<MarsWeatherView>() {
    @Inject
    lateinit var repo: IMarsWeatherRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var scheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()
    }

    private fun loadData() {
        compositeDisposable.add(
            repo.getMarsWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit = {
        viewState.renderData(MarsWeatherState.Loading(null))
    }

    private fun getObserver(): DisposableObserver<MarsWeatherState> {
        return object : DisposableObserver<MarsWeatherState>() {
            override fun onNext(t: MarsWeatherState?) {
                viewState.renderData(t)
            }

            override fun onError(e: Throwable?) {
                viewState.renderData(MarsWeatherState.Error(e))
            }

            override fun onComplete() {}
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}