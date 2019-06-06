package com.example.administrator.mianshitest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class TESTService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private class MyBinder extends Binder{

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
