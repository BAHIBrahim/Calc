package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.R
import android.content.pm.ActivityInfo
import com.example.calc.MyDatabaseHelper
import android.widget.Toast
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.calc.databinding.ActivityUpdateBinding

private const val TAG = "UpdateActivity"

class UpdateActivity : AppCompatActivity() {
    lateinit var id: String
    lateinit var titre: String
    lateinit var note: String
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fix screen mode to portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //The most important call since it will initialize all the late init vars
        andSetIntentData

        Log.d(TAG, "-1 is clear")
        binding.updateButton.setOnClickListener { //And only then we call this
            val myDB = MyDatabaseHelper(this)
            titre = binding.titleText.text.toString().trim { it <= ' ' }
            note = binding.contentText.text.toString().trim { it <= ' ' }
            myDB.updateData(id, titre, note)
            super.onBackPressed();
            finish();
        }
        Log.d(TAG, "1 is clear")
        binding.deleteButton.setOnClickListener { confirmDialog() }
        Log.d(TAG, "2 is clear")
        Log.d(TAG, "onCreate is left")
    }

    //Getting Data from Intent
    //Setting Intent Data
    val andSetIntentData: Unit
        get() {
            if (intent.hasExtra("id") && intent.hasExtra("titre") &&
                intent.hasExtra("note")
            ) {
                //Getting Data from Intent
                Log.d(TAG, "3 is clear")
                id = intent.getStringExtra("id")?:""
                titre = intent.getStringExtra("titre")?:""
                note = intent.getStringExtra("note")?:""
                Log.d(TAG, "4 is clear")
                //Setting Intent Data
                binding.titleText.setText(titre)
                binding.contentText.setText(note)
            } else {
                Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show()
            }
            Log.d(TAG, "getAndSetIntentData is left")
        }

    fun confirmDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete $titre ?")
        builder.setMessage("Are you sure you want to delete $titre ?")
        builder.setPositiveButton("Yes") { dialogInterface, i ->
            val myDB = MyDatabaseHelper(this)
            myDB.deleteOneRow(id)
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface, i -> }
        builder.create().show()
        Log.d(TAG, "ConfirmDialog is left")
    }
}