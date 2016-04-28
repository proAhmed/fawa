package droidahmed.com.fawaz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);

        gotToNext(SPLASH_TIME);
    }
    private void gotToNext(int delayTime) {

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                displayNextActivity(SplashActivity.this, ChooseLang.class);
            }

        }, delayTime);

    }



    private void displayNextActivity(Activity currentActivity,
                                     Class<?> nextActivityClass) {

        Intent i = new Intent(currentActivity, nextActivityClass);

        startActivity(i);
        overridePendingTransition(0, 0);
        finish();

    }

}
