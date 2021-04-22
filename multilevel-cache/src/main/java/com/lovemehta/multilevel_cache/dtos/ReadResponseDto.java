package com.lovemehta.multilevel_cache.dtos;

public class ReadResponseDto {

	@Override
	public String toString() {
		return "ReadResponseDto [value=" + value + ", timeTaken=" + timeTaken + "]";
	}

	public ReadResponseDto(String value, Double timeTaken) {
		super();
		this.value = value;
		this.timeTaken = timeTaken;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Double timeTaken) {
		this.timeTaken = timeTaken;
	}

	private String value;

	private Double timeTaken;

}