package com.csc210.backend.dsa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void insert(String keyword, Long itemId) {

        if (keyword == null || keyword.trim().isEmpty() || itemId == null) {
            return;
        }

        String normalizedKeyword = keyword.trim().toLowerCase();

        TrieNode current = root;

        for (char ch : normalizedKeyword.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }

        current.isEndOfWord = true;

        if (!current.itemIds.contains(itemId)) {
            current.itemIds.add(itemId);
        }
    }

    public List<Long> search(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String normalizedKeyword = keyword.trim().toLowerCase();

        TrieNode current = root;

        for (char ch : normalizedKeyword.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }

            current = current.children.get(ch);
        }

        if (!current.isEndOfWord) {
            return new ArrayList<>();
        }

        return new ArrayList<>(current.itemIds);
    }

    public List<Long> startsWith(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String normalizedPrefix = prefix.trim().toLowerCase();

        TrieNode current = root;

        for (char ch : normalizedPrefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return new ArrayList<>();
            }

            current = current.children.get(ch);
        }

        Set<Long> result = new HashSet<>();

        collectItemIds(current, result);

        return new ArrayList<>(result);
    }

    private void collectItemIds(TrieNode node, Set<Long> result) {

        if (node.isEndOfWord) {
            result.addAll(node.itemIds);
        }

        for (TrieNode child : node.children.values()) {
            collectItemIds(child, result);
        }
    }
}