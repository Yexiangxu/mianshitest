package com.example.administrator.mianshitest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Date: 2019/3/6 19:14
 * Author: Xuyexiang
 * Title:
 */
class KotlinTestActivity : AppCompatActivity() {
    internal var arrayList = arrayOf("1", "2", "3", "4", "5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        println(1)
    }

    private fun forUse(arrayList: Array<String>) {
        for (i in arrayList.indices) {
            println(arrayList[i])
        }
    }
}
