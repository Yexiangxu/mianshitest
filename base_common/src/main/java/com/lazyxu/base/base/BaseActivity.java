package com.lazyxu.base.base;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gyf.immersionbar.ImmersionBar;
import com.lazyxu.base.base.head.HeadToolbar;
import com.lazyxu.base.utils.ActivityStack;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public abstract class BaseActivity<V extends AndroidViewModel, B extends ViewDataBinding> extends AppCompatActivity implements IBaseView {
    public V mViewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    public B mDataBinding;
    private int mLayoutId;
    private int mTitleBar;
    private Toolbar mToolbar;
    private int mToolbarTitle;
    private int mBackDrawable;
    private int mToolbarTitleColor;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.Companion.getInstance().removeActivity(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //使用dagger.android需要（且必须放在super.onCreate前）
        AndroidInjection.inject(this);
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
        ActivityStack.Companion.getInstance().addActivity(this);


        initHeader();
        initDatabinding();
        initToolbar();
        initDatas();
    }

    private void initToolbar() {
        if (mTitleBar != -1) {
            setStatusbar();
            if (findViewById(mTitleBar) instanceof Toolbar) {
                mToolbar = findViewById(mTitleBar);
                setSupportActionBar(mToolbar);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    //设置返回图标
                    if (mBackDrawable != -1) {
                        getSupportActionBar().setHomeAsUpIndicator(mBackDrawable);
                    }
                    mToolbar.setNavigationOnClickListener(v -> finish());
//                  getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏居左标题,暂留用来处理标题居中和居左两种情况
                    if (mToolbarTitle != -1) {
                        getSupportActionBar().setTitle(mToolbarTitle);
                    }
                    if (mToolbarTitleColor != -1) {
                        mToolbar.setTitleTextColor(ContextCompat.getColor(this, mToolbarTitleColor));
                    }
                }
            }
        }
    }


    private void initHeader() {
        HeadToolbar headToolbar = getHeadToolbar();
        mLayoutId = headToolbar.getLayoutId();
        mTitleBar = headToolbar.getTitleBar();
        mToolbarTitle = headToolbar.getToolbarTitle();
        mBackDrawable = headToolbar.getBackDrawable();
        mToolbarTitleColor = headToolbar.getToolbarTitleColor();
    }

    private void initDatabinding() {
        mDataBinding = DataBindingUtil.setContentView(this, mLayoutId);
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        //第一个参数:变量名的引用，第二个参数：要设置的值
        mDataBinding.setVariable(getBindingVariable(), mViewModel);
        //当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings
        mDataBinding.executePendingBindings();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public abstract HeadToolbar getHeadToolbar();

    public abstract int getBindingVariable();

    public abstract Class<V> onBindViewModel();

    protected abstract void initDatas();

    public V getViewModel() {
        return ViewModelProviders.of(this, mViewModelFactory).get(onBindViewModel());
    }

    /**
     * 设置电池栏等适配
     */
    protected void setStatusbar() {
        ImmersionBar.with(this).titleBar(mTitleBar).init();
    }

    /**
     * 点击非edittext处软键盘消失
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v instanceof EditText) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }


}
