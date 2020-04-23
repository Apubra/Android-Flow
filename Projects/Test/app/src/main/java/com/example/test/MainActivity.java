package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Message", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Message", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Message", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);

        activityManager.moveTaskToFront(getTaskId(), 0);
        Log.i("Message", "onPause");

    }

    @Override
    protected void onStop() {
        super.onRestart();
        super.onStop();
        Log.i("Message", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onRestart();
        super.onDestroy();
        Log.i("Message", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Message", "onRestart");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Do nothing or catch the keys you want to block
        if ((keyCode == KeyEvent.KEYCODE_HOME)) {

            return false;

        }
        return false;
    }
}
