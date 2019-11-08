package com.example.administrator.mianshitest.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mianshitest.R;

public class CActivity extends AppCompatActivity {
    private Button showButton;
    private int flag;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        flag = getIntent().getIntExtra("SocketActivity", 0);
        Log.i("processtest", "CActivity的flag="+flag);
        showButton = findViewById(R.id.tv_c);
        showButton.setText("LeakBActivity");
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
