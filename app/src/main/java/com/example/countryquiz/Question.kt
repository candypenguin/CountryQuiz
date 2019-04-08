package com.example.countryquiz

import android.media.Image
import java.io.Serializable

class Question constructor(var q_num: Int                 // 問題番号
                           , var image: Int               // 画像ID
                           , var choices: Array<String>   //選択肢のリスト
                           , var answer_index: Int        // 正解の選択肢
                           , var commentary: String       //観光地の解説
) : Serializable {

    //choices = arrayOfNulls<String>(4) // 選択肢
    companion object {

        private val quizzes = arrayOfNulls<Question>(5) // クイズの配列


        // 問題の登録(ここでは1問のみ)
        fun init() {

            quizzes[0] = Question(0, R.drawable.spain, arrayOf("スペイン", "フランス", "ロシア", "オランダ"),
                0 ,"スペインにあるサグラダファミリア")
            quizzes[1] = Question(1, R.drawable.america, arrayOf("アルゼンチン", "スイス", "アメリカ", "韓国"),
                2,"アメリカにある自由の女神")
            quizzes[2] = Question(2, R.drawable.canada, arrayOf("ブラジル", "カナダ", "エジプト", "日本"),
                1,"カナダにあるナイアガラの滝")
            quizzes[3] = Question(3, R.drawable.germany, arrayOf("ドイツ", "中国", "イギリス", "インド"),
                0,"ドイツにあるノイシュバンシュタイン城")
            quizzes[4] = Question(4, R.drawable.japan, arrayOf("イタリア", "アメリカ", "オーストラリア", "日本"),
                3,"日本の京都にある稲荷神社の鳥居")
        }

        // 問題を取得する
        fun getQuiz(num: Int): Question? {
            return if (num >= quizzes.size) {
                null
            } else quizzes[num]
        }
    }
}