package com.beans.java8.concurrent.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的其他方式
 * @author Frank
 *
 */
public class ThreadCreatOther {

	public static void main(String[] args) {
		//匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
		
		//lambda的方式
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		}).start();
		
		//线程池的方式
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName());
		});
	}

}
