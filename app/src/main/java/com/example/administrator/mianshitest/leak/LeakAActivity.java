package com.example.administrator.mianshitest.leak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.mianshitest.R;
import com.example.administrator.mianshitest.recyclerview.RecyclerviewActivity;

public class LeakAActivity extends AppCompatActivity {

    private ImageView ivAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ad_view);
       ivAd= (ImageView) findViewById(R.id.iv_ad);
        findViewById(R.id.tv_timer).setOnClickListener(v -> {
            //回传值
            Intent intent = new Intent(LeakAActivity.this, RecyclerviewActivity.class);
            startActivity(intent);

        });

    }


}
