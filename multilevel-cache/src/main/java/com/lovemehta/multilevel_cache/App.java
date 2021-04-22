package com.lovemehta.multilevel_cache;

import com.lovemehta.multilevel_cache.dtos.ReadResponseDto;
import com.lovemehta.multilevel_cache.dtos.WriteResponseDto;
import com.lovemehta.multilevel_cache.factory.BasicCache;
import com.lovemehta.multilevel_cache.factory.MultiLevelCacheHolder;
import com.lovemehta.multilevel_cache.factory.SingleLevelCacheManager;
import com.lovemehta.multilevel_cache.models.CacheConfig;
import com.lovemehta.multilevel_cache.policies.LeastRecentlyUsedReplacementPolicy;
import com.lovemehta.multilevel_cache.repositories.HashMapCacheRepository;

public class App {
	public static void main(String[] args) {

		SingleLevelCacheManager cacheManager1 = new SingleLevelCacheManager(new LeastRecentlyUsedReplacementPolicy(),
				new HashMapCacheRepository(2));

		SingleLevelCacheManager cacheManager2 = new SingleLevelCacheManager(new LeastRecentlyUsedReplacementPolicy(),
				new HashMapCacheRepository(2));

		CacheConfig cacheConfig1 = new CacheConfig(1, 3);
		CacheConfig cacheConfig2 = new CacheConfig(2, 4);

		BasicCache level2 = new BasicCache(cacheConfig2, cacheManager2, null);
		BasicCache level1 = new BasicCache(cacheConfig1, cacheManager1, level2);

		MultiLevelCacheHolder multiLevelCacheHolder = new MultiLevelCacheHolder(level1, 5);

//		ReadResponseDto r3 = multiLevelCacheHolder.get("hh");
//		System.out.println(r3.toString());

		WriteResponseDto w1 = multiLevelCacheHolder.set("k1", "v1"); // 10
		System.out.println("write time  = " + w1.getTimeTaken());
		WriteResponseDto w2 = multiLevelCacheHolder.set("k2", "v2");// 10
		System.out.println("write time  = " + w2.getTimeTaken());

		ReadResponseDto r1 = multiLevelCacheHolder.get("k1"); // value =v1, time =1
		System.out.println("read time  = " + r1.getTimeTaken() + " value read = " + r1.getValue());

		WriteResponseDto w3 = multiLevelCacheHolder.set("k3", "v3");

		ReadResponseDto r2 = multiLevelCacheHolder.get("k2");// value =v2, time =1
		System.out.println("read time  = " + r2.getTimeTaken() + " value read = " + r2.getValue());

		WriteResponseDto w4 = multiLevelCacheHolder.set("k1", "v6");
		ReadResponseDto r3 = multiLevelCacheHolder.get("k1");
		System.out.println(r3.toString());
	}
}

/*
 * L1 --> next cache
 */
