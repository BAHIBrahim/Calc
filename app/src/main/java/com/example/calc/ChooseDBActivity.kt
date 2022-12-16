package com.example.calc

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.databinding.ActivityChooseDbBinding

private const val TAG = "ChooseDBActivity"


class ChooseDBActivity: AppCompatActivity() {

    lateinit var binding: ActivityChooseDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dbConnectionText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }

    }


    //method to handle onSubmit event; enter button clicked event
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {

            //Hide the virtual keyboard; soft keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

            //return the given value
            Log.d(TAG, "your db name: [" + binding.dbConnectionText.text + "]")
            return true
        }
        return false
    }
}