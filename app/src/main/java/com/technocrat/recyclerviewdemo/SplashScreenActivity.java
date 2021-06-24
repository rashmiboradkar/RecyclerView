package com.technocrat.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;
    private ImageView image;
    private TextView logo, slogan,textslogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash_screen);

        initialise();

        //setting Animation
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);

                SplashScreenActivity.this.finish();

            }
        }, 500);
    }

    private void initialise() {

        //Initialise Component
        image = findViewById(R.id.splashLogo);
        logo = findViewById(R.id.tvfoodlogo);
        slogan = findViewById(R.id.tvslogan);
        textslogan = findViewById(R.id.tv_slogan);

        //Initialise Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
    }
}