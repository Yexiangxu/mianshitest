package com.lazyxu.base.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public class BaseViewModel extends AndroidViewModel {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseViewModel(Application application) {
        super(application);
    }

    public void addSubscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
