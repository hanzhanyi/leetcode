package com.hanzhanyi.leetcode.并发;


/**
 * Created by hanzhanyi on 2021/3/23.
 */
public class PrintABCMutiWaitNotify {
    private Object lock = new Object();
    private int status = 0;

    private void print(int result, int printCount) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (status % 3 != result) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                status++;
                for (int k = 0; k < printCount; k++) {
                    System.out.print(Thread.currentThread().getName());
                }
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCMutiWaitNotify print = new PrintABCMutiWaitNotify();
        new Thread(() -> print.print(0, 5), "A").start();
        new Thread(() -> print.print(1, 10), "B").start();
        new Thread(() -> print.print(2, 15), "C").start();
    }

}
