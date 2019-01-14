package com.beans.java8.concurrent.communication;

/**
 * notify只会随机唤醒一个wait的线程，notifyAll会唤醒所有wait的线程
 * @author Frank
 *
 */
public class WaitDemo1 {

	private static  volatile boolean flag = false;
	Object object = new Object();
	public static void main(String[] args) throws InterruptedException {
		Object object = new Object();
		new Thread(() ->{
			while(!flag){
				synchronized (object) {
					try {
						System.out.println("flag is false");
						object.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			System.out.println("flag is true");
		}).start();
		
		new Thread(() ->{
			while(!flag){
				synchronized (object) {
					try {
						System.out.println("flag is false");
						object.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			System.out.println("flag is true");
		}).start();
		
		Thread.sleep(2000L);
		
		new Thread(() ->{
			flag = true;
			synchronized (object) {
				object.notifyAll();
			}
			}).start();
	}

}
