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
                mapOf("text" to "Bias是改变位置, precent是改变大小, ratio是用比例来改变大小", "layout" to 0),
                mapOf("text" to "Default demo, 当控件设置为0dp的时候（0dp的称呼又叫match_constraint），默认的行为是撑开（spread），占满可用空间，但是这个行为是可以用layout_constraintWidth_default 属性来设置的", "layout" to R.layout.demo1_constraintwith_default_layout),
                mapOf("text" to "Bias demo", "layout" to R.layout.demo2_constraint_bias_layout),
                mapOf("text" to "Ratio demo", "layout" to R.layout.demo3_constraint_ratio_layout),
                mapOf("text" to "Chains demo", "layout" to R.layout.demo4_chains_layout),
                mapOf("text" to "GuideLine demo", "layout" to R.layout.demo5_guideline_layout),
                mapOf("text" to "Barriers demo", "layout" to R.layout.demo6_barriers_layout),
                mapOf("text" to "Group demo", "layout" to R.layout.demo7_group_layout),
                mapOf("text" to "PlaceHolder demo", "layout" to R.layout.demo8_placeholder_layout),
                mapOf("text" to "PlaceHolder demo", "layout" to PlaceHolderExample::class.java),
                mapOf("text" to "Backgrounds demo", "layout" to R.layout.demo10_backgrounds_layout),
                mapOf("text" to "Circle demo", "layout" to R.layout.demo11_circle_layout),
                mapOf("text" to "Circle demo 2", "layout" to CircleExample::class.java)
        )

        listview.adapter = SimpleAdapter(
                this,
                list,
                android.R.layout.simple_list_item_1,
                arrayOf("text"),
                intArrayOf(android.R.id.text1)
        )

        listview.setOnItemClickListener { adapterView, view, i, l ->
            val map = adapterView.adapter.getItem(i) as Map<String, *>
            val value = map["layout"]
            when (value) {
                is Int -> {
                    if (value <= 0) return@setOnItemClickListener
                    val intent = Intent(this@MainActivity, ExampleActivity::class.java)
                    intent.putExtra("resId", value)
                    startActivity(intent)
                }
                is Class<*> -> {
                    startActivity(Intent(this@MainActivity, value))
                }
                else -> {

                }
            }
        }
    }
}
