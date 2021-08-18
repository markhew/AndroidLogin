package com.example.myapplication.ui.mainApp

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val view = findViewById<View>(R.id.lineView)
        val parent = findViewById<View>(R.id.parent)

        parent.viewTreeObserver.addOnGlobalLayoutListener {
            val height: Int = view.getMeasuredHeight()
            savedInstanceState?.getFloat(YKEY).let {
                it?.let {
                    view.y = it * height
                }
            }
        }


        var listener = View.OnTouchListener( function  = {view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_MOVE){
                view.y = motionEvent.rawY - view.height
                view.x = view.x
            }
            true
        })

        view.setOnTouchListener(listener)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val view = findViewById<View>(R.id.lineView)
        val ratio = view.y / view.measuredHeight
        outState.putFloat(YKEY,ratio)

    }


    companion object {
        val YKEY = "VIEW_Y"
    }
}