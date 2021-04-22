package com.phone.dtos;

import com.phone.enums.SearchField;
import com.phone.enums.SearchType;

public class SearchRequest {

	private SearchField searchField;

	private SearchType searchType;

	private String input;

	public SearchRequest(SearchField searchField, SearchType searchType, String input) {
		this.searchField = searchField;
		this.searchType = searchType;
		this.input = input;
	}

	public SearchField getSearchField() {
		return searchField;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public String getInput() {
		return input;
	}
}
