package com.example.adam.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class playAgain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);
    }

    public void tryAgian(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
