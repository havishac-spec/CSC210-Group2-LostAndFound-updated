package com.csc210.backend;

import com.csc210.backend.dsa.TextNormalizer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextNormalizerTest {

    @Test
    void extractKeywordsShouldNormalizeText() {

        TextNormalizer normalizer = new TextNormalizer();

        List<String> result =
                normalizer.extractKeywords("Black Leather-Wallet!");

        assertEquals(List.of("black", "leather", "wallet"), result);
    }
}