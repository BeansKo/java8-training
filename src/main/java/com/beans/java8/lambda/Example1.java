package com.beans.java8.lambda;

import java.util.concurrent.Callable;

/**
 * Lambda表达式
 * lambda代替匿名类，代码更加简洁
 */
public class Example1 {

	public static void main(String[] args) throws Exception {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("no lambda");
			}
		};
		r1.run();
		//Lambda,无参无返回值
		Runnable r2 = () -> {System.out.println("无参无返回值");};
		r2.run();
		r2 = () -> System.out.println("无参无返回值");
		r2.run();
		
		Callable<String> c1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "no lambda";
			}
		};
		//Lambda,无参有返回值
		Callable<String> c2 = () -> {return "无参有返回值";};
		Callable<String> c3 = () -> "无参有返回值";
		System.out.println(c1.call());
		System.out.println(c2.call());
		System.out.println(c3.call());
		UserMapper userMapper = new UserMapper() {
			@Override
			public void insert(User user) {
				System.out.println("no lambda");
			}
		};
		userMapper.insert(new User());
		//Lambda,有参无返回值
		UserMapper um = (user) -> {System.out.println("有参无返回值");};
		um.insert(new User());
		um = (User user) -> System.out.println("有参无返回值");
		um.insert(new User());
		
		OrderMapper orderMapper = new OrderMapper() {
			@Override
			public String insert(Order order) {
				return "no lambda"+order;
			}
		};
		System.out.println(orderMapper.insert(new Order()));
		
		//Lambda,有参有返回值
		OrderMapper om1 = (order) -> {return "有参有返回值"+order;};
		OrderMapper om2 = (Order order) -> "有参有返回值"+order;
		System.out.println(om1.insert(new Order()));
		System.out.println(om2.insert(new Order()));
	}

}

@FunctionalInterface
interface UserMapper {
	void insert(User user);
}

interface OrderMapper{
	String insert(Order order);
}

class User {}
class Order {}
