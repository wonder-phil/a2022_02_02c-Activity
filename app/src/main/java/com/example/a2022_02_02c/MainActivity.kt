package com.example.a2022_02_02c

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val toScoreActivity: EditText
        get() = findViewById(R.id.to_score_activity)

    private val buttonToScoreActivity: Button
        get() = findViewById(R.id.button_to_ScoreActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent?.let{
            val myText = it.getStringExtra("FROM_SCORE")
            toScoreActivity.setText(myText)
        }

        buttonToScoreActivity.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                Intent(baseContext,ScoreActivity::class.java).also {
                    scoreActivity ->
                        scoreActivity.putExtra("FROM_MAIN",toScoreActivity.getText().toString())
                        startActivity(scoreActivity)

                }

            }

        })

    }
}