package com.beans.java8.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 * @author Frank
 *
 */
public class Demo1 {

	private static AtomicInteger sum = new AtomicInteger(0);
	
	private static void inCreate() {
		sum.incrementAndGet();
	}
	public static void main(String[] args) {
		for (int i=0;i<10;i++){
			new Thread(() -> {
				for (int j=0;j<10;j++){
					inCreate();
					System.out.println(sum);
				}
			}).start();
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
