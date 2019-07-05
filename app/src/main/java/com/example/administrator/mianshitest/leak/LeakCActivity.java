package com.example.administrator.mianshitest.leak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mianshitest.R;

/**
 * User: xuyexiang
 * Date: 2019/06/24
 * Description:
 * FIXME
 */
public class LeakCActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
