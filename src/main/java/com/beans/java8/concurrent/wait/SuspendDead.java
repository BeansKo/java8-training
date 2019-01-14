package com.beans.java8.concurrent.wait;

/**
 * 挂起死锁
 * @author Frank
 *
 */
public class SuspendDead implements Runnable{

	private static Object object = new Object();
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName()+"占用资源");
			Thread.currentThread().suspend();
			System.out.println(Thread.currentThread().getName()+"释放资源");
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new SuspendDead(),"对比线程");
		thread1.start();
		Thread.sleep(3000);
		thread1.resume();
		
		Thread thread2 = new Thread(new SuspendDead(),"死锁线程");
		thread2.start();
		thread2.resume();
	}



}
