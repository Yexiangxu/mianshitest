package com.example.administrator.mianshitest;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2019/3/6 20:10
 * Author: Xuyexiang
 * Title:
 */
public class HelloWorld {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //1. 向HashMap添加数据
        map.put("Android", 1);
        map.put("IOS", 2);
        //2. 获取 HashMap 的某个数据
        System.out.println("key = Android值为：" + map.get("Android"));
        /**
         * 获取 HashMap 的全部数据：遍历HashMap
         * 方法1：获得key-value的Set集合再遍历
         *      1. 通过for循环
         *      2. 通过迭代器：先获得key-value对（Entry）的Iterator，再循环遍历
         * 方法2：获得key的Set集合再遍历
         *      1. 通过for循环
         *      2. 通过迭代器：先获得key的Iterator，再循环遍历
         */
        System.out.println("方法1");
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }

        Iterator iter1 = entrySet.iterator();
        while (iter1.hasNext()) {
            Map.Entry entry = (Map.Entry) iter1.next();
            System.out.print((String) entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("方法2");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print(key);
            System.out.println(map.get(key));
        }

        Iterator iter2 = keySet.iterator();
        String key;
        while (iter2.hasNext()) {
            key = (String) iter2.next();
            System.out.print(key);
            System.out.println(map.get(key));
        }

        System.out.println("方法3");
        Collection valueSet = map.values();
        Iterator iter3 = valueSet.iterator();
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }
    }
}
