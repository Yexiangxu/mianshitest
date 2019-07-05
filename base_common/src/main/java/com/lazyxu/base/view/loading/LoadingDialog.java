package com.lazyxu.base.view.loading;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.lazyxu.base.R;
//import com.timper.res.view.dialog.Dialog;
//import com.timper.res.view.dialog.DialogBuilder;



public class LoadingDialog extends Dialog {

  View view;


  public LoadingDialog(Activity activity) {
    super(DialogBuilder.newDialog(activity).setGravity(Gravity.CENTER).setCancelable(false).setFullScreen(true));
  }

  public LoadingDialog(DialogBuilder builder) {
    super(builder);
  }

  @Override public synchronized void show() {
    synchronized (this) {
      if (!isShowing()) {
        view = LayoutInflater.from(context).inflate(R.layout.dlg_loading, contentContainer, true);
        super.show();
      }
    }
  }

  public synchronized void showNoFoucus() {
    synchronized (this) {
      if (!isShowing()) {
        view = LayoutInflater.from(context).inflate(R.layout.dlg_loading, contentContainer, true);
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        super.show();
      }
    }
  }

  @Override public synchronized void dismiss() {
    synchronized (this) {
      if (isShowing()) {
        contentContainer.removeAllViews();
        super.dismiss();
      }
    }
  }
}
