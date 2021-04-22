package com.phone.repositories.partial_caches;

import java.util.HashMap;

class TrieNode {
	char c;
	TrieNode parent;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}
}