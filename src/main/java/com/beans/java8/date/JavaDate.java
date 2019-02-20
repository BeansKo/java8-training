package com.beans.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * LocalDate只会用来处理日期，没有时间。线程安全
    1. Instant 时间戳 
	2. LocalDate 日期类 不包含 时分秒 只有年月日 
	3. LocalTime 时间类 只包含 时分秒 
	4. LocalDateTime 包含以上 
	5. Clock 时钟 
	6. 纳秒 System.nanoTime
 * @author fl76
 *
 */
public class JavaDate {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("今天是："+today);
		
		//获取年月日
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.println("年："+year+"\n月："+month+"\n日："+day);
		
		//获取特定日期
		LocalDate dateOfBirth = LocalDate.of(2019, 02, 19);
		System.out.println("你输入的日期是："+dateOfBirth);
		
		//判断两个日期是否相等
		System.out.println("今天是我的生日吗？"+today.equals(dateOfBirth));
		
		//如何检查重复事件，比如生日
		MonthDay birthDay = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
		if(currentMonthDay.equals(birthDay)) {
			System.out.println("今天是你的生日！");
		} else {
			System.out.println("今天不是你的生日！");
		}
		
		//两周后的日期
		System.out.println("2周后的日期："+today.plus(2,ChronoUnit.WEEKS));
		
		//一年前的日期
		System.out.println("1年前的日期:"+today.minus(1,ChronoUnit.YEARS));
		
		//日期比较
		System.out.println("日期："+dateOfBirth+"是否在"+today+"之前："+dateOfBirth.isBefore(today));
		
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("这个月的年月%s有%d天%n",currentYearMonth,currentYearMonth.lengthOfMonth());
		
		//格式化日期
		String dayAfterTommorrw = "20160404";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrw, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("字符%s格式化后的日期格式是:%s%n",dayAfterTommorrw,formatted);
		
		//自定义格式化日期
		String goodFriday = "04 14 2016";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate holiday = LocalDate.parse(goodFriday, formatter);
		System.out.printf("字符%s转换成功后的日期是%s %n",goodFriday,holiday);
		
		//日期进行格式化，转换成字符串
		LocalDateTime arrivalDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm a");
		String landing = arrivalDate.format(format);
		System.out.printf("时间日期%s转换后的字符是%s%n",arrivalDate,landing);
	}

}
