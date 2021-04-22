package com.lovemehta.multilevel_cache.repositories;

public interface CacheRepository {

	public boolean add(String key, String value);

	public void remove(String key);

	public String get(String key);

	public double getCurrentUsage();

}
