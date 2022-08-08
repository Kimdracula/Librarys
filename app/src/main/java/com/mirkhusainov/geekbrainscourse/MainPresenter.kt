package com.mirkhusainov.geekbrainscourse

import moxy.MvpPresenter

class MainPresenter(val usersRepo:GithubUserRepo): MvpPresenter<MainView>() {

class UsersListPresenter: IUserListPresenter {
    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)

    }

    override fun getCount(): Int = users.size

}
    val usersListPresenter = MainPresenter.UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
//TODO: переход на экран пользователя
        }

    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()

    }
}

