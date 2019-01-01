package com.beans.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法的引用
 * 如果函数式接口的实现恰好可以通过调用一个静态方法来实现，那么就可以使用静态方法引用
 * 语法：类名::staticMethod
 *
 */
public class Example3 {

	private static String put(){
		return "hello";
	}
	
	private static String toUpperCase(String str){
		return str.toUpperCase();
	}
	
	private static int len(String str1, String str2){
		return str1.length() + str2.length();
	}
	
	public static void main(String[] args) {
		//方法引用
		Function<String, String> function = (str) -> str.toUpperCase();
		System.out.println(function.apply("frank"));
		Consumer<String> consumer = (str) -> System.out.println(str);
		consumer.accept("frnak");
		Supplier<String> supplier1 = () -> Example3.put();
		System.out.println(supplier1.get());
		
		//静态方法引用
		Supplier<String> supplier = Example3::put;
		System.out.println(supplier.get());
		
		Consumer<Integer> con1 = SizeC::newSize;
		con1.accept(20);
		
		Function<String, String> f1 = (str) -> str.toUpperCase();
		System.out.println(f1.apply("aa"));
		Function<String, String> f2 = (str) -> Example3.toUpperCase(str);
		System.out.println(f2.apply("aa"));
		Function<String, String> f3 = Example3::toUpperCase;
		System.out.println(f3.apply("aa"));
		System.out.println(f2.apply("aa"));
		
		BiFunction<String, String, Integer> fiFun1 = (str1,str2) -> {return (str1.length() + str2.length());};
		System.out.println(fiFun1.apply("aa", "bb"));
		BiFunction<String, String, Integer> fiFun2 = (str1,str2) -> Example3.len(str1, str2);
		System.out.println(fiFun2.apply("aa", "bb"));
		BiFunction<String, String, Integer> fiFun3 = Example3::len;
		System.out.println(fiFun3.apply("aa", "bb"));
	}
}

class SizeC {
	public static void newSize(int size) {
		System.out.println("Size is:"+size);
	}
}
