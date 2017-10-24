package com.air.mover.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.air.mover.R;

public class SplashScreen extends AppCompatActivity {

    private Intent myintent; //Lanzar la main activity despues de x segundos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_splash_screen);


        myintent = new Intent(this, MainActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(myintent);
                finish();
            }
        }, 2500);
    }
}
