package com.andressaggudelo.questions

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.andressaggudelo.questions.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count: Int = 0
    private var result = "Your name is "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submitButton.setOnClickListener {
            count++
            getData(it)
        }
    }

    private fun getData(view: View) {

        when (count) {
            1 -> {
                binding.nameText.visibility = View.GONE
                result += binding.answerEdit.text.toString() + " "
                binding.lastnameText.visibility = View.VISIBLE
                binding.answerEdit.setText("")
            }
            2 -> {
                binding.lastnameText.visibility = View.GONE
                result += binding.answerEdit.text.toString() + ", and you're "
                binding.ageText.visibility = View.VISIBLE
                binding.answerEdit.setText("")
            }
            3 -> {
                // Show it there
                binding.ageText.visibility = View.GONE
                binding.submitButton.visibility = View.GONE
                binding.answerEdit.visibility = View.GONE

                result += binding.answerEdit.text.toString() + " years old"
                binding.answerText.text = result
                binding.answerText.visibility = View.VISIBLE
            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
