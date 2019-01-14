package com.beans.java8.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁的降级
 * @author Frank
 *
 */
public class LockDegrade {
	private static ReentrantReadWriteLock reentryReadWriteLock = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		Lock readLock = reentryReadWriteLock.readLock();
		Lock writeLock = reentryReadWriteLock.writeLock();	
		writeLock.lock();
		readLock.lock();
		writeLock.unlock();
		readLock.unlock();
		System.out.println("程序运行结束");
	}

}
