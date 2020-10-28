package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.model.repo.irepo.IMarsPhotosRepo
import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import com.example.nasaclient.mvp.model.state.MarsPhotosState
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.mvp.view.MarsPhotosView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MarsPhotosPresenter(private val compositeDisposable: CompositeDisposable = CompositeDisposable()) :
    MvpPresenter<MarsPhotosView>() {

    @Inject
    lateinit var repo: IMarsPhotosRepo

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
            repo.getMarsPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit = {
        viewState.renderData(MarsPhotosState.Loading(null))
    }

    private fun getObserver(): DisposableObserver<MarsPhotosState> {
        return object : DisposableObserver<MarsPhotosState>() {
            override fun onNext(t: MarsPhotosState?) {
                viewState.renderData(t)
            }

            override fun onError(e: Throwable?) {
                viewState.renderData(MarsPhotosState.Error(e))
            }

            override fun onComplete() {}

        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}