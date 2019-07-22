package com.lazyxu.base.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.lazyxu.base.R;

/**
 * User: Lazy_xu
 * Data: 2019/07/08
 * Description:
 * FIXME
 */
public class UiUtils {
    public static boolean checkInput(TextView tv, CharSequence msg){
        return checkInput(tv,msg,true);
    }

    public static boolean checkInput(TextView tv,CharSequence msg,boolean isShake){
        if(TextUtils.isEmpty(tv.getText())){
//            if(StringUtils.isNotBlank(msg)){
//                showToast(msg);
//            }
            if(isShake){
                startShake(tv);
            }
            return false;
        }
        return true;
    }
    private static void startShake(View view){
        view.requestFocus();//把焦点放到该view上
        view.startAnimation( AnimationUtils.loadAnimation(view.getContext(), R.anim.shake));
    }
}
