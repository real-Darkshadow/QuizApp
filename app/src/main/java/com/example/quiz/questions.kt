package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.quiz.constants.getq
import com.example.quiz.databinding.ActivityQuestionsBinding
import com.google.android.material.math.MathUtils.geq

class questions : AppCompatActivity() {
    private lateinit var binidn: ActivityQuestionsBinding
    val questionlist = constants.getq()
    var pos = 1
    val question: Question? = questionlist[pos - 1]
    var ans = question!!.correctAnswer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindin = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(bindin.root)

        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)
        val flag = findViewById<ImageView>(R.id.flag)
        val q=findViewById<TextView>(R.id.question)
        geq()
        findViewById<Button>(R.id.sumbit).setOnClickListener {
            sumbit()
        }
    }
    var clicked: Int = 0
    fun id(view: View) {
        if (clicked != 0) {
            res()
        }
        when (view.id) {
            findViewById<TextView>(R.id.option1).id -> {
                findViewById<TextView>(R.id.option1).background =
                    ContextCompat.getDrawable(this@questions, R.drawable.selected)
                clicked = 1
            }
            findViewById<TextView>(R.id.option2).id -> {
                clicked = 2
                findViewById<TextView>(R.id.option2).background =
                    ContextCompat.getDrawable(this@questions, R.drawable.selected)
            }
            findViewById<TextView>(R.id.option3).id -> {
                clicked = 3
                findViewById<TextView>(R.id.option3).background =
                    ContextCompat.getDrawable(this@questions, R.drawable.selected)
            }
            findViewById<TextView>(R.id.option4).id -> {
                findViewById<TextView>(R.id.option4).background =
                    ContextCompat.getDrawable(this@questions, R.drawable.selected)
                clicked = 4
            }
        }
        Toast.makeText(this, "${clicked}", Toast.LENGTH_SHORT).show()

    }

    var correct = 0
    fun sumbit() {
        if (clicked != 0 && clicked == ans) {
            correct++
            if(pos==(questionlist.size)){
                intent=Intent(this,result::class.java)
                startActivity(intent)}
            else{
                pos++
            geq()}
        }
        else if(pos==questionlist.size){
            intent=Intent(this,result::class.java)
            startActivity(intent)
        }
        else{
            pos++
            geq()

        }

    }

    fun geq(){
        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)
        val flag = findViewById<ImageView>(R.id.flag)
        val q=findViewById<TextView>(R.id.question)
        val question: Question? = questionlist[pos - 1]
        q.text = question!!.question
        option1.text = question.optionOne
        option2.text = question.optionTwo
        option3.text = question.optionThree
        option4.text = question.optionFour
        flag.setImageResource(question.image)
        ans=question.correctAnswer
        res()


    }
    fun res(){
        clicked=0
        findViewById<TextView>(R.id.option1).background =
            ContextCompat.getDrawable(this@questions, R.drawable.optionbg)
        findViewById<TextView>(R.id.option2).background =
            ContextCompat.getDrawable(this@questions, R.drawable.optionbg)
        findViewById<TextView>(R.id.option3).background =
            ContextCompat.getDrawable(this@questions, R.drawable.optionbg)
        findViewById<TextView>(R.id.option4).background =
            ContextCompat.getDrawable(this@questions, R.drawable.optionbg)
    }

}