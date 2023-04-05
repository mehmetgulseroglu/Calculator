package com.mehmetcangulse.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehmetcangulse.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            calculate("+")
        }

        binding.btnMinus.setOnClickListener {
            calculate("-")
        }

        binding.btnMultiply.setOnClickListener {
            calculate("*")
        }

        binding.btnDivide.setOnClickListener {
            calculate("/")
        }

        binding.btnClear.setOnClickListener {
            binding.etNumber1.setText("")
            binding.etNumber2.setText("")
            binding.tvResult.text = ""
        }
    }

    private fun calculate(operator: String) {
        val num1 = binding.etNumber1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = binding.etNumber2.text.toString().toDoubleOrNull() ?: 0.0
        var result = 0.0

        when (operator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    binding.tvResult.text = "Cannot divide by zero"
                    return
                }
            }
        }

        binding.tvResult.text = result.toString()
    }
}