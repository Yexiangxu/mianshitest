package com.example.administrator.mianshitest.leak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.mianshitest.R;
import com.example.administrator.mianshitest.Student;
import com.example.administrator.mianshitest.recyclerview.RecyclerviewActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate);
        findViewById(R.id.tv_timer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student(2019,"lazyxu",28);
                Intent intent=new Intent(MainActivity.this, RecyclerviewActivity.class);
                intent.putExtra("key",true);
                startActivity(intent);
            }
        });
    }
}
