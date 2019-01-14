package com.beans.java8.concurrent.priority;

/**
 * 线程优先级
 * @author Frank
 *
 */
public class Priority {

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			while(true){
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread1.start();
		
		
		Thread thread2 = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.start();
	}

}
