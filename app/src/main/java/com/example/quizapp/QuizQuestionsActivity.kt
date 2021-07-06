package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null // global variable
    private var mSelectedOption : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mQuestionList = Constants.getQuestions()
//        Log.i("Questions Size","${questionList.size}")

        setQuestion()
        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)
    }

    private fun setQuestion() {
        mCurrentPosition = 1
        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        binding.pb.progress = mCurrentPosition
        binding.tvProgress.text = "${mCurrentPosition}/" + binding.pb.max

        binding.ivImage.setImageResource(question!!.image)
        binding.tvQuestion.text = question!!.question
        binding.tvOption1.text = question!!.option1
        binding.tvOption2.text = question!!.option2
        binding.tvOption3.text = question!!.option3
        binding.tvOption4.text = question!!.option4
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(binding.tvOption1)
        options.add(binding.tvOption2)
        options.add(binding.tvOption3)
        options.add(binding.tvOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOption1 -> selectedOptionView(binding.tvOption1,1)
            R.id.tvOption2 -> selectedOptionView(binding.tvOption2,2)
            R.id.tvOption3 -> selectedOptionView(binding.tvOption3,3)
            R.id.tvOption4 -> selectedOptionView(binding.tvOption4,4)
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int) {
        defaultOptionsView()
        mSelectedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}