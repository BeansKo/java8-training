package com.beans.java8.concurrent.container;

import java.util.concurrent.CopyOnWriteArrayList;

public class Demo2 {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add("demo"+i);
		}
		
		
		for (int j=0; j<4; j++){
			new Thread(() -> {
				list.forEach((s) -> {
					if(s.equals("demo2")){
						list.remove(s);
					} else {
						System.out.println(s);
					}
				});
			}).start();
		}
	}
}
