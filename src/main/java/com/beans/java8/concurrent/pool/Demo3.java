package com.beans.java8.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 3, TimeUnit.SECONDS, queue);
		Future<String> submit = null;
		for (int i=0;i<100;i++) {
			submit = executor.submit(new Demo2());
		}
		
		for (int i =0 ;i<100;i++){
			System.out.println(submit.get());
		}
	}

}
