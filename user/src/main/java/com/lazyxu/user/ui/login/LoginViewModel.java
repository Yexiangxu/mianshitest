package com.lazyxu.user.ui.login;

import android.app.Application;
import android.databinding.ObservableField;

import com.lazyxu.base.base.BaseViewModel;

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
public class LoginViewModel extends BaseViewModel {
    private ObservableField<String> userName=new ObservableField<>();
    private ObservableField<String> userSercet=new ObservableField<>();
    public LoginViewModel(Application application) {
        super(application);
    }
}
