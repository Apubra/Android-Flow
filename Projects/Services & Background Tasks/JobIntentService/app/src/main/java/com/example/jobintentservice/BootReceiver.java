package com.example.jobintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //MyService.enqueueWork(context, new Intent());
            Intent serviceIntent = new Intent(context, ExampleJobIntentService.class);
            serviceIntent.putExtra("inputExtra", "input");

            ExampleJobIntentService.enqueueWork(context, serviceIntent);
        }
    }
}
