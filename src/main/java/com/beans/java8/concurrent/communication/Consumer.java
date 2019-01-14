package com.beans.java8.concurrent.communication;

public class Consumer implements Runnable{

	private Medium medium;
	
	public Consumer(Medium medium) {
		this.medium = medium;
	}
	@Override
	public void run() {
		while (true) {
			medium.tack();
		}
	}
}
