package com.mirkhusainov.geekbrainscourse

class CountersPresenter {

    private var view: MainView? = null
    private val model = CountersModel()

    fun attach(view: MainView) {
        this.view = view
    }

    fun onCounterClick(id: Int) {
        view.let {
            val number = model.next(id)
            it?.setText(number.toString(), id)
        }

    }
}