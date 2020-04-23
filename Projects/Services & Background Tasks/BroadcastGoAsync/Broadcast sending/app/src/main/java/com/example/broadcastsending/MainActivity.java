package com.example.broadcastsending;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.codinginflow.EXAMPLE_ACTION");

        intent.setPackage("com.codinginflow.broadcastexample");

        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");

        sendOrderedBroadcast(intent, null, new SenderReceiver(),
                null, 0, "Start", extras);
    }
}
