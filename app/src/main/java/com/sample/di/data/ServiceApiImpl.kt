package com.sample.di.data

class ServiceApiImpl : IServiceApi {

    override fun getAllItems(callback: IServiceApi.ServiceCallback<List<GroceryItem>>) {
        //TODO: get all items from server or database
    }

    override fun getItem(itemId: String, callback: IServiceApi.ServiceCallback<GroceryItem?>) {
        //TODO: get specific item from server or database
    }

    override fun addItem(vararg items: GroceryItem) {
        //TODO: add item to server or database
    }
}

