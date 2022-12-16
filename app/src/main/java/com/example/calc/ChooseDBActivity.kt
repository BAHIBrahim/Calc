package com.example.calc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.databinding.ActivityChooseDbBinding

private const val TAG = "ChooseDBActivity"


class ChooseDBActivity : AppCompatActivity() {

    lateinit var binding: ActivityChooseDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener() { handleKeyEvent() }
        binding.dbConnectionText.setText("Notes.db")

    }


    //method to handle onSubmit event; enter button clicked event
    private fun handleKeyEvent() {
        Log.d(TAG, KeyEvent.KEYCODE_ENTER.toString() + "hey")

        //return the given value
        //MyDatabaseHelper.DATABASE_NAME = "[" + binding.dbConnectionText.text + "]"
        //Log.d(TAG, "your db name: " + MyDatabaseHelper.DATABASE_NAME)
        intent = Intent(this, MemoActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "this is on start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "this is on restart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "this is on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "this is on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "this is on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "this is on destroy")
    }
}