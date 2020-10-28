package com.example.nasaclient.mvp.presenter

import com.example.nasaclient.mvp.model.repo.irepo.ISpacePhotoRepo
import com.example.nasaclient.mvp.model.state.SpacePhotoState
import com.example.nasaclient.mvp.view.SpacePhotoView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SpacePhotoPresenter(private val compositeDisposable: CompositeDisposable = CompositeDisposable()) :
    MvpPresenter<SpacePhotoView>() {

    @Inject
    lateinit var repo: ISpacePhotoRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var scheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        compositeDisposable.add(
            repo.getSpacePhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribeWith(getObserver())
        )
    }

    private fun doOnSubscribe(): (Disposable) -> Unit =
        { viewState.renderData(SpacePhotoState.Loading(null)) }

    private fun getObserver(): DisposableObserver<SpacePhotoState> {
        return object : DisposableObserver<SpacePhotoState>() {
            override fun onNext(t: SpacePhotoState?) {
                viewState.renderData(t)
            }

            override fun onError(e: Throwable?) {
                viewState.renderData(SpacePhotoState.Error(e))
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