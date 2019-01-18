package com.beans.java8.concurrent.tool;

import java.util.concurrent.Semaphore;

/**
 * 线程的并发数量
 * @author Frank
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "开始执行");
	                Thread.sleep(5000L);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
				
			}).start();
		}
	}

}
