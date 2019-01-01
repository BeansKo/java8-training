package com.beans.java8.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream
 * 并行流
 *
 */
public class Example3 {

	public static void main(String[] args) {
		//parallel()串行转成并行效果
		//设置线程数
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
		Optional<Integer> max = Stream.iterate(1, x -> x+1).limit(200).peek(x -> {
			System.out.println(Thread.currentThread().getName());
		}).parallel().max(Integer::compare);
		System.out.println(max.get());
		
		//sequential()并行转成串行效果
		Optional<Integer> min = Stream.iterate(1, x -> x+1).limit(200).peek(x -> {
			System.out.println(Thread.currentThread().getName());
		}).parallel().sequential().min(Integer::compare);
		System.out.println(min.get());
	}

}
