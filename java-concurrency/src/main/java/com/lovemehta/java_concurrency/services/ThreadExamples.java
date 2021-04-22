package com.lovemehta.java_concurrency.services;

import com.lovemehta.java_concurrency.models.ExampleThread;

public class ThreadExamples {

	public void runThreadUsingExampleThreadClass() {

		ExampleThread exampleThread = new ExampleThread("threadExtendedClassImplementation");

		exampleThread.start();
	}

	public void runThreadUsingSubClass() {

		Thread newThread = new Thread("threadSubClassImplementation") { // providing optional name to thread comes in
																		// handy
			@Override
			public void run() {
				System.out.println("Inside thread subclass. Name of thread is " + Thread.currentThread().getName());
			}
		};

		newThread.start();
		// can access name of newthread here as given below
		// System.out.println(newThread.getName());

	}

	public void runThreadParallelismExperiment() {

		// sometimes it can be seen that numbers are not in order in the output. This
		// means that the threads are running in parallel and a thread might terminate
		// running before some thread which was run before.

		for (int i = 0; i < 10; i++) {

			new Thread("ThreadNumber " + i) {
				@Override
				public void run() {
					System.out.println("Running thread " + Thread.currentThread().getName());
				}
			}.start();

		}

	}

	public void runSleepThreadExample() {

		new Thread("sleepyThread") {
			@Override
			public void run() {
				System.out.println("Inside " + Thread.currentThread().getName());
				System.out.println("Thread going to sleep for 10 seconds.");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread woke up.");
			}
		}.start();

	}

}
