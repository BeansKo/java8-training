package com.beans.java8.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JavaLocalDateTime {

	public static void main(String[] args) {
		//转换对应时区的时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		ZoneId zone = ZoneId.of(ZoneId.SHORT_IDS.get("AST"));
		ZonedDateTime dateTimeInNewYork = ZonedDateTime.of(localDateTime, zone);
		System.out.println("现在时区的时间和特定时区的时间："+dateTimeInNewYork);
	}

}
