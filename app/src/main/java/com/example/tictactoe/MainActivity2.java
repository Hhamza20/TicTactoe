package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText nameOne, nameTwo;
        nameOne = findViewById(R.id.nameOne);
        nameTwo = findViewById(R.id.nameTwo);
        Button startBtn;
        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(v -> {
            if (nameOne.getText().toString().equals("") || nameTwo.getText().toString().equals("")) {
                Toast.makeText(this, "Please Enter both Players' name", Toast.LENGTH_SHORT).show();
            } else {
                Intent gameScreen = new Intent(MainActivity2.this, MainActivity.class);
                gameScreen.putExtra("nameOne", nameOne.getText().toString());
                gameScreen.putExtra("nameTwo", nameTwo.getText().toString());
                startActivity(gameScreen);
            }
        });
    }
}