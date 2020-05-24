package com.e.childnutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 5000; //showing splash screen for 5 seconds

    //adding variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView appName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //for hiding status bar
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.splash_image);
        appName = findViewById(R.id.app_name);

        //Assigning animations to image and text
        image.setAnimation(topAnim);
        appName.setAnimation(bottomAnim);

        //To handle the delay process for other activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image,"app_logo");
                pairs[1] = new Pair<View,String>(appName,"login_slogan");


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs); //this works when API level is 21 and avoids application from being crash
                    startActivity(intent,options.toBundle());//intent calls next screen and options.tobundle carries animation
                }
                //finish();
            }
        },SPLASH_SCREEN);
    }
}
