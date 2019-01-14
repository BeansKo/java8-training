package com.beans.java8.concurrent.unsafe;

import java.util.concurrent.CountDownLatch;

/**
 * 不安全的线程操作
 * @author Frank
 *
 */
public class UnSafeThread {

	private static int num =0;
	private static CountDownLatch countDownLatch = new CountDownLatch(10);
	
	private static void inCreate() {
		num ++;
	}
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				for (int j=0; j<100; j++) {
					inCreate();
				}
				//每个线程执行完成之后，调用countDownLatch
				countDownLatch.countDown();
			}).start();
		}
		while (true) {
			if (countDownLatch.getCount() ==0) {
				System.out.println(num);
				break;
			}
			
		}
	}

}
