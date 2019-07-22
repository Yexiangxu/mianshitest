package com.lazyxu.base.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.lazyxu.base.base.head.HeadToolbar;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public abstract class BaseActivity<V extends BaseViewModel, T extends ViewDataBinding> extends AppCompatActivity implements IBaseView {
    public V mViewModel;
//    @Inject
//    public ViewModelFactor<V> factor;
    private T mDataBinding;
    private int mLayoutId;
    private int mToolbarTitle;


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
        initHeader();
        initDatabinding();
        setStatusbar();
        initDatas();
    }

    private void initHeader() {
        HeadToolbar headToolbar = getHeadToolbar();
        mLayoutId = headToolbar.getLayoutId();
        mToolbarTitle = headToolbar.getToolbarTitle();

    }
    private void initDatabinding(){
        mDataBinding = DataBindingUtil.setContentView(this, mLayoutId);
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mDataBinding.setVariable(getBindingVariable(), mViewModel);
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
    public V getViewModel(){
        return ViewModelProviders.of(this).get(onBindViewModel());
    }
    private void setStatusbar() {

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
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};        //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        return false;
    }
}
