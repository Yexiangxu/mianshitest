package com.lazyxu.base.base;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lazyxu.base.base.head.HeadToolbar;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public class BaseActivity<V extends BaseViewModel, T extends ViewDataBinding> extends AppCompatActivity {
    public V viewModel;
    private T mDataBinding;

    public HeadToolbar getHeadToolbar() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        //防止首次安装按home键重新启动
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            assert action != null;
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
        HeadToolbar headToolbar = getHeadToolbar();
        setStatusbar();
    }

    private void setStatusbar() {

    }

}
