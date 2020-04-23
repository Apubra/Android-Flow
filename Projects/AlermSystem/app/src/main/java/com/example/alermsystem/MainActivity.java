package com.example.alermsystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    Intent my_intent;

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        update_text = (TextView) findViewById(R.id.update_text);

        calendar = Calendar.getInstance();

        my_intent = new Intent(this.context, AlarmReceiver.class);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void alarmOn(View view){
        calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
        calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

        int hour = alarm_timepicker.getHour();
        int minute = alarm_timepicker.getMinute();

        String hour_string = String.valueOf(hour);
        String minute_string = String.valueOf(minute);

        if (hour > 12){
            hour_string = String.valueOf(hour - 12);
        }

        if (minute < 10 ){
            minute_string = "0" + String.valueOf(minute);
        }

        update_text.setText("Alarm On");

        pending_intent = PendingIntent.getBroadcast(MainActivity.this, 0,
                my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);


    }

    public void alarmOff(View view){
        update_text.setText("Alarm Off");

        alarm_manager.cancel(pending_intent);
    }


}
