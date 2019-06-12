package com.lazyxu.mvvmproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 * FIXME
 */
public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView textView=findViewById(R.id.tvSkip);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
