package com.example.adam.javaandroid;

import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RunnableFuture;

public class main extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView protagonist;
    private ImageView avoid;
    private ImageView collect;

    private int protagonistY;
    private int avoidY;
    private int collectY;
    private int collectX;
    private int avoidX;


    private int score = 0;


    private Handler handler = new Handler();
    private Timer timer = new Timer();


    private boolean action_flg = false;
    private boolean start_flg = false;

    private int frameHeight;
    private int protagonistSize;
    private int screenHeight;
    private int screenWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreLabel =(TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        protagonist =(ImageView) findViewById(R.id.protagonist);
        avoid = (ImageView) findViewById(R.id.avoid);
        collect = (ImageView) findViewById(R.id.collect);


        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size =  new Point();
        disp.getSize(size);


        screenWidth = size.x;
        screenHeight = size.y;



        //avoid.setX(80);
       // avoid.setY(80);
        //collect.setX(80);
       // collect.setY(80);


        startLabel.setVisibility(View.VISIBLE);

        scoreLabel.setText("Score : 0");




    }

    public void changePos()
    {

        collisionCheck();


        //Collect

        collectX -= 12;
        if (collectX<0)
        {
            collectX = screenWidth +20;
            collectY = (int) Math.floor(Math.random()*(frameHeight - collect.getHeight()));

        }
        collect.setY(collectY);
        collect.setX(collectX);



        //Avoid

        avoidX -= 16;
        if (avoidX<0)
        {
            avoidX = screenWidth +10;
            avoidY = (int) Math.floor(Math.random()*(frameHeight - avoid.getHeight()));

        }
        avoid.setY(avoidY);
        avoid.setX(avoidX);

        //Player position

        if (action_flg ==true)
        {
            protagonistY -=20;
        }
        else {
            protagonistY += 20;
        }
        if (protagonistY < 0)
            protagonistY =0;

        if (protagonistY > frameHeight - protagonistSize)
            protagonistY =frameHeight - protagonistSize;

        protagonist.setY(protagonistY);

        scoreLabel.setText("Score : "+ score);
    }

    public void collisionCheck()
    {
        //Collect

        int collectCenterX =  collectX + collect.getWidth() /2;
        int collectCenterY =  collectY + collect.getHeight() /2;

        if (0 <= collectCenterX && collectCenterX <= protagonistSize &&
                protagonistY <= collectCenterY && collectCenterY <= protagonistY + protagonistSize)
        {
            score += 10;
            collectX = -10;
        }

        //avoid
        int avoidCenterX =  avoidX + avoid.getWidth() /2;
        int avoidCenterY =  avoidY + avoid.getHeight() /2;

        if (0 <= avoidCenterX && avoidCenterX <= protagonistSize &&
                protagonistY <= avoidCenterY && avoidCenterY <= protagonistY + protagonistSize)
        {
           timer.cancel();
            timer = null;


            //Result
            Intent intent = new Intent(getApplicationContext(),result.class);
            intent.putExtra("SCORE",score);
            startActivity(intent);

        }


    }

    public boolean   onTouchEvent(MotionEvent me)
    {

        if (start_flg == false)
        {
            start_flg =true;


            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            protagonistY = (int)protagonist.getY();

            protagonistSize = protagonist.getHeight();

            startLabel.setVisibility(View.GONE);



            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });

                }
            },0,20);
        }
        else
        {
            if (me.getAction() == MotionEvent.ACTION_DOWN){
                action_flg =true;

            }
            else if(me.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;

            }

        }

        return true;
    }

}
