package com.lovemehta.multilevel_cache.dtos;

public class WriteResponseDto {

	@Override
	public String toString() {
		return "WriteResponseDto [timeTaken=" + timeTaken + "]";
	}

	public WriteResponseDto(Double timeTaken) {
		super();
		this.timeTaken = timeTaken;
	}

	private Double timeTaken;

	public Double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Double timeTaken) {
		this.timeTaken = timeTaken;
	}
}
