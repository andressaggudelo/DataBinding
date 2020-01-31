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
    private val data: MyData = MyData()
    private var count: Int = 0
    private var result = "Your name is "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.dataVar = data

        binding.submitButton.setOnClickListener {
            count++
            getData(it)
        }
    }

    private fun getData(view: View) {

        when (count) {
            1 -> {
                binding.apply {
                    nameText.visibility = View.GONE
                    result += answerEdit.text.toString() + " "
                    lastnameText.visibility = View.VISIBLE
                    answerEdit.setText("")
                }

            }
            2 -> {
                binding.apply {
                    lastnameText.visibility = View.GONE
                    result += answerEdit.text.toString() + ", and you're "
                    ageText.visibility = View.VISIBLE
                    answerEdit.setText("")
                }

            }
            3 -> {
                // Show it there
                binding.apply {
                    ageText.visibility = View.GONE
                    submitButton.visibility = View.GONE
                    answerEdit.visibility = View.GONE

                    result += answerEdit.text.toString() + " years old"
                    data.res = result
                    invalidateAll()
                    answerText.visibility = View.VISIBLE
                }

            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
