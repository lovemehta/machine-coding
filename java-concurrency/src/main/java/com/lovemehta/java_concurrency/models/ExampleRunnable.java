package com.lovemehta.java_concurrency.models;

public class ExampleRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside ExampleRunnable. Name of thread is" + Thread.currentThread().getName());
	}
}
