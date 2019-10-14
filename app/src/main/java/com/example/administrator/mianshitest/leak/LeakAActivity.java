package com.example.administrator.mianshitest.leak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mianshitest.R;

public class LeakAActivity extends AppCompatActivity {

    private ImageView ivAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_ad_view);
       ivAd= (ImageView) findViewById(R.id.iv_ad);
        Glide.with(LeakAActivity.this).load(R.mipmap.ic_launcher).into(ivAd);
        findViewById(R.id.tv_timer).setOnClickListener(v -> {
            //回传值
//            Intent intent = new Intent(LeakAActivity.this, LeakBActivity.class);
//            startActivity(intent);
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    Glide.with(LeakAActivity.this).load(R.mipmap.ic_launcher).into(ivAd);
                }
            }.start();
        });

    }


}
