package com.beans.java8.concurrent.communication;

/**
 * Thread.join
 * @author Frank
 *
 */
public class ThreadJoin {
	public static void main(String[] args) {
		Thread thread = new Thread(() ->{
			System.out.println(Thread.currentThread().getName()+"线程开始");
			try {
				Thread.sleep(3000L);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"线程结束");
		},"Thread1");
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"线程开始");
			try {
				thread.start();
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"线程结束");
		},"Thread2").start();
	}

}
