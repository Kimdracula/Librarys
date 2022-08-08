package com.mirkhusainov.geekbrainscourse

interface IListPresenter<V: ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
interface IUserListPresenter : IListPresenter<UserItemView>
