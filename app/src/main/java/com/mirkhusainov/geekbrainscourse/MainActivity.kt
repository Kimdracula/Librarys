package com.mirkhusainov.geekbrainscourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkhusainov.geekbrainscourse.databinding.ActivityMainBinding
import java.util.ArrayList

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
                presenter.onCounterClick(BUTTON1)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(BUTTON2)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(BUTTON3)
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
                BUTTON1 -> tvText1.text = counter
                BUTTON2 -> tvText2.text = counter
                BUTTON3 -> tvText3.text = counter
            }
        }
    }

   private fun restoreText(restoredArray: ArrayList<Int>) {
        with(binding) {

               tvText1.text = restoredArray[BUTTON1].toString()
               tvText2.text = restoredArray[BUTTON2].toString()
               tvText3.text = restoredArray[BUTTON3].toString()
            }
        }


    override fun onSaveInstanceState(outState: Bundle) {
        presenter.detach(this)
        outState.putIntegerArrayList("KEY",presenter.saveResult() as ArrayList<Int>)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredArray = savedInstanceState.getIntegerArrayList("KEY") as ArrayList<Int>
        restoreText(restoredArray)
        presenter.restoreResult(restoredArray)
    }


    override fun onDestroy() {
        presenter.detach(null)
        super.onDestroy()
    }
}