package com.zj.example.constraintlayout

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder

/**
 * https://juejin.im/entry/59e880376fb9a0452a3b707f
 *
 * CreateTime: 17/11/4 17:06
 * @author zhengjiong
 */
class PlaceHolderExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo9_placeholder_layout)

        val save = findViewById<ImageButton>(R.id.save)
        val root = findViewById<ConstraintLayout>(R.id.root)
        val cancel = findViewById<ImageButton>(R.id.cancel)
        val edit = findViewById<ImageButton>(R.id.edit)
        val delete = findViewById<ImageButton>(R.id.delete)
        val template_action = findViewById<Placeholder>(R.id.template_action)

        /*动态替换

        PlaceHolder还可以在Java代码中动态替换自己的内容：

        如果结合过渡动画的话，就可以实现一些比较有趣的效果：

        */
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