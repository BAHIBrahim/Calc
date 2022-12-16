package com.example.calc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.calc.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
private const val PASSWORD = "101010"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding //binding is better when dealing with too many views
    lateinit var noTextButtons: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //removing the event of: displaying the soft input -virtual keyboard- when clicked
        binding.display.showSoftInputOnFocus = false

        //setting the cursor position at the end of display edit text
        binding.display.setSelection(binding.display.length())

        noTextButtons = listOf(
            //this list contains the buttons that have no text value, or we are not interested in retrieving their text content.
            binding.button1.id,
            if (binding.button4.text == "C") binding.button4.id else binding.button1.id, //because button 4 of the portrait version of our main layout is a text button " has ÷ as text", we can't include it in the nonTextButtons list
            if (binding.button2.text == "Rad") binding.button2.id else binding.button1.id, //same goes for this button as the previous one, kotlin has no ternary operator instead its if else statements can return values, we return button 1 id since we already know it is a no text button
            (binding.button36
                ?: binding.button20).id, //the equals button is labeled differently between the landscape and portrait layout
        )
    }

    fun imageButtonOnClickListener(v: View) {
        val imageButton: ImageButton = v as ImageButton
        Log.d(TAG, "$imageButton was clicked")
        if(imageButton == binding.backspaceButton) {
            val pos: Int = binding.display.selectionStart
            if (pos > 0) binding.display.text.delete(pos - 1, pos).toString()
        }
    }

    fun onClickListener(v: View) { //Implementing the business layer logic of the calculator is not the goal of this app although it's essential for production alongside refining the UI making it more akin to the device original calculator, here we decided to mimic the latest samsung calculator app on android.
        val b: Button = v as Button
        Log.v(TAG, binding.display.text.toString())
        if(binding.display.text.toString() == PASSWORD) {
            Log.d(TAG, "password checked, you may pass.")
            val intent = Intent(this, ChooseDBActivity::class.java)
            startActivity(intent)
        }
        if (noTextButtons.contains(v.id)) {
            Log.d(TAG, "a no text button was clicked")
            if(v.text == "C") {

            }
        } else {
            Log.d(TAG, "a text button was clicked, text: " + v.text)
            //insert text in the exact position as the cursor pointer
            val start = binding.display.selectionStart.coerceAtLeast(0) //getting the selection start index
            val end = binding.display.selectionEnd.coerceAtLeast(0) //the selection end index
            //since there is no value between to adjacent array elements replace will work as an insert substitute
            binding.display.text.replace( //I had no idea that such method 'coerceAtMost' exists so as always when I used math.max, math.min, ... I got a suggestion to use it"
                start.coerceAtMost(end), start.coerceAtLeast(end),
                b.text, 0, b.text.length
            )
        }
    }
}