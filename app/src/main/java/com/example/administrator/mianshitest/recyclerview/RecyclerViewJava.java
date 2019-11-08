package com.example.administrator.mianshitest.recyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.mianshitest.R;
import com.example.administrator.mianshitest.databinding.ActivityRecyclerviewBinding;

import java.util.ArrayList;

/**
 * User:Lazy_xu
 * Data:2019/10/31
 * Description:
 * FIXME lateinit :延迟初始化
 */
public class RecyclerViewJava extends AppCompatActivity {
    ActivityRecyclerviewBinding mDatabinding;
    private RvMainAdapter rvMainAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("测试" + i);
        }

        mDatabinding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        mDatabinding.rvMain.addItemDecoration(new DividerItemDecoration(this, 1));
        rvMainAdapter = new RvMainAdapter(this, list);
        mDatabinding.rvMain.setAdapter(rvMainAdapter);
        mDatabinding.tvChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        LayoutInflater.from(this).inflate(R.layout.activity_recyclerview, null);

    }
}
