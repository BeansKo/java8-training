package com.beans.java8.concurrent.wait;

/**
 * 线程状态：使用wait挂起线程
 * @author Frank
 *
 */
public class WaitThread implements Runnable{

	private static Object waitObj = new Object();
	@Override
	public void run() {
		synchronized (waitObj) {
			System.out.println(Thread.currentThread().getName()+"开始占用资源");
			try {
				//进入挂起状态，会释放持有的锁
				waitObj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"已经释放资源");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		//对比线程进入挂起，会释放锁，我们发现死锁线程也会方位锁资源，所以wait不会持有资源
		Thread thread1 = new Thread(new WaitThread(),"对比线程");
		thread1.start();
		
		Thread thread2 = new Thread(new WaitThread(),"死锁线程");
		thread2.start();
		Thread.sleep(3000);
		synchronized (waitObj) {
			waitObj.notify();
		}
	}



}
