package com.mirkhusainov.geekbrainscourse

import java.util.ArrayList

class CountersPresenter{

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

    fun saveResult(): MutableList<Int>{
      return  model.getArray()
    }

    fun restoreResult(savedArray: ArrayList<Int>?){
       model.setArray(savedArray)
    }

    fun detach(view: MainView?){
       this.view=view
    }
}