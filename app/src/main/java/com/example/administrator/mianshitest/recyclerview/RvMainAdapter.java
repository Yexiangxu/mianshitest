package com.example.administrator.mianshitest.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mianshitest.R;
import com.example.administrator.mianshitest.databinding.ItemRecyclerviewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

/**
 * User:Lazy_xu
 * Data:2019/10/31
 * Description:
 * FIXME
 */
public class RvMainAdapter extends RecyclerView.Adapter<RvMainAdapter.ViewHolder> {
    private static final String TAG = "RecyclerView";
    private Context mContext;
    private List<String> mList;
    private HashMap<Integer, String> lists = new HashMap<>();

    public RvMainAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        position = 0;
    }

    private int position = 0;

    @NotNull
    @Override
    public RvMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //50条数据 刚开始执行了13次（屏幕到item13），滑动再执行了5次到 18次，每次执行notifyAll刷新再执行 8次

        Log.d(TAG, "onCreateViewHolder的viewType=" + position);
        position = position + 1;
        return new RvMainAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvMainAdapter.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        //需要判断下payloads是否为空，如果为空的话执行默认的OnBindViewHolder方法，如果不为空的话，执行我们自己的局部刷新方法

        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            //执行局部刷新
        }

    }

    @Override
    public void onBindViewHolder(final RvMainAdapter.ViewHolder holder, int position) {
        //当有item显示出来及执行该方法，刷新界面显示所有item
        //局部刷新只执行该方法 notifyItemChanged(position)
        Log.d(TAG, "onBindViewHolder的position=" + position);
        holder.bindItem(position, lists, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewBinding mDataBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            mDataBinding = DataBindingUtil.bind(itemView);
        }

        private void bindItem(final int position, HashMap<Integer, String> mLists, String applyDataListBean) {
            if (mLists != null && !TextUtils.isEmpty(mLists.get(position))) {
                mDataBinding.tvContent.setText(mLists.get(position));
            } else {
                mDataBinding.tvContent.setText(applyDataListBean);
            }
            mDataBinding.tvContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //当文字变化了滑动该item消失再次显示 文字还是之前的，只能通过数据或者标志改变文案显示
                    mDataBinding.tvContent.setText("点击了" + position);
                    mLists.put(position, "点击了" + position);
                }
            });
        }
    }

}


