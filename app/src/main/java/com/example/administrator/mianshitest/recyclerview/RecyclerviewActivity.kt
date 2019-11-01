package com.example.administrator.mianshitest.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import com.example.administrator.mianshitest.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

/**
 * User:Lazy_xu
 * Data:2019/10/30
 * Description:
 * FIXME 删除 插入 局部刷新
 */
class RecyclerviewActivity : AppCompatActivity() {
    private var rvMainAdapter: RvMainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        val lists = ArrayList<String>()
        for (i in 0..99) {
            lists.add("测试$i")
        }
        rvMainAdapter = RvMainAdapter(this, lists)
        //设置布局管理器
        rvMain.layoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, 1)
        divider.setDrawable(resources.getDrawable(R.drawable.line_marginleft_16dp))
        rvMain.addItemDecoration(divider)
        rvMain.adapter = rvMainAdapter
//        val itemAnimator = rvMain.itemAnimator
//        if (itemAnimator is SimpleItemAnimator) {
//            itemAnimator.supportsChangeAnimations = false
//        }
        tvChangeData.setOnClickListener {
//            lists.removeAt(5)
            lists[5] = "我修改了数据5 哈哈哈哈"
            rvMainAdapter!!.notifyItemChanged(5)
//            rvMainAdapter!!.notifyDataSetChanged()
        }
    }
}
