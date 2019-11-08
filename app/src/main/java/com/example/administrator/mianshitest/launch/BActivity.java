package com.example.administrator.mianshitest.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mianshitest.R;

public class BActivity extends AppCompatActivity {
    private TextView showButton;

    private int flag;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate);
        flag = getIntent().getIntExtra("AActivity", 0);
        Log.i("processtest", "BActivity的flag=" + flag);
        showButton = findViewById(R.id.tv_c);
        showButton.setText("SocketActivity");
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回传值
                Intent intent = new Intent(BActivity.this, CActivity.class);
                intent.putExtra("SocketActivity", 888);
                startActivity(intent);
            }
        });
    }


}
