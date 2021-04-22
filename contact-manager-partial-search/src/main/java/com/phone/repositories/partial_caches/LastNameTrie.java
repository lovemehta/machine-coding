package com.phone.repositories.partial_caches;

import java.util.ArrayList;
import java.util.List;

import com.phone.models.Contact;
import com.phone.repositories.complete_caches.ContactLastNameDictionary;

public class LastNameTrie {

	public static Trie trie = new Trie();

	public static List<Contact> findMatchingContacts(String input) {

		List<String> matchingStrings = trie.getMatchingStrings(input);

		List<Contact> contactsList = new ArrayList<>();

		for (String s : matchingStrings) {
			if (ContactLastNameDictionary.contactIdByLastName.containsKey(s)) {
				contactsList.addAll(ContactLastNameDictionary.contactIdByLastName.get(s));

				/* remove duplicates */
			}
		}

		return contactsList;
	}
}
