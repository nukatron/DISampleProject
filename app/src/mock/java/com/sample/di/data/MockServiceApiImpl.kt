package com.sample.di.data

class MockServiceApiImpl : IServiceApi {


    //you can define mock data to be any what ever you want
    private val mMockItems: MutableMap<String, GroceryItem> = mutableMapOf()

    override fun getAllItems(callback: IServiceApi.IServiceCallback<List<GroceryItem>>) {
        callback.onLoaded(mMockItems.values.toList())
    }

    override fun getItem(itemId: String, callback: IServiceApi.IServiceCallback<GroceryItem?>) {
        callback.onLoaded(mMockItems[itemId])
    }

    override fun addItem(vararg items: GroceryItem) {
        for (item in items) {
            mMockItems.put(item.id, item)
        }
    }
}

