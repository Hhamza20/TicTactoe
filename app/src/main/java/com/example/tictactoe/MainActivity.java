package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int flag = 0;
    int count = 0;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, newBtn,rematchBtn;
    TextView playerTurn, playerOne, playerTwo;
    String player1;
    String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent receiver = getIntent();
        player1 = receiver.getStringExtra("nameOne");
        player2 = receiver.getStringExtra("nameTwo");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        newBtn = findViewById(R.id.newBtn);
        rematchBtn=findViewById(R.id.rematchBtn);


        playerTurn = findViewById(R.id.playerTurn);
        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);

        if (count == 0) {
            playerTurn.setText(player1 + "'s turn");
        }
        playerOne.setText(player1 + "\nX");
        playerTwo.setText(player2 + "\nO");

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGame = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(newGame);
            }
        });

        rematchBtn.setOnClickListener(view->{
            flag=0;
            count=0;
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");
            playerTurn.setText(player1 + "'s turn");
            enableButtons();
        });

    }

    public void mark(View v) {
        Button current = (Button) v;
        if (current.getText().toString().equals("")) {
            if (flag == 0) {
                playerTurn.setText(player2 + "'s turn");
                current.setText("X");
                flag = 1;
            } else if (flag == 1) {
                playerTurn.setText(player1 + "'s turn");
                current.setText("O");
                flag = 0;
            }
            count++;
            checkWin();
        }
    }

    public void checkWin() {
        String btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
        btnOne = btn1.getText().toString();
        btnTwo = btn2.getText().toString();
        btnThree = btn3.getText().toString();
        btnFour = btn4.getText().toString();
        btnFive = btn5.getText().toString();
        btnSix = btn6.getText().toString();
        btnSeven = btn7.getText().toString();
        btnEight = btn8.getText().toString();
        btnNine = btn9.getText().toString();
        if (count >= 5) {
            if (btnOne.equals(btnTwo) && btnOne.equals(btnThree) && !btnOne.equals("")) {
                if (btnOne.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnFour.equals(btnFive) && btnFour.equals(btnSix) && !btnFour.equals("")) {
                if (btnFour.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnSeven.equals(btnEight) && btnSeven.equals(btnNine) && !btnSeven.equals("")) {
                if (btnSeven.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnOne.equals(btnFour) && btnOne.equals(btnSeven) && !btnOne.equals("")) {
                if (btnSeven.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnTwo.equals(btnFive) && btnTwo.equals(btnEight) && !btnTwo.equals("")) {
                if (btnTwo.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnThree.equals(btnSix) && btnThree.equals(btnNine) && !btnThree.equals("")) {
                if (btnThree.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnOne.equals(btnFive) && btnOne.equals(btnNine) && !btnOne.equals("")) {
                if (btnOne.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            } else if (btnThree.equals(btnFive) && btnThree.equals(btnSeven) && !btnThree.equals("")) {
                if (btnSeven.equals("X"))
                    Toast.makeText(this, player1 + " Won!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, player2 + " Won!", Toast.LENGTH_SHORT).show();
                disableButtons();
            }
        }
        if(count==9){
            Toast.makeText(this, "Match is Draw! Start New Game!", Toast.LENGTH_SHORT).show();
            disableButtons();
        }
    }

    public void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        newBtn.setEnabled(true);
        flag = 0;
        count = 0;
    }
    public void enableButtons(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        newBtn.setEnabled(false);
    }
}