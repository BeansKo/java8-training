package com.beans.java8.concurrent.synchronize;

public class Synch {

	private Object object = new Object();
	public static synchronized void staticSyncMothed(){
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void syncMothed(){
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void mothed() {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Synch synch1 = new Synch();
//		Synch synch2 = new Synch();
//		new Thread(() -> {synch1.syncMothed();}).start();
//		new Thread(() -> {synch2.syncMothed();}).start();
//		
//		new Thread(() -> {Synch.staticSyncMothed();}).start();
//		new Thread(() -> {Synch.staticSyncMothed();}).start();
		
		new Thread(() -> {synch1.mothed();}).start();
		new Thread(() -> {synch1.mothed();}).start();
	}

}
