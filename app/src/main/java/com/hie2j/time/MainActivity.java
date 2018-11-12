package com.hie2j.time;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements IOnUpdateTime{
    private TextView time;
    private TimeReceiver timeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("时间");

        time = findViewById(R.id.time);
        timeReceiver = new TimeReceiver(MainActivity.this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        registerReceiver(timeReceiver,filter);
        updateTime();
    }
    public void updateTime() {
        Date date = new Date();
        StringBuffer buffer = new StringBuffer();
        if (date.getHours() < 10){
            buffer.append("0");
        }
        buffer.append(date.getHours());
        buffer.append(":");
        if (date.getMinutes() < 10){
            buffer.append("0");
        }
        buffer.append(date.getMinutes());
        time.setText(buffer);
    }
}
