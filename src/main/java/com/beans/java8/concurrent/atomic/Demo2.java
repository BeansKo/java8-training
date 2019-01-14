package com.beans.java8.concurrent.atomic;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * LongAccumulator
 * 需要两个参数，一个是当前输入的，一个是上次的计算结果
 * @author Frank
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		//输入一个数字，如果这个数字大于前面输入的数字，则直接返回，如果小，则返回上一个
		LongAccumulator longAccumulator = new LongAccumulator((left,right) -> {return left>right?left:right;}, 0);
		
		longAccumulator.accumulate(2);
		System.out.println(longAccumulator.get());
		
		//两数相乘
		LongAccumulator longAccumulator1 = new LongAccumulator((left,right) -> {return left*right;}, 3);
		
		longAccumulator1.accumulate(2);
		System.out.println(longAccumulator1.get());
	}

}
