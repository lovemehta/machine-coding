package com.lovemehta.java_concurrency.models;

public class ExampleThread extends Thread {

	public ExampleThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Inside ExampleThread. Name of thread is " + Thread.currentThread().getName());
	}
}
