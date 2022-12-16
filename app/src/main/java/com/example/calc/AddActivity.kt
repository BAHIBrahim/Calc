package com.example.calc

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.databinding.ActivityAddBinding


private const val TAG = "AddActivity"

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //fix screen mode to portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.addButton.setOnClickListener { onClickAdd() }
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

    fun onClickAdd() {
        Log.d("nothing", "here")
        Log.d("nothing", "values: " + binding.contentText.text.toString())
        if (binding.titleText.text.toString() != "" && binding.contentText.text.toString() != "") {
            val myDB = MyDatabaseHelper(this)
            myDB.addNote(
                binding.titleText.text.toString().trim { it <= ' ' },
                binding.contentText.text.toString().trim { it <= ' ' }
            )
        } else {
            Log.d("nothing", "nothing")
        }

        super.onBackPressed();
        finish();
    }
}