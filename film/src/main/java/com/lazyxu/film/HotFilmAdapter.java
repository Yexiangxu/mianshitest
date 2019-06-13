package com.lazyxu.film;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lazyxu.film.data.entity.FilmItemEntity;

import java.util.List;

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
public class HotFilmAdapter extends BaseQuickAdapter<FilmItemEntity, HotFilmAdapter.HotFilmHolder> {
    public HotFilmAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(HotFilmHolder helper, FilmItemEntity item) {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(BR.filmItemEntity,item );
//        binding.setVariable(BR.filmItemEntity, item);
        binding.executePendingBindings();
    }
    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public static class HotFilmHolder extends BaseViewHolder {
        public HotFilmHolder(View view) {
            super(view);
        }
        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}
