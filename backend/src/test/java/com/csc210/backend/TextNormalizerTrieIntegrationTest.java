package com.csc210.backend;

import com.csc210.backend.dsa.FoundItemTrie;
import com.csc210.backend.dsa.TextNormalizer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextNormalizerTrieIntegrationTest {

    @Test
    void normalizedKeywordsShouldBeStoredInTrie() {

        TextNormalizer normalizer = new TextNormalizer();
        FoundItemTrie trie = new FoundItemTrie();

        List<String> keywords =
                normalizer.extractKeywords("Black Leather-Wallet");

        for (String keyword : keywords) {
            trie.insert(keyword, 17L);
        }

        assertEquals(List.of(17L), trie.search("wallet"));
        assertEquals(List.of(17L), trie.startsWith("wal"));
    }
}