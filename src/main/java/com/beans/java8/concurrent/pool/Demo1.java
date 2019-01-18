package com.beans.java8.concurrent.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo1 {

	public static void main(String[] args) {
		LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>(20);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
		for (int i=0; i<100;i++){
			threadPoolExecutor.submit(() -> {
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
	}

}
