package com.mirkhusainov.geekbrainscourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkhusainov.geekbrainscourse.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import java.util.ArrayList

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter {
        CountersPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()

    }

    private fun setClickListeners() {
        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(BUTTON_1)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(BUTTON_2)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(BUTTON_3)
            }
        }
    }


    override fun setText(counter: String, id: Int) {
        with(binding) {
            when (id) {
                BUTTON_1 -> tvText1.text = counter
                BUTTON_2 -> tvText2.text = counter
                BUTTON_3 -> tvText3.text = counter
            }
        }
    }
}
