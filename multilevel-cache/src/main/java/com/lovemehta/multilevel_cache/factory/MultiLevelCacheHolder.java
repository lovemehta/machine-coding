package com.lovemehta.multilevel_cache.factory;

import java.util.ArrayList;
import java.util.List;

import com.lovemehta.multilevel_cache.dtos.CacheStatsDto;
import com.lovemehta.multilevel_cache.dtos.ReadResponseDto;
import com.lovemehta.multilevel_cache.dtos.WriteResponseDto;

public class MultiLevelCacheHolder {

	private SingleLevelCache cacheHead; // l1 cache
	private List<Double> readTimes; // last readtime until now for given avg window
	private List<Double> writeTimes;

	private int avgWindow;

	public MultiLevelCacheHolder(SingleLevelCache cacheHead, int avgWindow) {
		this.cacheHead = cacheHead;
		this.avgWindow = avgWindow;
		this.readTimes = new ArrayList<Double>(avgWindow);
		this.writeTimes = new ArrayList<Double>(avgWindow);
	}

	public WriteResponseDto set(String key, String value) {
		final WriteResponseDto responseDto = cacheHead.set(key, value);

		if (writeTimes.size() == this.avgWindow) {
			writeTimes.remove(0);
		}

		writeTimes.add(responseDto.getTimeTaken());

		return responseDto;
	}

	public ReadResponseDto get(String key) {
		ReadResponseDto responseDto = cacheHead.get(key);

		if (readTimes.size() == this.avgWindow) {
			readTimes.remove(0);
		}

		readTimes.add(responseDto.getTimeTaken());

		return responseDto;
	}

	public CacheStatsDto getStats() {
		return new CacheStatsDto(cacheHead.getCacheUsage(), getAvgReadTime(), getAvgWriteTime());
	}

	private Double getAvgReadTime() {
		return getSum(readTimes) / readTimes.size();
	}

	private Double getAvgWriteTime() {
		return getSum(writeTimes) / writeTimes.size();
	}

	private Double getSum(List<Double> times) {
		Double sum = 0.0;
		for (Double time : times) {
			sum += time;
		}
		return sum;
	}
}
