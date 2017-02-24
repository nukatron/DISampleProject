package com.sample.di.data


interface IServiceApi {

    interface ServiceCallback<in T> {
        fun onLoaded(items: T)
    }

    fun getAllItems(callback: ServiceCallback<List<GroceryItem>>)
    fun getItem(itemId: String, callback: ServiceCallback<GroceryItem?>)
    fun addItem(vararg items: GroceryItem)
}