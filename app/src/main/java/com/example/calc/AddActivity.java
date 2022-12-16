package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calc.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //we need to override every activity onRestart method, so that it will return to the main activity: a security measure
        Log.d("MyAc", "onRestart");
    }

    public void onClickAdd() {
        Log.d("nothing", "values: " + binding.contentText.toString());
        if(binding.titleText.getText().toString() == "" || binding.contentText.getText().toString() == "") {
            MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
            myDB.addNote(binding.titleText.getText().toString().trim(),
                    binding.contentText.getText().toString().trim()
            );
        } else {
            Log.d("nothing", "nothing");
        }

        //AddActivity.super.onBackPressed();
    }
}
