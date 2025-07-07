package com.zj.example.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * CreateTime: 17/11/2 10:27
 * @author zhengjiong
 */
class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resId = intent.extras?.getInt("resId", 0)
        if (resId != 0) {
            setContentView(resId?:0)
        }
    }
}