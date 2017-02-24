package com.sample.di.groceries

import com.sample.di.data.GroceryItem
import com.sample.di.data.IRepository
import java.util.*


class GroceryPresenter(view: GroceryContact.View, repository: IRepository) : GroceryContact.UserActionsListener {

    private val mRepository: IRepository = repository
    private val mView: GroceryContact.View  = view

    override fun loadGroceryItem(forceUpdate: Boolean) {
        if (forceUpdate) {
            mRepository.refreshData()
        }

        mRepository.getGroceryItems(object : IRepository.OnLoadCallback<List<GroceryItem>> {
            override fun onLoaded(items: List<GroceryItem>) {
                mView.showAllGroceryItem(items)
            }
        })
    }

    override fun randomItem() {
        mRepository.getGroceryItems(object : IRepository.OnLoadCallback<List<GroceryItem>> {
            override fun onLoaded(items: List<GroceryItem>) {
                mView.showItem(items[Random().nextInt(items.size)])
            }
        })
    }

    override fun autoAddItem() {
        val id = UUID.randomUUID().toString()
        val item = GroceryItem(id, "Add$id", 0)
        mRepository.addGroceryItem(item)
        mView.showToast("Added!")
    }
}