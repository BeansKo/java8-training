package com.beans.java8.date;

import java.time.Instant;
import java.time.LocalTime;

/**
 * 时间类LocalTime
 * @author fl76
 *
 */
public class JavaTime {

	public static void main(String[] args) {
		//当期的时间戳
		System.out.println("时间戳:"+Instant.now());
		//获取当前时间
		LocalTime time = LocalTime.now();
		System.out.println("现在的时间是："+time);
		
		//增加小时
		LocalTime two = time.plusHours(-2);
		System.out.println("2小时候前的时间是:"+two);
	}

}
