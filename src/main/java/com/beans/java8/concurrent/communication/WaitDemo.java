package com.beans.java8.concurrent.communication;

/**
 * Thread.sleep不会释放资源
 * @author Frank
 *
 */
public class WaitDemo {

	private static  volatile boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		new Thread(() ->{
			while(!flag){
				try {
					Thread.sleep(100L);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("flag is false");
			}
			System.out.println("flag is true");
		}).start();
		Thread.sleep(2000L);
		
		new Thread(() ->{flag = true;}).start();
	}

}
