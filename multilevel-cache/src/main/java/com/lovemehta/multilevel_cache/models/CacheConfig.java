package com.lovemehta.multilevel_cache.models;

public class CacheConfig {

	public CacheConfig(int readTime, int writeTime) {
		this.readTime = readTime;
		this.writeTime = writeTime;
	}

	public int getReadTime() {
		return readTime;
	}

	public void setReadTime(int readTime) {
		this.readTime = readTime;
	}

	public int getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(int writeTime) {
		this.writeTime = writeTime;
	}

	private int readTime;
	private int writeTime;
}
