package com.example.administrator.mianshitest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
//        String path = "com.example.administrator.mianshitest.Student";
//        try {
//            Class clazz = Class.forName(path);//com.example.administrator.mianshitest.Student
//            // 获取类名
//            String strName01 = clazz.getName();// com.example.administrator.mianshitest.Student
//            String strName02 = clazz.getSimpleName();// Student
//            // 获取属性
//            Field[] field01 = clazz.getFields(); // 返回属性为public的字段
//            Field[] field02 = clazz.getDeclaredFields(); // 返回所有的属性
//            Field field03 = clazz.getDeclaredField("id"); //class com.example.administrator.mianshitest.Student.id
//            // 获取普通方法
//            Method[] Method01 = clazz.getDeclaredMethods(); // 返回public方法
//            Method method = clazz.getDeclaredMethod("getId", null); // 返回getId这个方法，如果没有参数，就默认为null  class com.example.administrator.mianshitest.Student.id.getId()
//
//            // 获取构造方法
//            Student u1 = (Student) clazz.newInstance(); //获取无参的构造函数这里的前提的保证类中应该有无参的构造函数
//            // 获取参数为(int,String,int)的构造函数
//            Constructor c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);
//            // 通过有参构造函数创建对象
//            Student u2 = (Student) c2.newInstance(1001, "lazyxu", 18);
//            // 通过反射调用普通方法
//            Student u3 = (Student) clazz.newInstance();
//            Method method03 = clazz.getDeclaredMethod("setId", int.class);
//            method03.invoke(u3, 1002); // 把对象u3的id设置为1002
//            // 通过反射操作普通的属性
//            Student u4 = (Student) clazz.newInstance();
//            Field f = clazz.getDeclaredField("name");
//            f.setAccessible(true); // 设置属性可以直接的进行访问
//            f.set(u4, "lazy_xu");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
