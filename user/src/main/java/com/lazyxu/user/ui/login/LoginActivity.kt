package com.lazyxu.user.ui.login

import android.arch.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.utils.RouterUrl
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.base.head.HeaderBuilder
import com.lazyxu.base.utils.AppToast
import com.lazyxu.user.BR
import com.lazyxu.user.R
import com.lazyxu.user.databinding.ActivityLoginBinding

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.LOGIN)
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getHeadToolbar(): HeadToolbar {
        return HeaderBuilder().layoutId(R.layout.activity_login).build()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onBindViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun initDatas() {
        mDataBinding.view = this@LoginActivity
    }

    fun onClick(str: Int) {
        mViewModel.login().observe(this, Observer<Boolean> { this.loginSuc(it) })
    }

    private fun loginSuc(aBoolean: Boolean?) {
        if (aBoolean != null && aBoolean) {
            AppToast.show("登录成功")
            ARouter.getInstance().build(RouterUrl.HOTFILM).navigation()
        }
    }
}
