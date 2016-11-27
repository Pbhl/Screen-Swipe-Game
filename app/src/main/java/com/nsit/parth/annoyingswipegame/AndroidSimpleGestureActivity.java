package com.nsit.parth.annoyingswipegame;

/**
 * Created by parth on 15/10/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import java.util.Random;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnTouchListener;
public class AndroidSimpleGestureActivity extends AppCompatActivity {

    private static final int SWIPE_THRESHOLD = 300;
    private static final int SWIPE_VELOCITY_THRESHOLD = 300;
    final Random rnd = new Random();
    Integer imgno = rnd.nextInt(4);
    Integer scoreval = 0;
    Score scorefinal = new Score(0);


    CountDownTimer countDownTimer = new CountDownTimer(1500, 1500) {

        public void onTick(long millisUntilFinished) {
            //TODO: Do something every second
        }

        public void onFinish() {

            Intent intent = new Intent(AndroidSimpleGestureActivity.this, GameResultActivity.class);
            intent.putExtra("scoreval", scoreval);
            startActivity(intent);
            finish();

        }
    }.start();



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0288D1"));
        ImageView image = (ImageView) findViewById(R.id.imageView);
        String uri = "@drawable/img_" + String.valueOf(imgno);
        int imageResource = getResources().getIdentifier(uri, "drawable", getPackageName());
        image.setImageResource(imageResource);

    }
    @Override
    public boolean onTouchEvent (MotionEvent event){
        // TODO Auto-generated method stub
        return gestureDetector.onTouchEvent(event);
    }


/*
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        int i = 0;
        ImageView image = (ImageView) findViewById(R.id.imageView);

        public void run() {
            imgno = rnd.nextInt(4);
            String uri = "@drawable/img_" + String.valueOf(imgno);
            int imageResource = getResources().getIdentifier(uri, "drawable", getPackageName());
            image.setImageResource(imageResource);
            handler.postDelayed(this, 2000);
        }
    };

*/
int imgnotrack=1;

    SimpleOnGestureListener simpleOnGestureListener
            = new SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {

            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                ImageView image = (ImageView) findViewById(R.id.imageView);

                int i = 0;
                public void run() {
                    imgno = rnd.nextInt(4);
                    if(imgno==imgnotrack)
                    {
                        if(imgno==0)
                        {
                            imgno=1;
                        }
                        else if(imgno==3)
                        {
                            imgno=2;
                        }
                        else
                        {
                            imgno=imgnotrack+1;
                        }
                    }
                    String uri = "@drawable/img_" + String.valueOf(imgno);
                    int imageResource = getResources().getIdentifier(uri, "drawable", getPackageName());
                    imgnotrack=imgno;
                    image.setImageResource(imageResource);
                   // handler.postDelayed(this, 2000);
                }
            };


            handler.postDelayed(runnable, 300);
            boolean result = false;
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();

            if (diffY!=0 && diffX!=0) {
                countDownTimer.cancel();
                countDownTimer.start();
            }


            String swipe = "";
            float sensitvity = 200;
            TextView scorenum = (TextView) findViewById(R.id.scorenum);
            // TODO Auto-generated method stub
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        if (imgno == 2) {
                            scoreval = scoreval + 1;
                            scorenum.setText(String.valueOf(scoreval));
                        } else {
                            scorefinal.score = scoreval;
                            Intent intent = new Intent(AndroidSimpleGestureActivity.this, GameResultActivity.class);
                            intent.putExtra("scoreval", scoreval);
                            startActivity(intent);
                            countDownTimer.cancel();
                        }
                    } else {
                        if (imgno == 1) {
                            scoreval = scoreval + 1;
                            scorenum.setText(String.valueOf(scoreval));
                        } else {
                            scorefinal.score = scoreval;
                            Intent intent = new Intent(AndroidSimpleGestureActivity.this, GameResultActivity.class);
                            intent.putExtra("scoreval", scoreval);
                            startActivity(intent);
                            countDownTimer.cancel();
                        }
                    }
                }
                result = true;
            } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    if (imgno == 0) {
                        scoreval = scoreval + 1;
                        scorenum.setText(String.valueOf(scoreval));
                    } else {
                        scorefinal.score = scoreval;
                        Intent intent = new Intent(AndroidSimpleGestureActivity.this, GameResultActivity.class);
                        intent.putExtra("scoreval", scoreval);
                        startActivity(intent);
                        countDownTimer.cancel();
                    }
                } else {
                    if (imgno == 3) {
                        scoreval = scoreval + 1;
                        scorenum.setText(String.valueOf(scoreval));
                    } else {
                        scorefinal.score = scoreval;
                        Intent intent = new Intent(AndroidSimpleGestureActivity.this, GameResultActivity.class);
                        intent.putExtra("scoreval", scoreval);
                        startActivity(intent);
                        countDownTimer.cancel();
                    }
                }
            }
            result = true;
            return super.onFling(e1, e2, velocityX, velocityY);
        }

    };

    GestureDetector gestureDetector
            = new GestureDetector(simpleOnGestureListener);


}

