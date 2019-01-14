package com.beans.java8.concurrent.stop;

/**
 * 线程的中断
 *
 */
public class InterruptedDemo implements Runnable{

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new InterruptedDemo());
		thread.start();
		Thread.sleep(3000);
		thread.interrupt();
	}

}
