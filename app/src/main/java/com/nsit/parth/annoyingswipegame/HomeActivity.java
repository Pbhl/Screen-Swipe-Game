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
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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


public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#03A9F4"));
    }
    public void btnStartOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), AndroidSimpleGestureActivity.class);
        startActivity(intent);
    }

    public void btnInstrOnClick(View view) {
        InstrDialog dialogFragment = new InstrDialog();
        dialogFragment.show(getFragmentManager(),
                getResources().getString(R.string.how_to_play));
    }
}





