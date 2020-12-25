package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.model.repo.irepo.IRepo
import com.example.nasaclient.mvp.model.state.EarthPhotosState
import com.example.nasaclient.mvp.view.EarthPhotosView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class EarthPhotosPresenter(private val compositeDisposable: CompositeDisposable = CompositeDisposable()) :
    MvpPresenter<EarthPhotosView>() {

    @Inject
    lateinit var repo: IRepo<EarthPhotosState>

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
            repo.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit = {
        viewState.renderData(EarthPhotosState.Loading(null))
    }

    private fun getObserver(): DisposableObserver<EarthPhotosState> {
        return object : DisposableObserver<EarthPhotosState>() {
            override fun onNext(t: EarthPhotosState?) {
                viewState.renderData(t)
            }

            override fun onError(e: Throwable?) {
                viewState.renderData(EarthPhotosState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}