package com.phone.repositories.partial_caches;

import java.util.ArrayList;
import java.util.List;

import com.phone.models.Contact;
import com.phone.repositories.complete_caches.ContactFirstNameDictionary;

public class FirstNameTrie {

	public static Trie trie = new Trie();

	public static List<Contact> findMatchingContacts(String input) {

		List<String> matchingStrings = trie.getMatchingStrings(input);

		List<Contact> contactsList = new ArrayList<>();

		for (String s : matchingStrings) {
			if (ContactFirstNameDictionary.contactIdByFirstName.containsKey(s)) {
				contactsList.addAll(ContactFirstNameDictionary.contactIdByFirstName.get(s));
			}
		}

		return contactsList;
	}
}
