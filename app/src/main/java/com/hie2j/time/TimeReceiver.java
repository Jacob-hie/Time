package com.hie2j.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TimeReceiver extends BroadcastReceiver {

    private IOnUpdateTime iOnUpdateTime;

    public TimeReceiver(IOnUpdateTime iOnUpdateTime) {
        this.iOnUpdateTime = iOnUpdateTime;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        iOnUpdateTime.updateTime();
    }
}
