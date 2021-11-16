package com.datastructures.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public String content;
    public boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
    }
}
