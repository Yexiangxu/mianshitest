package com.lazyxu.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lazyxu.base.R;
import com.lazyxu.base.utils.RouterUrl;


/**
 * User:Lazy_xu
 * Data:2019/10/18
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.WEBVIEWMAIN)
public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
    }
}
