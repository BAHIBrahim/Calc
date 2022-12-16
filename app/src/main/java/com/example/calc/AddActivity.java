package com.example.save;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText titre_input, note_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        titre_input = findViewById(R.id.titre_input);
        note_input = findViewById(R.id.note_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titre_input.getText().toString().trim() == "" || note_input.getText().toString().trim() == "") {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                    myDB.addNote(titre_input.getText().toString().trim(),
                            note_input.getText().toString().trim()
                    );
                } else {
                    //do nothing ofc
                }

                AddActivity.super.onBackPressed();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //we need to override every activity onRestart method, so that it will return to the main activity: a security measure
        Log.d("MyAc", "onRestart");
    }
}
