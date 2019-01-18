package com.beans.java8.concurrent.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo2 implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		Thread.sleep(3000L);
		return "111";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo2 demo2 = new Demo2();
		FutureTask<String> futureTask = new FutureTask<>(demo2);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());

	}



}
