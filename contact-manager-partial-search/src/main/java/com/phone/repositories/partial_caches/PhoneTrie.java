package com.phone.repositories.partial_caches;

import java.util.ArrayList;
import java.util.List;

import com.phone.models.Contact;
import com.phone.repositories.complete_caches.ContactLastNameDictionary;
import com.phone.repositories.complete_caches.ContactPhoneDictionary;

public class PhoneTrie {

	public static Trie trie = new Trie();

	public static List<Contact> findMatchingContacts(String input) {

		List<String> matchingStrings = trie.getMatchingStrings(input);

		List<Contact> contactsList = new ArrayList<>();

		for (String s : matchingStrings) {
			if (ContactPhoneDictionary.contactIdByPhone.containsKey(s)) {
				contactsList.addAll(ContactLastNameDictionary.contactIdByLastName.get(s));
			}
		}

		return contactsList;
	}

}
