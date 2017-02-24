package com.sample.di.data


interface IRepository {

    interface OnLoadCallback<in T> {
        fun onLoaded(items: T)
    }

    fun getGroceryItems(callback: OnLoadCallback<List<GroceryItem>>)
    fun getGroceryItem(id: String, callback: OnLoadCallback<GroceryItem?>)
    fun addGroceryItem(item: GroceryItem)

    // in case you want to clear cache
    fun refreshData()
}