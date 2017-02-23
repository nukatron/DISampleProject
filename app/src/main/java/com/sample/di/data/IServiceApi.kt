package com.sample.di.data


interface IServiceApi {

    interface IServiceCallback<in T> {
        fun onLoaded(items: T)
    }

    fun getAllItems(callback: IServiceCallback<List<GroceryItem>>)
    fun getItem(itemId: String, callback: IServiceCallback<GroceryItem?>)
    fun addItem(vararg items: GroceryItem)
}