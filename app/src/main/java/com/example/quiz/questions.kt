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
import com.example.quiz.databinding.ActivityQuestionsBinding

class questions : AppCompatActivity() {
    private lateinit var binidn: ActivityQuestionsBinding
    val questionlist = constants.getq()
    var pos = 1
    val question: Question? = questionlist[pos-1]
    val ans=question!!.correctAnswer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindin = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(bindin.root)

        val option1=bindin.option1
        val option2=bindin.option2
        val option3=bindin.option3
        val option4=bindin.option4
        val flag=bindin.flag
        binidn.sumbit.setOnClickListener {
            sumbit()
        }


        bindin.question.text=question!!.question
        option1.text = question.optionOne
        option2.text = question.optionTwo
        option3.text=question.optionThree
        bindin.option4.text=question.optionFour
        bindin.flag.setImageResource(question.image)




    }
    var clicked: Int=0
    fun id(view:View){
        if(clicked!=0){
            findViewById<TextView>(R.id.option1).background=ContextCompat.getDrawable(this@questions,R.drawable.optionbg)
            findViewById<TextView>(R.id.option2).background=ContextCompat.getDrawable(this@questions,R.drawable.optionbg)
            findViewById<TextView>(R.id.option3).background=ContextCompat.getDrawable(this@questions,R.drawable.optionbg)
            findViewById<TextView>(R.id.option4).background=ContextCompat.getDrawable(this@questions,R.drawable.optionbg)
        }
        val bindin = ActivityQuestionsBinding.inflate(layoutInflater)
        var view=view as TextView
        
        when(view.id){
            findViewById<TextView>(R.id.option1).id->{
                findViewById<TextView>(R.id.option1).background=ContextCompat.getDrawable(this@questions,R.drawable.selected)
                clicked=1
            }
            findViewById<TextView>(R.id.option2).id->{
                clicked=2
                findViewById<TextView>(R.id.option2).background=ContextCompat.getDrawable(this@questions,R.drawable.selected)
            }
            findViewById<TextView>(R.id.option3).id->{
                clicked=3
                findViewById<TextView>(R.id.option3).background=ContextCompat.getDrawable(this@questions,R.drawable.selected)
            }
            findViewById<TextView>(R.id.option4).id->{
                findViewById<TextView>(R.id.option4).background=ContextCompat.getDrawable(this@questions,R.drawable.selected)
                clicked=4
            }
        }
        Toast.makeText(this, "${clicked}", Toast.LENGTH_SHORT).show()

    }
    fun sumbit(){


    }

}