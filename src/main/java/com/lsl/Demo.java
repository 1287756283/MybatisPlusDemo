package com.lsl;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        //1.创建一个大小为10的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        threadPool.execute(()->{
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println(111);
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    System.out.println(222);
                }
            });
        });

//给线程池添加任务
    }
}

