package com.lovemehta.multilevel_cache.policies;

public interface ReplacementPolicy {

	public void markKeyAccessed(String key);

	public String getKeyToBeRemoved();

}
