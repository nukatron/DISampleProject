package com.sample.di.data

class MockServiceApiImpl : IServiceApi {

    //you can define mock data to be any whatever you want
    private val mMockItems: MutableMap<String, GroceryItem> = mutableMapOf(
            "mockId1" to GroceryItem("mockId1", "mockData1", 1),
            "mockId2" to GroceryItem("mockId2", "mockData2", 12),
            "mockId3" to GroceryItem("mockId3", "mockData3", 123)
    )

    override fun getAllItems(callback: IServiceApi.ServiceCallback<List<GroceryItem>>) {
        callback.onLoaded(mMockItems.values.toList())
    }

    override fun getItem(itemId: String, callback: IServiceApi.ServiceCallback<GroceryItem?>) {
        callback.onLoaded(mMockItems[itemId])
    }

    override fun addItem(vararg items: GroceryItem) {
        for (item in items) {
            mMockItems.put(item.id, item)
        }
    }
}

