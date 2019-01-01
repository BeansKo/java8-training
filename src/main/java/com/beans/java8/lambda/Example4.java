package com.beans.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 实例方法引用
 * 如果函数式接口的实现恰好可以通过调用一个实例方法来实现，那么就可以使用实例方法引用
 *
 */
public class Example4 {

	public String put(){
		return "hello";
	}
	
	public void con(int size){
		System.out.println("size is:"+size);
	}
	
	public void call(){
		Supplier<String> supplier = this::put;
		supplier.get();
	}
	
	public static void main(String[] args) {
		Supplier<String> supplier = () -> {return new Example4().put();};
		supplier.get();
		Supplier<String> supplier1 = new Example4()::put;
		supplier1.get();
		
		Example4 exam = new Example4();
		
		Consumer<Integer> consumer = exam::con;
		consumer.accept(20);
	}
}
