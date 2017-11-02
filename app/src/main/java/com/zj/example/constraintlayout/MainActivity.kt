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
                mapOf("text" to "bias是改变位置, precent是改变大小, ratio是用比例来改变大小", "layout" to 0),
                mapOf("text" to "default demo", "layout" to R.layout.demo1_constraintwith_default_layout),
                mapOf("text" to "bias demo", "layout" to R.layout.demo2_constraint_bias_layout),
                mapOf("text" to "ratio demo", "layout" to R.layout.demo3_constraint_ratio_layout),
                mapOf("text" to "chains demo", "layout" to R.layout.demo4_chains_layout),
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
            if (resId <= 0) return@setOnItemClickListener
            val intent = Intent(this@MainActivity, ExampleActivity::class.java)
            intent.putExtra("resId", resId)
            startActivity(intent)
        }
    }
}
