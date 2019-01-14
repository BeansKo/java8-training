package com.beans.java8.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程调试
 * @author Frank
 *
 */
public class ReentrantLockDemo {
	private int i=0;
	private ReentrantLock lock = new ReentrantLock();

	public void increate() {
		lock.lock();
		try {
			i++;
			System.out.println("i="+i);
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
		for(int i=0;i<4;i++){
			new Thread(() -> reentrantLockDemo.increate()).start();
		}
	}

}
