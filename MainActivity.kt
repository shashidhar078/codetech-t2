package com.example.bodymi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val bmiResultTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val bmiInterpretationTextView = findViewById<TextView>(R.id.bmiInterpretationTextView)

        calculateButton.setOnClickListener {
            val heightText = heightEditText.text.toString()
            val weightText = weightEditText.text.toString()

            if (heightText.isNotEmpty() && weightText.isNotEmpty()) {
                val height = heightText.toDouble()
                val weight = weightText.toDouble()

                // Calculate BMI
                val bmi = weight / height.pow(2)
                bmiResultTextView.text = "Your BMI: %.2f".format(bmi)

                // Determine BMI category
                val interpretation = when {
                    bmi < 18.5 -> "Underweight"
                    bmi in 18.5..24.9 -> "Normal weight"
                    bmi in 25.0..29.9 -> "Overweight"
                    else -> "Obesity"
                }
                bmiInterpretationTextView.text = interpretation
            } else {
                bmiResultTextView.text = "Please enter both height and weight."
                bmiInterpretationTextView.text = ""
            }
        }
    }
}
