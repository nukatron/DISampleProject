package com.sample.di.groceries

import com.sample.di.data.GroceryItem


interface GroceryContact {

    interface View {
        fun showToast(txt: String)
        fun showAllGroceryItem(items: List<GroceryItem>)
        fun showItem(item: GroceryItem)
    }

    interface UserActionsListener {
        fun loadGroceryItem(forceUpdate: Boolean)
        fun randomItem()
        fun autoAddItem()

    }
}