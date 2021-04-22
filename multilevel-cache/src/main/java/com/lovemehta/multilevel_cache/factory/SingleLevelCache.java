package com.lovemehta.multilevel_cache.factory;

import java.util.List;

import com.lovemehta.multilevel_cache.dtos.ReadResponseDto;
import com.lovemehta.multilevel_cache.dtos.WriteResponseDto;

public interface SingleLevelCache {

	WriteResponseDto set(String key, String value);

	ReadResponseDto get(String key);

	List<Double> getCacheUsage();
}
