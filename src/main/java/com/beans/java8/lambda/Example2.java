package com.beans.java8.lambda;

import java.util.function.Function;

/**
 * Lambda表达式
 * 有返回值的情况
 */
public class Example2 {
	public static void main(String[] args) {
		//输入输出
		Function<Integer, Integer> function = (a) -> {
			int sum = 0;
			for(int i=0; i<a; i++){
				sum += i;
			}
			return sum;	
		};
		
		System.out.println(function.apply(10));
		
		//Runnable的默认方法没有返回值，所以调用的方法有返回值，程序可以正常运行
		Runnable r1 = () -> get();
		Runnable r2 = () -> exec();
		r1.run();
		r2.run();
		
		Foo f1 = () -> get();
		f1.f();
		Foo f2 = () -> "1".equals("") ? 1 : 0;
		f2.f();
		//函数方法有返回值，所以要求调用的方法必须有返回值,而且返回值类型要一致
		//Foo f2 = () -> exec();
	}
	
	static int get(){
		return 1;
	}
	static void exec(){
		System.out.println("exec");
	}
}

interface Foo {
	int f();
}
