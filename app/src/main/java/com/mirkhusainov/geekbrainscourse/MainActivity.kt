package com.mirkhusainov.geekbrainscourse

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirkhusainov.geekbrainscourse.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter {
        MainPresenter(GithubUserRepo())
    }
    private var adapter: UsersRVAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun init() {
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        with(binding){
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsers.adapter = adapter
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
