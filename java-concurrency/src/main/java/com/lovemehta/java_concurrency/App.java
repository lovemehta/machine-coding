package com.lovemehta.java_concurrency;

import com.lovemehta.java_concurrency.services.RunnableExamples;
import com.lovemehta.java_concurrency.services.ThreadExamples;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		System.out.println("Name of main thread is -> " + Thread.currentThread().getName());
		ThreadExamples threadExamples = new ThreadExamples();

		threadExamples.runThreadUsingExampleThreadClass();
		threadExamples.runThreadUsingSubClass();

		RunnableExamples runnableExamples = new RunnableExamples();

		runnableExamples.runRunnableUsingAnonymousImplementation();
		runnableExamples.runRunnableUsingClassImplementation();
		runnableExamples.runRunnableUsingLambdaImplementation();

		threadExamples.runThreadParallelismExperiment();

		threadExamples.runSleepThreadExample();

		runnableExamples.runStoppableRunnable();
	}
}
