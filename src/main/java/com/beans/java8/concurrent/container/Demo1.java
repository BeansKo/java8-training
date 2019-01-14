package com.beans.java8.concurrent.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Demo1 {
	public static void main(String[] args) {
		List<String> stringVector = new Vector<String>();
		for (int i = 0; i < 1000; i++) {
			stringVector.add("demo" + i);
		}

		// 错误遍历
		// stringVector.forEach((s) -> {
		// if (s.equals("demo3")) {
		// stringVector.remove(s);
		// }
		// System.out.println(s);
		// });

		// 单线程正确遍历，删除元素方式
//		Iterator<String> iterator = stringVector.iterator();
		// while (iterator.hasNext()) {
		// String value = iterator.next();
		// if (value.equals("demo2")){
		// iterator.remove();
		// } else {
		// System.out.println(value);
		// }
		// }

		// 没有加锁，有时候会报错
		// for (int i=0 ;i < 4;i++){
		// new Thread(() -> {
		// while (iterator.hasNext()) {
		// String value = iterator.next();
		// if
		// (value.equals("demo1")||value.equals("demo3")||value.equals("demo4")||value.equals("demo5")){
		// try {
		// Thread.sleep(2000L);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// iterator.remove();
		// } else {
		// System.out.println(value);
		// }
		// }
		// }).start();
		// }

//		for (int i = 0; i < 4; i++) {
//			new Thread(() -> {
//				synchronized (iterator) {
//					while (iterator.hasNext()) {
//						String value = iterator.next();
//						if (value.equals("demo1") || value.equals("demo3") || value.equals("demo4")
//								|| value.equals("demo5")) {
//							try {
//								Thread.sleep(2000L);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//							iterator.remove();
//						} else {
//							System.out.println(value);
//						}
//					}
//				}
//			}).start();
//		}
		// 使用同步容器
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			list.add("demo" + i);
		}
		
		List<String> nList = Collections.synchronizedList(list);
		Iterator<String> it = nList.iterator();
		for (int i = 0; i < 4; i++) {
			new Thread(() -> {
				while (it.hasNext()) {
					String value = it.next();
					if (value.equals("demo1") || value.equals("demo3") || value.equals("demo4")
							|| value.equals("demo5")) {
						try {
							Thread.sleep(2000L);
						} catch (Exception e) {
							e.printStackTrace();
						}
						it.remove();
					} else {
						System.out.println(value);
					}
				}
			}).start();
		}
	}
}
