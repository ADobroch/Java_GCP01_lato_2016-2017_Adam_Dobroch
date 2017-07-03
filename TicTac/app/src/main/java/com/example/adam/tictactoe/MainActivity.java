package com.example.adam.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;

    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);


        turn =1;

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w) {
                if (b1.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b1.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b1.setText("O");
                    }

                }
                finishGame();
            }

        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b2.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b2.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b2.setText("O");
                    }

                }

                finishGame();
            }

        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b3.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b3.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b3.setText("O");
                    }

                }
                finishGame();
            }

        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b4.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b4.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b4.setText("O");
                    }

                }
                finishGame();
            }

        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b5.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b5.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b5.setText("O");
                    }

                }
                finishGame();
            }

        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b6.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b6.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b6.setText("O");
                    }

                }
                finishGame();
            }

        });
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b7.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b7.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b7.setText("O");
                    }

                }
                finishGame();
            }

        });
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b8.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b8.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b8.setText("O");
                    }

                }
                finishGame();
            }

        });
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                if (b9.getText().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b9.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        b9.setText("O");
                    }

                }
                finishGame();
            }

        });

    }

    public void finishGame()
    {

       Boolean endGame =false;

        String But1,But2,But3,But4,But5,But6,But7,But8,But9;

        But1 =b1.getText().toString();
        But2 =b2.getText().toString();
        But3 =b3.getText().toString();
        But4 =b4.getText().toString();
        But5 =b5.getText().toString();
        But6 =b6.getText().toString();
        But7 =b7.getText().toString();
        But8 =b8.getText().toString();
        But9 =b9.getText().toString();

        if (But1.equals(But2) && But1.equals(But3) && But1 != "") {
            Toast.makeText(MainActivity.this, "Player " + But1 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But4.equals(But5) && But4.equals(But6) && But4 != "") {
            Toast.makeText(MainActivity.this, "Player " + But4 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But7.equals(But8) && But7.equals(But9) && But7 != "") {
            Toast.makeText(MainActivity.this, "Player " + But7 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But1.equals(But4) && But1.equals(But7) && But1 != "") {
            Toast.makeText(MainActivity.this, "Player " + But1 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But2.equals(But5) && But2.equals(But8) && But2 != "") {
            Toast.makeText(MainActivity.this, "Player " + But2 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But3.equals(But6) && But3.equals(But9) && But3 != "") {
            Toast.makeText(MainActivity.this, "Player " + But3 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But1.equals(But5) && But1.equals(But9) && But1 != "") {
            Toast.makeText(MainActivity.this, "Player " + But1 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }

        if (But3.equals(But5) && But3.equals(But7) && But3 != "") {
            Toast.makeText(MainActivity.this, "Player " + But3 + " Wins", Toast.LENGTH_LONG).show();
            endGame = true;
        }





        if(endGame)
        {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);

            startActivity(new Intent(getApplicationContext(),playAgain.class));
        }
        if(But1 !="" && But2 !="" && But3 !="" && But4 !="" && But5 !="" &&
                But6 !="" && But7 !="" && But8 !="" && But9 !=""  )
        {
            Toast.makeText(MainActivity.this, "Tie!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),playAgain.class));
        }
    }
}
