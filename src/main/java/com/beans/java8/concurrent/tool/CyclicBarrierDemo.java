package com.beans.java8.concurrent.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * 线程进入等待，然后同时进入执行
 * @author Frank
 *
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
		for (int i=0; i<8; i++){
			int finalI = i;
			new Thread(() -> {
				try {
                    Thread.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("开始比赛");
			}).start();
		}
	}

}
