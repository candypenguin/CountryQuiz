package com.example.countryquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Question.init()

        val startButton = findViewById<Button>(R.id.StartButton)
        startButton.setOnClickListener{
            //遷移先に送るデータ
            val intent  = Intent(this, Quiz::class.java)
            intent.putExtra("Question", Question.getQuiz(0))
            startActivity(intent)
        }
    }
}
