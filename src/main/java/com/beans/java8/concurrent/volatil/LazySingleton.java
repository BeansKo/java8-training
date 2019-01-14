package com.beans.java8.concurrent.volatil;

public class LazySingleton {
	//使用volatile避免指令重排
	private static volatile LazySingleton lazySingleton;
	
	private LazySingleton() {}
	
	public static LazySingleton getLazySingleton(){
		if(null == lazySingleton) {
			synchronized (LazySingleton.class) {
				if(null == lazySingleton){
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i=0;i<10;i++){
				System.out.println(getLazySingleton());
			}
		}).start();;
	}

}
