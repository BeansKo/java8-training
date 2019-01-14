package com.beans.java8.concurrent.stop;

/**
 * 线程的中断
 * @author Frank
 *
 */
public class InterruptedFlag implements Runnable{

	private static volatile boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new InterruptedFlag());
		thread.start();
		Thread.sleep(3000);
		flag = false;
	}

}
