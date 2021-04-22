package com.phone.dtos;

import java.util.List;

import com.phone.models.Contact;

public class SearchResponse {

	private int totalCount;

	private List<Contact> results;

	public SearchResponse(int totalCount, List<Contact> results) {
		this.totalCount = totalCount;
		this.results = results;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Contact> getResults() {
		return results;
	}

	public void setResults(List<Contact> results) {
		this.results = results;
	}
}
