package com.example.administrator.mianshitest.leak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mianshitest.R;

public class LeakAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ad_view);
        findViewById(R.id.tv_timer).setOnClickListener(v -> {
            //回传值
            Intent intent = new Intent(LeakAActivity.this, LeakBActivity.class);
            startActivity(intent);
        });
    }


}
