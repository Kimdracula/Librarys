package com.mirkhusainov.geekbrainscourse

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUserRepo, val router: Router) :
    MvpPresenter<UsersView>() {


    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)

        }

        override fun getCount(): Int = users.size

    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//
        }

    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}