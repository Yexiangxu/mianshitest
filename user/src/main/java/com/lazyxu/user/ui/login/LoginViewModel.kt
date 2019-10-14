package com.lazyxu.user.ui.login

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.text.TextUtils
import android.util.Log
import com.lazyxu.base.base.BaseViewModel
import com.lazyxu.base.utils.AppToast
import com.lazyxu.user.data.UserUseCase
import javax.inject.Inject

/**
 * User: Lazy_xu
 * Data: 2019/08/05
 * Description:
 * FIXME
 */

class LoginViewModel
@Inject
constructor(application: Application, private val userUseCase: UserUseCase) : BaseViewModel(application) {
    var userPhone = ObservableField<String>()
    var userPassword = ObservableField<String>()


    fun login(): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        if (!judgeLogin()) {
            data.value = false
            return data
        } else {
            addSubscribe(userUseCase.login(userPhone.get()!!, userPassword.get()!!).subscribe({ loginBean ->

//                userUseCase.queryUser().subscribe({ user ->
//                    if (user == null ) {
//                        Log.i("LoginViewModel", "user=${user.toString()}")
//                    } else {
//                        Log.i("LoginViewModel", "user=$user")
//                    }
//                })
//                userUseCase.insertUser(loginBean.data)
                data.value = true
            }, { throwable ->
                Log.i("LoginViewModel", "throwable=$throwable")
                data.value = false
            }))
        }
        return data
    }

    private fun judgeLogin(): Boolean {
        if (TextUtils.isEmpty(userPhone.get())) {
            AppToast.show("请输入用户名")
            return false
        }
        if (TextUtils.isEmpty(userPassword.get())) {
            AppToast.show("请输入密码")
            return false
        }
        return true
    }
}