package com.zj.example.constraintlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.demo8_placeholder_layout.*
import kotlinx.android.synthetic.main.template.*

/**
 * https://juejin.im/entry/59e880376fb9a0452a3b707f
 *
 * CreateTime: 17/11/4 17:06
 * @author zhengjiong
 */
class PlaceHolderExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo8_placeholder_layout)



        save.setOnClickListener(View.OnClickListener { view ->
            TransitionManager.beginDelayedTransition(root)
            template_action.setContentId(view.id)
        })

        cancel.setOnClickListener(View.OnClickListener { view ->
            TransitionManager.beginDelayedTransition(root)
            template_action.setContentId(view.id)
        })
        edit.setOnClickListener(View.OnClickListener { view ->
            TransitionManager.beginDelayedTransition(root)
            template_action.setContentId(view.id)
        })
        delete.setOnClickListener(View.OnClickListener { view ->
            TransitionManager.beginDelayedTransition(root)
            template_action.setContentId(view.id)
        })
    }
}