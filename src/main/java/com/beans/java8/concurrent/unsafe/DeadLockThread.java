package com.beans.java8.concurrent.unsafe;

/**
 * 死锁
 * 两个人打架，你抓住我的头发不放，我抓住你的头发不放。
 * @author Frank
 *
 */
public class DeadLockThread {

	private static final Object hair_A = new Object();
	private static final Object hair_B = new Object();
	
	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (hair_A) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (hair_B) {
					System.out.println("A护住自己的头发，成功抓住了B的头发！");
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (hair_B) {
				synchronized (hair_A) {
					System.out.println("B护住自己的头发，成功抓住了A的头发！");
				}
			}
		}).start();
		System.out.println("end");
	}

}
