package com.lazyxu.base.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * User: Lazy_xu
 * Data: 2019/07/08
 * Description:
 * FIXME
 */
//@Singleton
public class ViewModelFactor<V extends BaseViewModel> implements ViewModelProvider.Factory {

    private V mViewModel;

//    @Inject
    public ViewModelFactor(V mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(mViewModel.getClass())) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
