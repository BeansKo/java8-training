package com.beans.java8.concurrent.create;

/**
 * 线程的创建
 * 	使用继承Thread的方式
 * 	实现Runnable的方式
 * @author Frank
 *
 */
public class ThreadCreat extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		Thread thread1 = new ThreadCreat();
		thread1.setName("Thread create");
		thread1.start();
		
		Thread thread2 = new Thread(new ThreadRunnable());
		thread2.setName("Thread create by runnable");
		thread2.start();
	}

}

class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}
