package com.example.materialdesignexample

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        window.setFlags(

            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animator)
        var bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        image_view.animation = topAnim
        text_view.animation = bottomAnim
        button_begin.animation = bottomAnim

        button_begin.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }


    }
}