package com.lovemehta.multilevel_cache.dtos;

import java.util.List;

public class CacheStatsDto {

	@Override
	public String toString() {
		return "CacheStatsDto [usageLevelList=" + usageLevelList.toString() + ", averageReadTime=" + averageReadTime
				+ ", averageWriteTime=" + averageWriteTime + "]";
	}

	public CacheStatsDto(List<Double> usageLevelList, Double averageReadTime, Double averageWriteTime) {
		super();
		this.usageLevelList = usageLevelList;
		this.averageReadTime = averageReadTime;
		this.averageWriteTime = averageWriteTime;
	}

	public List<Double> getUsageLevelList() {
		return usageLevelList;
	}

	public void setUsageLevelList(List<Double> usageLevelList) {
		this.usageLevelList = usageLevelList;
	}

	public Double getAverageReadTime() {
		return averageReadTime;
	}

	public void setAverageReadTime(Double averageReadTime) {
		this.averageReadTime = averageReadTime;
	}

	public Double getAverageWriteTime() {
		return averageWriteTime;
	}

	public void setAverageWriteTime(Double averageWriteTime) {
		this.averageWriteTime = averageWriteTime;
	}

	private List<Double> usageLevelList;
	private Double averageReadTime;
	private Double averageWriteTime;
}
