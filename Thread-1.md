#### 第一章 并发简介
   ##### 什么是并发编程
	并发历史:
		早期计算机--从头到尾执行一个程序，资源浪费
		操作系统出现--计算机能运行多个程序，不同的程序在不同的单独的进程中运行
		一个进程，有多个线程,提高资源的利用率，公平

	串行与并行的区别:
		串行：洗茶具、打水、烧水、等水开、冲茶
		并行：打水、烧水同时洗茶具、水开、冲茶
		好处：可以缩短整个流程的时间

	并发编程目的：
		摩尔定律：当价格不变时，集成电路上可容纳的元器件的数目，约每隔18-24个月便会增加一倍，性能也将提升一倍。这一定律揭示了信息技术进步的速度。
		让程序充分利用计算机资源
		加快程序响应速度（耗时任务、web服务器）
		简化异步事件的处理

	什么时候适合使用并发编程:
		任务会阻塞线程，导致之后的代码不能执行：比如一边从文件中读取，一边进行大量计算的情况
		任务执行时间过长，可以划分为分工明确的子任务：比如分段下载
		任务间断性执行：日志打印
		任务本身需要协作执行：比如生产者消费者问题

   ##### 并发编程的挑战之频繁的上下文切换
	cpu为线程分配时间片，时间片非常短（毫秒级别），cpu不停的切换线程执行，在切换前会保存上一个任务的状态，以便下次切换回这个任务时，可以再加载这个任务的状态，让我们感觉是多个程序同时运行的
	上下文的频繁切换，会带来一定的性能开销如何减少上下文切换的开销？
		无锁并发编程
			无锁并发编程。多线程竞争锁时，会引起上下文切换，所以多线程处理数据时，可以用一些办法来避免使用锁，如将数据的ID按照Hash算法取模分段，不同的线程处理不同段的数据
		CAS
			Java的Atomic包使用CAS算法来更新数据，而不需要加锁。

		使用最少线程。
			避免创建不需要的线程，比如任务很少，但是创建了很多线程来处理，这样会造成大量线程都处于等待状态。
		协程
			在单线程里实现多任务的调度，并在单线程里维持多个任务间的切换。


   ##### 并发编程的挑战之死锁

	package com.beans.ko;

	/**
	 * 死锁Demo
	 */
	public class DeadLockDemo {
	    private static final Object HAIR_A = new Object();
	    private static final Object HAIR_B = new Object();

	    public static void main(String[] args) {
		new Thread(()->{
		    synchronized (HAIR_A) {
			try {
			    Thread.sleep(50L);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			synchronized (HAIR_B) {
			    System.out.println("A成功的抓住B的头发");
			}
		    }
		}).start();

		new Thread(()->{
		    synchronized (HAIR_B) {
			synchronized (HAIR_A) {
			    System.out.println("B成功抓到A的头发");
			}
		    }
		}).start();
	    }
	}



   ##### 并发编程的挑战之线程安全
	package com.beans.ko;

	import java.util.concurrent.CountDownLatch;

	/**
	 * 线程不安全操作代码实例
	 */
	public class UnSafeThread {

	    private static int num = 0;

	    private static CountDownLatch countDownLatch = new CountDownLatch(10);

	    /**
	     * 每次调用对num进行++操作
	     */
	    public static void inCreate() {
		num++;
	    }

	    public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
		    new Thread(()->{
			for (int j = 0; j < 100; j++) {
			    inCreate();
			    try {
				Thread.sleep(10);
			    } catch (InterruptedException e) {
				e.printStackTrace();
			    }
			}
			//每个线程执行完成之后，调用countdownLatch
			countDownLatch.countDown();
		    }).start();
		}

		while (true) {
		    if (countDownLatch.getCount() == 0) {
			System.out.println(num);
			break;
		    }
		}
	    }
	}


   ##### 并发编程的挑战之资源限制
	硬件资源
		服务器： 1m
		本机：2m
		带宽的上传/下载速度、硬盘读写速度和CPU的处理速度。
	软件资源
		数据库连接 500个连接  1000个线程查询  并不会因此而加快
		Socket
