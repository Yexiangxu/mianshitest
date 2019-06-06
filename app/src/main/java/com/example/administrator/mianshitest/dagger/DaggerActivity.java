package com.example.administrator.mianshitest.dagger;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mianshitest.R;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {
    private TextView mTextView;

    @Inject
    ClassANew classANew;
    @Inject
    ClassANew classATestNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        mTextView = findViewById(R.id.tv_theory);
        DaggerMainComponent.builder().build().inject(this);
        Log.d("DaggerTest", "classAN 地址" + classANew);
        Log.d("DaggerTest", "classTN 地址" + classATestNew);
    }
}