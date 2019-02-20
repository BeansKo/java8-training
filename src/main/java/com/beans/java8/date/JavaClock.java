package com.beans.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class JavaClock {

	public static void main(String[] args) {
		//时间戳
		Clock clock = Clock.systemUTC();
		System.out.println("Clock:"+clock.instant());
		clock = Clock.systemDefaultZone();
		System.out.println("Clock:"+clock);
		System.out.println("Clock:"+clock.millis());
		Instant current = Clock.system(ZoneId.of("Asia/Tokyo")).instant();
		System.out.println(current);
	}
}
