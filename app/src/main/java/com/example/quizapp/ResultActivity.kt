package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Hide UI
        window?.decorView?.apply {systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN}

        binding.tvUsername.text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val score = intent.getIntExtra(Constants.SCORE,0)
        binding.tvScore.text = "You scored $score out of $totalQuestions"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            // Close current activity
            finish()
        }
    }
}