package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class result : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val corr=questions().correct
        var kl=intent.extras?.containsKey("name")
        findViewById<TextView>(R.id.test).text="Congratulations ${kl} your score is ${corr}"
    }
    fun reset(){
        intent= Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}