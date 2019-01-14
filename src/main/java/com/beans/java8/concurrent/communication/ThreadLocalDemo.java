package com.beans.java8.concurrent.communication;

/**
 * ThreadLocal
 * @author Frank
 *
 */
public class ThreadLocalDemo {

	ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> {return 0;});
	
    /**
     * 自增并输出num的值
     */
	private void inCreate() {
		Integer n = num.get();
		n++;
		System.out.println(Thread.currentThread().getName() + "-------->"+n);
		num.set(n);
	}
	public static void main(String[] args) {
		ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
		for (int i = 1; i < 3; i++) {
			int finalI = i;
			new Thread(() -> {
				while(true) {
					threadLocalDemo.inCreate();
					try {
						Thread.sleep(finalI * 1000L);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
