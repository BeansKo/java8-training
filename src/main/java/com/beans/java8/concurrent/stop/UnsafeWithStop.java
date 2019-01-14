package com.beans.java8.concurrent.stop;

/**
 * 中断线程
 * @author Frank
 *
 */
public class UnsafeWithStop implements Runnable{

	private static int i;
	private static int j;
	@Override
	public void run() {
		i++;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		j++;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new UnsafeWithStop());
		thread.start();
		Thread.sleep(1000);
		//线程被暴力中断，j不能返回正常值，发生线程安全性问题，所以开发中不要使用stop
		thread.stop();
		System.out.println("i="+i);
		System.out.println("j="+j);

	}

}
