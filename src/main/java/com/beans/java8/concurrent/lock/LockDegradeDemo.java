package com.beans.java8.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDegradeDemo {

	private int i =0;
	private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	public void doSomthing(){
		Lock readLock = reentrantReadWriteLock.readLock();
		Lock writeLock = reentrantReadWriteLock.writeLock();
		writeLock.lock();
		try {
			i++;
			readLock.lock();
		} finally {
			writeLock.unlock();
		}

		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			if (i == 1) {
				System.out.println("i的值是===>1");
			} else {
				System.out.println("i的值是:" + i);
			}

		} finally {
			readLock.unlock();
		}
	}
	public static void main(String[] args) {
		LockDegradeDemo lockDegradeDemo = new LockDegradeDemo();
		
		for(int i=0;i<4;i++){
			new Thread(()->{lockDegradeDemo.doSomthing();}).start();
		}
	}

}
