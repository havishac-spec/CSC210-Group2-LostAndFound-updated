package com.csc210.backend.dsa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FoundItemTrie {

    private static class TrieNode {

        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        List<Long> itemIds;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
            itemIds = new ArrayList<>();
        }
    }

    private TrieNode root;

    public FoundItemTrie() {
        root = new TrieNode();
    }

}