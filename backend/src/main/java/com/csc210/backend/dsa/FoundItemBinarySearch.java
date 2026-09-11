package com.csc210.backend.dsa;

import com.csc210.backend.model.FoundItem;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class FoundItemBinarySearch {

    public int lowerBound(List<FoundItem> items, LocalDateTime start) {
        int left = 0;
        int right = items.size();

        while (left < right) {
            int middle = left + (right - left) / 2;
            LocalDateTime itemDateTime = items.get(middle).getDateTime();

            if (itemDateTime.isBefore(start)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    public int upperBound(List<FoundItem> items, LocalDateTime end) {
        int left = 0;
        int right = items.size();

        while (left < right) {
            int middle = left + (right - left) / 2;
            LocalDateTime itemDateTime = items.get(middle).getDateTime();

            if (itemDateTime.isAfter(end)) {
                 right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    public List<FoundItem> searchByDateRange(
            List<FoundItem> items,
            LocalDateTime start,
            LocalDateTime end
    ) {
        if (items == null || items.isEmpty()
                || start == null || end == null
                || start.isAfter(end)) {
            return Collections.emptyList();
        }

        int startIndex = lowerBound(items, start);
        int endIndex = upperBound(items, end);

        return items.subList(startIndex, endIndex);
    }
}