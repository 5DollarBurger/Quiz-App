package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val questionList = Constants.getQuestions()
        Log.i("Questions Size","${questionList.size}")

        val currentPosition = 1
        val question : Question? = questionList[currentPosition - 1]

        binding.pb.progress = currentPosition
        binding.tvProgress.text = "${currentPosition}/" + binding.pb.max

        binding.ivImage.setImageResource(question!!.image)
        binding.tvQuestion.text = question!!.question
        binding.tvOption1.text = question!!.option1
        binding.tvOption2.text = question!!.option2
        binding.tvOption3.text = question!!.option3
        binding.tvOption4.text = question!!.option4
    }
}