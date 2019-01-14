package com.beans.java8.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock{
	
	private boolean isHoldLock = false;
	private Thread  holdLockThread;
	private int reentryCount;

	@Override
	public synchronized void lock() {
		if(isHoldLock && Thread.currentThread() != holdLockThread){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		holdLockThread = Thread.currentThread();
		isHoldLock = true;
		reentryCount++;
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public synchronized void unlock() {
		//判断当前线程是否是持有锁的线程，是，重入次数减去1，不是就不做处理
		if(Thread.currentThread() == holdLockThread){
			notify();
			reentryCount --;
			if(reentryCount ==0){
				notify();
				isHoldLock = false;
			}
		}
	}

	@Override
	public Condition newCondition() {
		return null;
	}

}
