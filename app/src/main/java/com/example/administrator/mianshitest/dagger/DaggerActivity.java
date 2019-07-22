package com.example.administrator.mianshitest.dagger;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mianshitest.R;
import com.google.gson.Gson;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {
    @Inject
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        DaggerMainComponent.create().inject(this);
        Log.d("DaggerTest", "gson 地址" + gson);
    }
}