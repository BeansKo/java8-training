package com.beans.java8.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentryReadWriteLock {
	private int i;
	private int j;
	
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = reentrantReadWriteLock.readLock();
	private Lock writeLock = reentrantReadWriteLock.writeLock();
	public void out(){
		readLock.lock();
		try{
		System.out.println(Thread.currentThread().getName()+":i的值="+ i +",j的值="+j);
		}finally{
			readLock.unlock();
		}

	}
	
	public void inCreate(){
		writeLock.lock();	
		try {
			i++;
			Thread.sleep(500);
			j++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
		
	}

	public static void main(String[] args) {
		ReentryReadWriteLock readWriteLock = new ReentryReadWriteLock();
		//读写互斥，写写互斥
//		for(int i=0;i<4;i++){
//			new Thread(() -> {
//				readWriteLock.inCreate();
//				readWriteLock.out();}).start();
//		}
		//读写互斥
//		new Thread(() -> {readWriteLock.out();},"读").start();
//		new Thread(() -> {readWriteLock.inCreate();},"写").start();
		//读读共享
		new Thread(() -> {readWriteLock.out();},"读").start();
		new Thread(() -> {readWriteLock.out();},"读").start();
	}

}
