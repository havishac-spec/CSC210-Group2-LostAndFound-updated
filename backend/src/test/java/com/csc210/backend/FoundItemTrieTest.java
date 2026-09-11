package com.csc210.backend;

import com.csc210.backend.dsa.FoundItemTrie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoundItemTrieTest {

    @Test
    void insertAndSearchShouldReturnItemIds() {

        FoundItemTrie trie = new FoundItemTrie();

        trie.insert("wallet", 17L);
        trie.insert("wallet", 23L);

        List<Long> result = trie.search("wallet");

        assertEquals(List.of(17L, 23L), result);
    }

    @Test
    void searchShouldBeCaseInsensitive() {

        FoundItemTrie trie = new FoundItemTrie();

        trie.insert("Wallet", 17L);

        List<Long> result = trie.search("wallet");

        assertEquals(List.of(17L), result);
    }

    @Test
    void searchShouldReturnEmptyForUnknownKeyword() {

        FoundItemTrie trie = new FoundItemTrie();

        trie.insert("wallet", 17L);

        List<Long> result = trie.search("phone");

        assertEquals(List.of(), result);
    }

    @Test
    void startsWithShouldReturnMatchingItemIds() {

        FoundItemTrie trie = new FoundItemTrie();

        trie.insert("wallet", 17L);
        trie.insert("watch", 23L);
        trie.insert("phone", 31L);

        List<Long> result = trie.startsWith("wa");

        assertEquals(2, result.size());
        assertEquals(true, result.contains(17L));
        assertEquals(true, result.contains(23L));
    }
}