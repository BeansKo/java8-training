package com.beans.java8.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁控制共享资源达到线程安全Lock
 * @author Frank
 *
 */
public class UnSafeThread {

	private static int num =0;
	private static CountDownLatch countDownLatch = new CountDownLatch(10);
//	private static Lock lock = new ReentrantLock();
	//这里使用自己实现的锁
	private static Lock lock = new MyLock();
	
	private static void inCreate() {
		lock.lock();
		num ++;
		lock.unlock();
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
