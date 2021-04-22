package com.phone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phone.dtos.SearchRequest;
import com.phone.dtos.SearchResponse;
import com.phone.enums.SearchField;
import com.phone.enums.SearchType;
import com.phone.models.Contact;
import com.phone.services.ContactManager;
import com.phone.services.ContactManagerImpl;

public class ContactManagerTest {
	@Test
	void test() {

		ContactManager contactManager = new ContactManagerImpl();

		Contact ram = new Contact("1", "Ram", "Kapoor", "+91-2222222222");

		contactManager.add(ram);

		SearchResponse response = contactManager
				.search(new SearchRequest(SearchField.FIRST_NAME, SearchType.COMPLETE, "Ram"));

		Assertions.assertEquals(ram.getFirstName(), response.getResults().get(0).getFirstName());

	}
}
