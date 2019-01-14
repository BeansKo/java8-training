package com.beans.java8.concurrent.wait;

/**
 * 线程状态，使用Suspend挂起线程
 * @author Frank
 *
 */
public class SuspendThread implements Runnable{
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始执行Run,调用Suspend方法挂起线程。");
		//挂起线程
		Thread.currentThread().suspend();
		System.out.println(Thread.currentThread().getName()+"开始执行Run,调用Suspend方法结束。");
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new SuspendThread());
		thread.start();
		Thread.sleep(3000);
		//唤醒线程
		thread.resume();
	}



}
