package com.hanzhanyi.leetcode.并发;


/**
 * Created by hanzhanyi on 2021/3/23.
 */
public class PrintABCMutiUsingVolitile {
    private volatile int number = 0;

    private void ABCMuti(int status) {
        for (int i = 0; i < 10; ) {
            if (number % 3 == status) {
                System.out.print(Thread.currentThread().getName());
                i++;
                number++;
            }
        }
    }
    public static void main(String[] args) {
        PrintABCMutiUsingVolitile printABCMutiUsingLock = new PrintABCMutiUsingVolitile();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(0), "A").start();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(1), "B").start();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(2), "C").start();
    }

}

