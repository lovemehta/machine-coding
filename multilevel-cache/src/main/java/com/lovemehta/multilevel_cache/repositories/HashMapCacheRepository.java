package com.lovemehta.multilevel_cache.repositories;

import java.util.HashMap;

public class HashMapCacheRepository implements CacheRepository {

	public HashMapCacheRepository(int maxMapSize) {
		super();
		this.maxMapSize = maxMapSize;
	}

	private HashMap<String, String> map = new HashMap<String, String>();

	private int maxMapSize;

	public boolean add(String key, String value) {

		if (this.map.size() == maxMapSize) {
			return false;
		} else {
			map.put(key, value);
		}
		return true;
	}

	public void remove(String key) {
		map.remove(key);

	}

	public String get(String key) {

		return map.get(key);
	}

	public double getCurrentUsage() {

		return this.map.size() / this.maxMapSize;
	}

}
