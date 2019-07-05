package com.example.administrator.mianshitest.leak;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.administrator.mianshitest.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LeakBActivity extends AppCompatActivity {
    private Button showButton;
//    private static Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        showButton = findViewById(R.id.tv_c);
        showButton.setOnClickListener(v -> {
            //回传值
            Intent intent = new Intent(LeakBActivity.this, LeakCActivity.class);
            startActivity(intent);
        });
//        LeakTest.getInstance().setmTextView(showButton);
//        context = this;
//        initData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 15000);
    }



//    private void initData() {
//        // 每隔1s执行一次事件
//        Observable.interval(1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Long aLong) {
//                        Log.i("接收数据", String.valueOf(aLong));
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}