package com.hanzhanyi.leetcode.并发;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by hanzhanyi on 2021/3/23.
 */
public class PrintABCMutiUsingLockSupport {
    Thread A;
    Thread B;
    Thread C;

    public static void main(String[] args) {
        PrintABCMutiUsingLockSupport dto = new PrintABCMutiUsingLockSupport();

        dto.A = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(dto.B);
                LockSupport.park();
            }
        }, "A");
        dto.B = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(dto.C);
            }
        }, "B");
        dto.C = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(dto.A);
            }
        }, "C");
        dto.A.start();
        dto.B.start();
        dto.C.start();

    }
}
