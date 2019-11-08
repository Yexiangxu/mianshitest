package com.example.administrator.mianshitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.mianshitest.sqlite.SqliteActivity;

/**
 * User: Lazy_xu
 * Data: 2019/07/02
 * Description:
 * FIXME
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        findViewById(R.id.btnSqlite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SqliteActivity.class));
            }
        });

    }
}
