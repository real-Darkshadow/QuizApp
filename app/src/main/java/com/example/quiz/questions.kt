package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.databinding.ActivityQuestionsBinding

class questions : AppCompatActivity() {
    private lateinit var binidng:ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}