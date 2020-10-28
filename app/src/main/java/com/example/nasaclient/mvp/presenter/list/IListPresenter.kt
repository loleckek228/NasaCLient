package com.example.nasaclient.mvp.presenter.list

import androidx.appcompat.view.menu.MenuView

interface IListPresenter<V: MenuView.ItemView> {
    fun bindView(view: V)
    fun getCount()
}