package com.mirkhusainov.geekbrainscourse

import moxy.MvpPresenter

class CountersPresenter: MvpPresenter<MainView>() {

    private val model = CountersModel()


    fun onCounterClick(id: Int) {
        viewState.let {
           model.next(id)
            it?.setText(model.getCurrent(id).toString(), id)
        }
    }
}