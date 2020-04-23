package com.example.broadcastsending;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

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
        //intent.setClass(this, ExampleBroadcastReceiver2.class);

        /*ComponentName cn = new ComponentName("com.codinginflow.broadcastexample",
                "com.codinginflow.broadcastexample.ExampleBroadcastReceiver");
        intent.setComponent(cn);*/

        /*intent.setClassName("com.codinginflow.broadcastexample",
                "com.codinginflow.broadcastexample.ExampleBroadcastReceiver");*/

        //intent.setPackage("com.codinginflow.broadcastexample");

        PackageManager packageManager = getPackageManager();

        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(intent, 0);

        for (ResolveInfo info : infos) {
            ComponentName cn = new ComponentName(info.activityInfo.packageName,
                    info.activityInfo.name);
            intent.setComponent(cn);
            sendBroadcast(intent);
        }

        //sendBroadcast(intent);
    }
}
