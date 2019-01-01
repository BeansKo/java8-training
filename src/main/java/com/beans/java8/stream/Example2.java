package com.beans.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Stream
 * 中间操作和终止操作
 *
 */
public class Example2 {

	public static void main(String[] args) {
		//终止操作
		Arrays.asList(1,2,3,4,5).stream().filter(x -> x%2==0).forEach(System.out::println);
		int sum = Arrays.asList(1,2,3,4,5,6).stream().mapToInt(x ->x).sum();
		System.out.println("sum="+sum);
		
		int max = Arrays.asList(1,2,3,4,5,6).stream().max((x,y) -> x-y).get();
		System.out.println("max:"+max);
		
		int min = Arrays.asList(1,2,3,4,5,6).stream().min((x,y) -> x-y).get();
		System.out.println("min:"+min);
		
		int any = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findAny().get();
		System.out.println("any:"+any);
		
		int first = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 ==0).findFirst().get();
		System.out.println("first:"+first);
		
		int last = Arrays.asList(1,2,3,4,5,6).stream().sorted((x,y) -> y-x).findFirst().get();
		System.out.println("last:"+last);
		
		Arrays.asList(3,7,1,22,4).stream().sorted().forEach(System.out::println);
		Arrays.asList(3,7,1,22,4).stream().sorted((a,b) -> {return b-a;}).forEach(System.out::println);
		Arrays.asList("a","aa","aaa","b").stream().sorted((a,b) -> a.length()-b.length()).forEach(System.out::println);
		
		List<Integer> list = Stream.iterate(1,x -> x+1).limit(50).filter(x -> x%2 == 0).collect(Collectors.toList());
		System.out.println(list);
		
		//中间操作
		Arrays.asList(1,2,2,3,3).stream().distinct().forEach(System.out::println);
		Set<Integer> set = Arrays.asList(1,2,2,3,3).stream().collect(Collectors.toSet());
		System.out.println(set);
		
		List<Integer> list2 = Stream.iterate(1, x -> x+1).limit(50).sorted((a,b) -> b-a).skip(10).limit(10).collect(Collectors.toList());
		System.out.println(list2);
		
		String str= "11,22,33,44";
	    int result = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
	    System.out.println(result);
	    
	    String names = "zhangsan,lisi,wangwu";
	    Stream.of(names.split(",")).map(x -> new User(x)).forEach(System.out::println);
	    Stream.of(names.split(",")).map(User::new).forEach(System.out::println);
	    Stream.of(names.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
	    Stream.of(names.split(",")).map(Person::build).forEach(System.out::println);
	    Stream.of(names.split(",")).peek(System.out::println).forEach(System.out::println);
	}

}

class User {
	private String name;
	private int age;
	
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Person build(String name){
		Person person = new Person();
		person.setName(name);
		return person;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
