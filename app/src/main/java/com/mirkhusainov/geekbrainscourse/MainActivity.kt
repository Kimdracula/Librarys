package com.mirkhusainov.geekbrainscourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkhusainov.geekbrainscourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(0)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(1)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(2)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter()
        presenter.attach(this)

    }

    override fun setText(counter: String, id: Int) {
        with(binding) {
            when (id) {
                0 -> tvText1.text = counter
                1 -> tvText2.text = counter
                2 -> tvText3.text = counter
            }
        }
    }
}