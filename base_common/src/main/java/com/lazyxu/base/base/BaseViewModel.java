package com.lazyxu.base.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public class BaseViewModel extends AndroidViewModel {
    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel(Application application) {
        super(application);
        mCompositeDisposable = new CompositeDisposable();
    }

    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.clear();
        }
        super.onCleared();
    }
}
