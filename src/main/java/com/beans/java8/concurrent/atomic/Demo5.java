package com.beans.java8.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference
 */
public class Demo5 {

	public static void main(String[] args) {
		AtomicReference<Student> sAtomicReference = new AtomicReference<Student>();
		Student stu1 = new Student(1L, "AA");
		Student stu2 = new Student(2L, "BB");
		sAtomicReference.set(stu1);
		sAtomicReference.compareAndSet(stu1, stu2);
		Student stu3 = sAtomicReference.get();
		System.out.println(stu3.getName());
	}

}
