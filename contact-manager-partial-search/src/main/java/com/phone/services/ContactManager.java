package com.phone.services;

import com.phone.dtos.SearchRequest;
import com.phone.dtos.SearchResponse;
import com.phone.models.Contact;

public interface ContactManager {

	boolean add(Contact contact);

	boolean update(Contact contact);

	SearchResponse search(SearchRequest searchRequest);
}
