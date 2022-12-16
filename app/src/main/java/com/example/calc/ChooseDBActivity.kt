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
import androidx.core.widget.doOnTextChanged
import com.example.calc.databinding.ActivityChooseDbBinding

private const val TAG = "ChooseDBActivity"


class ChooseDBActivity : AppCompatActivity() {

    lateinit var binding: ActivityChooseDbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener() { loginClicked() }
        binding.dbConnectionText.doOnTextChanged { text, start, before, count -> binding.dbConnection.error ="" }
        binding.dbConnectionText.setText("Notesdb")

    }


    private fun loginClicked() {
        //return the given value
        //MyDatabaseHelper.DATABASE_NAME = "[" + binding.dbConnectionText.text + "]"
        //Log.d(TAG, "your db name: " + MyDatabaseHelper.DATABASE_NAME)
        //checking if the given name doesn't start with a number, if it does we won't take it and instead we trigger an error.
        if((('A'..'z').minus(('['..'`')).plus('_')).contains((binding.dbConnectionText.text?:"9").first())) {
            intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
        } else {
            binding.dbConnection.error = "numbers are not allowed initials"
        }

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