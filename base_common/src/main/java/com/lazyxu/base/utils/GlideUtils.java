package com.lazyxu.base.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.lazyxu.base.R;

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
public class GlideUtils {
    /**
     * 电影列表图片
     */
    @BindingAdapter("android:showMovieImg")
    public static void showMovieImg(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .override((int) CommonUtils.INSTANCE.getDimens(R.dimen.movie_detail_width), (int) CommonUtils.INSTANCE.getDimens(R.dimen.movie_detail_height))
                .placeholder(R.drawable.img_default_meizi)
                .error(R.drawable.img_default_meizi)
                .into(imageView);
    }
}
