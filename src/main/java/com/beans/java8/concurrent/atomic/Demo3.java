package com.beans.java8.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray
 * @author Frank
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		int[] arr = {2,3};
		AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
		System.out.println(atomicIntegerArray.addAndGet(0, 8));
		
		//数组第1个元素乘以2，并返回
		System.out.println(atomicIntegerArray.accumulateAndGet(1, 3, (x,y) -> {return x*y;}));
	}
}
