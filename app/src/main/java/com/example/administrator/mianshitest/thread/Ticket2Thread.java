package com.example.administrator.mianshitest.thread;

public class Ticket2Thread implements Runnable {
    private int ticket=20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：" + (this.ticket--));
            }
        }
    }
}
