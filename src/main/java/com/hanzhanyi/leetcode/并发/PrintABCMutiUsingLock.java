package com.hanzhanyi.leetcode.并发;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hanzhanyi on 2021/3/23.
 */
public class PrintABCMutiUsingLock {

    private Lock lock = new ReentrantLock();

    int number = 0;

    private void ABCMuti(int status) {
        for (int i = 0; i < 10; ) {
            if (number % 3 == status) {
                lock.lock();
                System.out.print(Thread.currentThread().getName());
                i++;
                number++;
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCMutiUsingLock printABCMutiUsingLock = new PrintABCMutiUsingLock();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(0), "A").start();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(1), "B").start();
        new Thread(() -> printABCMutiUsingLock.ABCMuti(2), "C").start();
    }

}

