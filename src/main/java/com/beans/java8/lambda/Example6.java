package com.beans.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
 * 语法：类名::new
 */
public class Example6 {

	public static void main(String[] args) {
		Supplier<Person> supplier1 = () -> new Person();
		supplier1.get();
		Supplier<Person> supplier2 = Person::new;
		supplier2.get();
		
		Supplier<List<String>> supplier3 = ArrayList<String>::new;
		supplier3.get();
		Supplier<Thread> supplier4 = Thread::new;
		supplier4.get();
		
		Consumer<String> consumer1 = (str) -> new Person(str);
		Consumer<String> consumer2 = Person::new;
		consumer1.accept("aa");
		consumer2.accept("bb");
		
		Function<String, Integer> function1 = (str) -> Integer.valueOf(str);
		Function<String, Integer> function2 = Integer::valueOf;
		System.out.println(function1.apply("20"));
		System.out.println(function2.apply("40"));
		
		Function<String, Person> function3 = Person::new;
		System.out.println(function3.apply("cc"));
	}

}

class Person {
	public Person() {
		System.out.println("new Person()");
	}
	
	public Person(String name){
		System.out.println(name);
	}
}
