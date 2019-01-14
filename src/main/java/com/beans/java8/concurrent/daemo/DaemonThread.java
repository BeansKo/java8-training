package com.beans.java8.concurrent.daemo;

/**
 * 守护线程
 * @author Frank
 *
 */
public class DaemonThread implements Runnable{

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(3000L);
	}

}
