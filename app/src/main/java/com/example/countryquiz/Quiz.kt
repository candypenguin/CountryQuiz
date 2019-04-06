package com.example.countryquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Quiz : AppCompatActivity() {

    var buttons: Array<Button> = arrayOf()
    var quiz: Question? = null
    var Question: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // 画面上のウィジェットを取得しておく
        Question = findViewById<ImageView?>(R.id.Question)
        buttons[0] = findViewById(R.id.Answer1)
        buttons[1] = findViewById(R.id.Answer2)
        buttons[2] = findViewById(R.id.Answer3)
        buttons[3] = findViewById(R.id.Answer4)

        // データを受け取る
        val intent = intent
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
                    startActivity(intent)
                } else {
                    intentResult.putExtra("Answer",false)
                    startActivity(intent)
                }
            }
        }
    }
}

