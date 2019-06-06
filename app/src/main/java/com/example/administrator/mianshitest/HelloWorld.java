package com.example.administrator.mianshitest;


import com.example.administrator.mianshitest.cache.LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2019/3/6 20:10
 * Author: Xuyexiang
 * Title:
 */
public class HelloWorld {
    public static void main(String[] args) {

//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        map.put("语文", 1);
//        map.put("数学", 2);
//        map.put("英语", 3);
//        map.put("历史", 4);
//        map.put("政治", 5);
//        map.put("地理", 6);
//        map.put("生物", 7);
//        map.put("化学", 8);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("语文", 4);
        hashMap.put("数学", 2);
        hashMap.put("英语", 3);
        hashMap.put(null, 6);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void testthread() {
        //创建基本线程池
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100));
        for (int i = 0; i < 30; i++) {
            final int finali = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
//                        System.out.println("run: "+finali);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }

        ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 50; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
//                    System.out.println("线程：" + threadName + ",正在执行第" + index + "个任务");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        LRU<String, Integer> lru = new LRU<>(3);
        for (int i = 0; i < 50; i++) {
            lru.put("aa" + i, i);
//            lru.print();
        }

    }

    public void fun1() {
        Object object = new Object();
        Object[] objArr = new Object[1000000];
    }
}
