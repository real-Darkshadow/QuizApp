package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.quiz.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        binding.startbtn.setOnClickListener {
            if (binding.textField.editText?.text?.isEmpty() == true) {
                Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show()
            } else {
                val intent: Intent = Intent(this, questions()::class.java)
                startActivity(intent)
            }
        }

    }
}