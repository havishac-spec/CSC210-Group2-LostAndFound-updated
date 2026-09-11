package com.csc210.backend.dsa;

import com.csc210.backend.model.FoundItem;
import com.csc210.backend.model.LostItem;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SimilarityScorer {

    private static final double COLOR_WEIGHT = 0.35;
    private static final double LOCATION_WEIGHT = 0.30;
    private static final double KEYWORD_WEIGHT = 0.35;

    public double score(LostItem lostItem, FoundItem candidate) {
        if (lostItem == null || candidate == null) {
            return 0.0;
        }

        double colorScore = calculateColorScore(lostItem.getColor(), candidate.getColor());
        double locationScore = calculateLocationScore(lostItem.getLocation(), candidate.getLocation());
        double keywordScore = calculateKeywordSimilarity(
                lostItem.getItemName(),
                lostItem.getDescription(),
                candidate.getItemName(),
                candidate.getDescription()
        );

        return (COLOR_WEIGHT * colorScore)
                + (LOCATION_WEIGHT * locationScore)
                + (KEYWORD_WEIGHT * keywordScore);
    }

    private double calculateColorScore(String lostColor, String foundColor) {
        if (lostColor == null || foundColor == null) {
            return 0.0;
        }

        return normalize(lostColor).equals(normalize(foundColor)) ? 1.0 : 0.0;
    }

    private double calculateLocationScore(String lostLocation, String foundLocation) {
        if (lostLocation == null || foundLocation == null) {
            return 0.0;
        }

        return normalize(lostLocation).equals(normalize(foundLocation)) ? 1.0 : 0.0;
    }

    private double calculateKeywordSimilarity(
            String lostItemName,
            String lostDescription,
            String foundItemName,
            String foundDescription
    ) {
        Set<String> lostWords = extractWords(lostItemName, lostDescription);
        Set<String> foundWords = extractWords(foundItemName, foundDescription);

        if (lostWords.isEmpty() && foundWords.isEmpty()) {
            return 0.0;
        }

        if (lostWords.isEmpty() || foundWords.isEmpty()) {
            return 0.0;
        }

        Set<String> commonWords = new HashSet<>(lostWords);
        commonWords.retainAll(foundWords);

        Set<String> allWords = new HashSet<>(lostWords);
        allWords.addAll(foundWords);

        return allWords.isEmpty() ? 0.0 : (double) commonWords.size() / allWords.size();
    }

    private Set<String> extractWords(String... textParts) {
        return Arrays.stream(textParts)
                .filter(part -> part != null && !part.trim().isEmpty())
                .flatMap(part -> Arrays.stream(
                        part.toLowerCase()
                                .replaceAll("[^a-z0-9\\s]", " ")
                                .split("\\s+")))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toSet());
    }

    private String normalize(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toLowerCase();
    }
}
