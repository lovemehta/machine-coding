package com.lovemehta.java_concurrency.models;

public class StoppableRunnable implements Runnable {

	// We cannot create a runnable implementation with more than one methods using a
	// lambda implementation. A Java lambda can only implement a single method.

	private boolean doStop = false;

	private synchronized boolean keepRunning() {
		return !this.doStop;
	}

	public synchronized void stopRunning() {
		System.out.println("Stopping stoppable thread.");
		this.doStop = true;
	}

	@Override
	public void run() {
		while (keepRunning()) {

			System.out.println("Running stoppable thread");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
