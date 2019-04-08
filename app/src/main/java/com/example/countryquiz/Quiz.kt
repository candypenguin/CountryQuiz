package com.example.countryquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Quiz : AppCompatActivity() {

    var buttons: Array<Button>? = null
    var quiz: Question? = null
    var Question: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        Question = findViewById<ImageView?>(R.id.Question)
        buttons = arrayOf(findViewById(R.id.Answer1),findViewById(R.id.Answer2),
            findViewById(R.id.Answer3),findViewById(R.id.Answer4))

        // データの取得
        if (intent != null) {
            quiz = intent.getSerializableExtra("Question") as Question
            show()
        }
    }

    fun show() {
        if (quiz != null) {
            Question!!.setImageResource(quiz!!.image)
            for (i in buttons!!.indices) {
                buttons!![i].text = quiz!!.choices[i]
            }
        }
    }

    fun answer(view: View) {
        val intentResult  = Intent(this, Result::class.java)
        intentResult.putExtra("Quiz", quiz )
        for (i in buttons!!.indices) {
            if (view.id == buttons!![i].id) {
                if (i == quiz!!.answer_index) {
                    intentResult.putExtra("Answer",true)
                    startActivity(intentResult)
                } else {
                    intentResult.putExtra("Answer",false)
                    startActivity(intentResult)
                }
            }
        }
    }
}

