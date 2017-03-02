package com.sample.di.groceries

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sample.di.Injection
import com.sample.di.R
import com.sample.di.data.GroceryItem
import kotlinx.android.synthetic.main.activity_main.*

class GroceryActivity : AppCompatActivity(), GroceryContact.View {

    private lateinit var mPresenter: GroceryContact.UserActionsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //use injection class in each product variant.
        mPresenter = GroceryPresenter(this, Injection.provideRepository())

        initView()
    }

    fun initView() {
        addButton.setOnClickListener { mPresenter.autoAddItem() }
        randomButton.setOnClickListener { mPresenter.randomItem() }
        showAllButton.setOnClickListener { mPresenter.loadGroceryItem(false) }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadGroceryItem(false)
    }

    override fun showAllGroceryItem(items: List<GroceryItem>) {
        val builder = StringBuilder()
        for(item in items) {
            builder.append(item.toString()).append("\n")
        }
        mainTextView.text = builder.toString()
    }

    override fun showItem(item: GroceryItem) {
        mainTextView.text = item.toString()
    }

    override fun showToast(txt: String) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show()
    }

}
