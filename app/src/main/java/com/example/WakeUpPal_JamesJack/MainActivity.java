package com.example.WakeUpPal_JamesJack;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    //create timepicker
    TimePicker alarmTimePicker;
    //create intent to launch new activity
    PendingIntent pendingIntent;
    //create alarm manager
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTimePicker = findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }

    @SuppressLint({"ShortAlarm", "UnspecifiedImmutableFlag"})
    public void OnToggleClicked(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            //message if alarm button is on
            Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
            //tracks date and time
            Calendar calendar = Calendar.getInstance();

            // calender is called to get current time in hour and minute
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());

            // INHERIT receiver class
            Intent intent = new Intent(this, AlarmReceiver.class);

            //pending intent to allow 3rd party access
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            //time to be measured
            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time - AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            // Alarm rings until toggled off
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
            // alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (time * 1000), pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
        }
    }
//go to next screen
    public void launchWakeScreen(View view) {
        //use of traffic/weather button launches next activity
        Intent intent = new Intent(this, WakeScreen.class);
        startActivity(intent);
    }
}