package com.example.administrator.mianshitest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestSync2 {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        final TestSync2 test = new TestSync2();
        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

    }
    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
            System.out.println(thread.getName() + "释放锁");
        }
    }
}