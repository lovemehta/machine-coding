package com.phone.services;

import java.util.ArrayList;
import java.util.List;

import com.phone.dtos.SearchRequest;
import com.phone.dtos.SearchResponse;
import com.phone.enums.SearchType;
import com.phone.models.Contact;
import com.phone.repositories.ContactRepo;
import com.phone.repositories.complete_caches.ContactFirstNameDictionary;
import com.phone.repositories.complete_caches.ContactLastNameDictionary;
import com.phone.repositories.complete_caches.ContactPhoneDictionary;
import com.phone.repositories.partial_caches.FirstNameTrie;
import com.phone.repositories.partial_caches.LastNameTrie;
import com.phone.repositories.partial_caches.PhoneTrie;

public class ContactManagerImpl implements ContactManager {

	ContactRepo contactRepo = new ContactRepo();

	ContactFirstNameDictionary contactFirstNameDictionary = new ContactFirstNameDictionary();

	ContactLastNameDictionary contactLastNameDictionary = new ContactLastNameDictionary();

	ContactPhoneDictionary contactPhoneDictionary = new ContactPhoneDictionary();

	FirstNameTrie firstNameTrie = new FirstNameTrie();

	LastNameTrie lastNameTrie = new LastNameTrie();

	PhoneTrie phoneTrie = new PhoneTrie();

	@Override
	public boolean add(Contact contact) {

		ContactRepo.contacts.put(contact.getId(), contact);
		if (ContactRepo.contacts.get(contact.getId()) != null) {

			new Thread(new Runnable() {
				@Override
				public void run() {
					updateCaches(contact);
				}
			}).start();

			return true;
		}
		return false;
	}

	private void updateCaches(Contact contact) {

		if (ContactFirstNameDictionary.contactIdByFirstName.containsKey(contact.getFirstName())) {
			List<Contact> tempList = ContactFirstNameDictionary.contactIdByFirstName.get(contact.getFirstName());
			tempList.add(contact);
			ContactFirstNameDictionary.contactIdByFirstName.put(contact.getFirstName(), tempList);

		} else {
			List<Contact> tempList = new ArrayList<>();
			tempList.add(contact);
			ContactFirstNameDictionary.contactIdByFirstName.put(contact.getFirstName(), tempList);
		}

		FirstNameTrie.trie.insert(contact.getFirstName());

		if (ContactLastNameDictionary.contactIdByLastName.containsKey(contact.getLastName())) {
			List<Contact> tempList = ContactLastNameDictionary.contactIdByLastName.get(contact.getLastName());
			tempList.add(contact);
			ContactLastNameDictionary.contactIdByLastName.put(contact.getLastName(), tempList);

		} else {
			List<Contact> tempList = new ArrayList<>();
			tempList.add(contact);
			ContactLastNameDictionary.contactIdByLastName.put(contact.getLastName(), tempList);
		}

		LastNameTrie.trie.insert(contact.getLastName());

		if (ContactPhoneDictionary.contactIdByPhone.containsKey(contact.getPhoneNumber())) {

			ContactPhoneDictionary.contactIdByPhone.put(contact.getPhoneNumber(), contact);

		} else {
			ContactPhoneDictionary.contactIdByPhone.put(contact.getPhoneNumber(), contact);
		}

		PhoneTrie.trie.insert(contact.getPhoneNumber());
	}

	@Override
	public boolean update(Contact contact) {

		if (ContactRepo.contacts.containsKey(contact.getId())) {
			if (ContactRepo.contacts.put(contact.getId(), contact) != null) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						updateCaches(contact);
					}
				}).start();
				return true;
			}
		}

		return false;
	}

	@Override
	public SearchResponse search(SearchRequest searchRequest) {

		if (searchRequest.getSearchType().equals(SearchType.COMPLETE)) {
			List<Contact> tempContacts = new ArrayList<Contact>();
			switch (searchRequest.getSearchField()) {
			case FIRST_NAME:
				tempContacts = ContactFirstNameDictionary.contactIdByFirstName.get(searchRequest.getInput());
				break;
			case LAST_NAME:
				tempContacts = ContactLastNameDictionary.contactIdByLastName.get(searchRequest.getInput());
				break;

			case PHONE:
				tempContacts.add(ContactPhoneDictionary.contactIdByPhone.get(searchRequest.getInput()));
				break;
			}
			if (tempContacts != null) {
				return new SearchResponse(tempContacts.size(), tempContacts);
			} else {
				return new SearchResponse(0, new ArrayList<Contact>());
			}
		}

		if (searchRequest.getSearchType().equals(SearchType.PARTIAL)) {

			switch (searchRequest.getSearchField()) {
			case FIRST_NAME:

				return new SearchResponse(FirstNameTrie.findMatchingContacts(searchRequest.getInput()).size(),
						FirstNameTrie.findMatchingContacts(searchRequest.getInput()));

			case LAST_NAME:
				return new SearchResponse(LastNameTrie.findMatchingContacts(searchRequest.getInput()).size(),
						LastNameTrie.findMatchingContacts(searchRequest.getInput()));
			case PHONE:
				return new SearchResponse(PhoneTrie.findMatchingContacts(searchRequest.getInput()).size(),
						PhoneTrie.findMatchingContacts(searchRequest.getInput()));

			}
		}

		return new SearchResponse(0, new ArrayList<Contact>());
	}

}
