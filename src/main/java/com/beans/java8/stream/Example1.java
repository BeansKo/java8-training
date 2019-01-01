package com.beans.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream
 * 流的创建
 *
 */
public class Example1 {

	//通过数组创建流
	static void gen1() {
		String[] arr = {"a","b","c","d"};
		Stream<String> stream = Stream.of(arr);
		stream.forEach(System.out::println);
	}
	
	//通过集合创建流
	static void gen2() {
		String[] arr = {"a","b","c","d"};
		List<String> list = Arrays.asList(arr);
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
	}
	
	//通过Stream.generate创建流，方法内部是Supplier
	static void gen3() {
		System.out.println("----------gen3--------------");
		Stream<String> stream = Stream.generate(() -> "a");
		stream.limit(10).forEach(System.out::println);
	}
	
	//通过Stream.iterate创建流，方法内部是UnaryOperator
	static void gen4() {
		System.out.println("----------gen4--------------");
		Stream<Integer> stream = Stream.iterate(1, (x) -> x+1);
		stream.limit(10).forEach(System.out::println);
	}
	
	//通过其他方式
	static void gen5() throws IOException {
		System.out.println("----------gen5--------------");
		String string = "abcde12345";
		IntStream stream = string.chars();
		
//		stream.forEach((x) -> System.out.println(x));
		stream.forEach(System.out::println);
		
		Files.lines(Paths.get("D:\\Frank\\workspace\\java8\\src\\main\\java\\com\\beans\\java8\\stream\\info.txt"))
		.forEach(System.out::println);;
	}
	
	public static void main(String[] args) throws IOException {
		gen1();
		gen2();
		gen3();
		gen4();
		gen5();
	}

}
