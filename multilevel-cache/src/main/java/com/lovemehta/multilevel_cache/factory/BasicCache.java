package com.lovemehta.multilevel_cache.factory;

import java.util.Collections;
import java.util.List;

import com.lovemehta.multilevel_cache.dtos.ReadResponseDto;
import com.lovemehta.multilevel_cache.dtos.WriteResponseDto;
import com.lovemehta.multilevel_cache.models.CacheConfig;

public class BasicCache implements SingleLevelCache {

	private CacheConfig cacheConfig; // for this level readtime and write time

	private SingleLevelCacheManager manager; // eviction policy and the cache storage

	private SingleLevelCache nextLevel; // pointer to nexxt level

	public WriteResponseDto set(String key, String value) {
		Double start = 0.0;
		String currentValue = manager.get(key);
		start += cacheConfig.getReadTime();

		if (!value.equals(currentValue)) {

			manager.set(key, value);
			start += cacheConfig.getWriteTime();

		}
		if (nextLevel != null) {
			start += nextLevel.set(key, value).getTimeTaken();
		}
		return new WriteResponseDto(start);
	}

	public BasicCache(CacheConfig cacheConfig, SingleLevelCacheManager manager, SingleLevelCache nextLevel) {
		super();
		this.cacheConfig = cacheConfig;
		this.manager = manager;
		this.nextLevel = nextLevel;
	}

	public ReadResponseDto get(String key) {

		Double start = 0.0;

		String currentValue = manager.get(key);
		start += cacheConfig.getReadTime();

		if (currentValue == null) {
			ReadResponseDto nextResponse = nextLevel.get(key);

			start += nextResponse.getTimeTaken();

			currentValue = nextResponse.getValue();

			if (currentValue != null) {

				manager.set(key, currentValue);
				start += cacheConfig.getWriteTime();
			}
		}

		return new ReadResponseDto(currentValue, start);
	}

	public List<Double> getCacheUsage() {

		List<Double> usageList;

		if (nextLevel == null) {

			usageList = Collections.emptyList();
		} else {

			usageList = nextLevel.getCacheUsage();
		}

		usageList.add(0, manager.getUsageStats());

		return usageList;
	}

}
