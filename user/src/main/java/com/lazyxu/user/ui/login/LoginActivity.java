package com.lazyxu.user.ui.login;

import com.lazyxu.base.base.BaseActivity;
import com.lazyxu.base.base.head.HeadToolbar;
import com.lazyxu.base.base.head.HeaderBuilder;
import com.lazyxu.user.BR;
import com.lazyxu.user.R;

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
public class LoginActivity extends BaseActivity {
    @Override
    public HeadToolbar getHeadToolbar() {
        return new HeaderBuilder().layoutId(R.layout.activity_login).build();
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public Class onBindViewModel() {
        return null;
    }

    @Override
    protected void initDatas() {

    }
}
