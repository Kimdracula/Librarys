package com.mirkhusainov.geekbrainscourse

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)

interface MainView: MvpView{
    fun setText(counter: String, id: Int)
}