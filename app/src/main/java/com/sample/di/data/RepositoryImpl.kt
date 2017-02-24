package com.sample.di.data

import com.sample.di.data.IServiceApi.ServiceCallback

class RepositoryImpl (serviceApi: IServiceApi): IRepository {

    val mServiceApi: IServiceApi = serviceApi
    val mCacheItems: MutableList<GroceryItem> = mutableListOf()

    override fun getGroceryItems(callback: IRepository.OnLoadCallback<List<GroceryItem>>) {
        if (mCacheItems.isEmpty()) {
            mServiceApi.getAllItems(object : ServiceCallback<List<GroceryItem>> {
                override fun onLoaded(items: List<GroceryItem>) {
                    callback.onLoaded(items)
                }
            })
        } else {
            callback.onLoaded(mCacheItems.toList())
        }
    }

    override fun getGroceryItem(id: String, callback: IRepository.OnLoadCallback<GroceryItem?>) {
        val item = mCacheItems.find { it.id == id }

        if(item == null) {
            mServiceApi.getItem(id, object : ServiceCallback<GroceryItem?> {
                override fun onLoaded(items: GroceryItem?) {
                    callback.onLoaded(items)
                }
            })
        } else {
            callback.onLoaded(item)
        }
    }

    override fun addGroceryItem(item: GroceryItem) {
        mServiceApi.addItem(item)
        refreshData()
    }

    override fun refreshData() {
        mCacheItems.clear()
    }
}
