package com.example.administrator.mianshitest;

/**
 * Date: 2019/2/18 18:25
 * Author: Xuyexiang
 * Title:
 */
public class JniTest {
    public native int getRandomNum();
    public native String getNativeString();

    static {
        System.loadLibrary("HelloJni");
    }
}
