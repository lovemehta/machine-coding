package com.lovemehta.multilevel_cache.policies;

import java.util.LinkedList;

public class LeastRecentlyUsedReplacementPolicy implements ReplacementPolicy {

	LinkedList<String> ll = new LinkedList<String>();

	public void markKeyAccessed(String key) {
		if (ll.remove(key)) {
			ll.addFirst(key);
		} else {
			ll.addFirst(key);
		}

	}

	public String getKeyToBeRemoved() {
		if (ll.size() > 0) {
			String key = ll.getLast();
			ll.remove(key);
			return key;
		}
		return null;
	}

}
