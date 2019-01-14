package com.beans.java8.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/*
 * AtomicLongFieldUpdaterDemo
 */
public class Demo4 {
	public static void main(String[] args) {
		Student student = new Student(1L, "aa");
		AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");
		longFieldUpdater.compareAndSet(student, 1L, 100L);
		System.out.println(student.getId());
		
		AtomicReferenceFieldUpdater<Student, String> referenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
		referenceFieldUpdater.compareAndSet(student, "aa", "bb");
		System.out.println(student.getName());
	}
}

class Student {
	volatile long id;
	volatile String name;
	
	public Student(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
