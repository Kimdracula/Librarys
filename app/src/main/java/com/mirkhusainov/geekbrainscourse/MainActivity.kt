package com.mirkhusainov.geekbrainscourse

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.mirkhusainov.geekbrainscourse.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null


    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter {
        MainPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}
