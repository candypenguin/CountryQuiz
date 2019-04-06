package com.example.countryquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    var quiz: Question? = null
    var answer: TextView? = null
    var correct: Boolean = true
    var spot: ImageView? = null
    var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        spot = findViewById<ImageView?>(R.id.spot)
        result= findViewById(R.id.result)
        answer= findViewById(R.id.tips)
        var nextButton: Button  = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            quiz = Question.getQuiz(quiz!!.q_num + 1)
            if (quiz != null) {
                val intent  = Intent(this, Quiz::class.java)
                intent.putExtra("Question", quiz)
                startActivity(intent)
            } else {
                finish()
            }
        }

        val intentQuiz = intent
        if (intentQuiz != null) {
            quiz = intentQuiz.getSerializableExtra("Quiz") as Question
            correct = intentQuiz.getBooleanExtra("Answer", true)
            show()
        }

    }

    fun show() {
            spot!!.setImageResource(quiz!!.image)
            answer!!.text = quiz!!.commentary

            if(correct){
                result!!.text = "正解"
            }else{
                result!!.text = "不正解"
            }
    }

}
