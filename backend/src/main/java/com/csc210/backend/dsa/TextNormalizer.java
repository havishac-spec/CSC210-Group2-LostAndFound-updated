package com.csc210.backend.dsa;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TextNormalizer {

    public List<String> extractKeywords(String text) {

        List<String> keywords = new ArrayList<>();

        if (text == null || text.trim().isEmpty()) {
            return keywords;
        }

        String normalizedText = text
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", " ")
                .trim();

        if (normalizedText.isEmpty()) {
            return keywords;
        }

        for (String word : normalizedText.split("\\s+")) {
            if (!word.isEmpty()) {
                keywords.add(word);
            }
        }

        return keywords;
    }
}