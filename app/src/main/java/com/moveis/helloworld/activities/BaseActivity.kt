package com.moveis.helloworld.activities

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

open class BaseActivity : AppCompatActivity() {

    fun toast(text : String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}