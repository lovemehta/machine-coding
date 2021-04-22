package com.lovemehta.java_concurrency.services;

import com.lovemehta.java_concurrency.models.ExampleRunnable;
import com.lovemehta.java_concurrency.models.StoppableRunnable;

public class RunnableExamples {

	public void runRunnableUsingClassImplementation() {

		Runnable runnable = new ExampleRunnable();

		Thread thread = new Thread(runnable, "threadRunningRunnableClassImplementation"); // providing option names to
																							// thread comes in handy

		thread.start();

	}

	public void runRunnableUsingAnonymousImplementation() {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("Inside runnable anonymous implementation. Name of thread is "
						+ Thread.currentThread().getName());

			}
		};
		Thread thread = new Thread(runnable, "threadRunningRunnableAnonymousImplementation");

		thread.start();

	}

	public void runRunnableUsingLambdaImplementation() {

		Runnable runnable = () -> {
			System.out.println(
					"Inside runnable lambda implementation. Name of thread is " + Thread.currentThread().getName());
		};

		Thread thread = new Thread(runnable, "threadRunningRunnableLambdaImplementation");

		thread.start();

	}

	public void runStoppableRunnable() {

		StoppableRunnable runnable = new StoppableRunnable();
		Thread thread = new Thread(runnable);
		thread.start();

		try {
			Thread.sleep(7000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runnable.stopRunning();

	}
}
