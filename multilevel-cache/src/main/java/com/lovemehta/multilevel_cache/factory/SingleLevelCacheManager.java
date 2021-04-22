package com.lovemehta.multilevel_cache.factory;

import com.lovemehta.multilevel_cache.policies.ReplacementPolicy;
import com.lovemehta.multilevel_cache.repositories.CacheRepository;

public class SingleLevelCacheManager {

	public SingleLevelCacheManager(ReplacementPolicy replacementPolicy, CacheRepository cacheRepository) {
		super();
		this.replacementPolicy = replacementPolicy;
		this.cacheRepository = cacheRepository;
	}

	private ReplacementPolicy replacementPolicy;
	private CacheRepository cacheRepository;

	public void set(String key, String value) {

		boolean status = this.cacheRepository.add(key, value);

		if (status) {

			this.replacementPolicy.markKeyAccessed(key);

		} else {

			String keyToRemove = replacementPolicy.getKeyToBeRemoved();
			if (keyToRemove == null) {
				System.out.println("Error - Key to remove null.");
				return;
			}
			this.cacheRepository.remove(keyToRemove);

			set(key, value);
		}

	}

	public String get(String key) {
		String value = this.cacheRepository.get(key);
		this.replacementPolicy.markKeyAccessed(key);
		return value;
	}

	public double getUsageStats() {

		return cacheRepository.getCurrentUsage();
	}

}
