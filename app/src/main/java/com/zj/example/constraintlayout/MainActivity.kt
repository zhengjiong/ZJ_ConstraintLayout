package com.zj.example.constraintlayout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*


/**
 *
 * CreateTime: 17/11/2 10:25
 * @author zhengjiong
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
                mapOf("text" to "constraintWidth_default demo", "layout" to R.layout.demo1_constraintwith_default_layout),
                mapOf("text" to "bias demo", "layout" to R.layout.demo2_constraint_bias_layout),
                mapOf("text" to "Barrier demo")
        )

        listview.adapter = SimpleAdapter(
                this,
                list,
                android.R.layout.simple_list_item_1,
                arrayOf("text"),
                intArrayOf(android.R.id.text1)
        )

        listview.setOnItemClickListener { adapterView, view, i, l ->
            val map = adapterView.adapter.getItem(i) as LinkedHashMap<String, *>
            val resId: Int = map["layout"] as Int
            val intent = Intent(this@MainActivity, ExampleActivity::class.java)
            intent.putExtra("resId", resId)
            startActivity(intent)
        }
    }
}
