package com.csc210.backend.dsa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FoundItemHashTable {
    private static final int TABLE_SIZE = 257;
    private List<Entry>[] table;
    private static class Entry {

    String category;
    List<Long> itemIds;

    Entry(String category) {
        this.category = category;
        this.itemIds = new ArrayList<>();
    }
}
public FoundItemHashTable() {
    table = new ArrayList[TABLE_SIZE];

    for (int i = 0; i < TABLE_SIZE; i++) {
        table[i] = new ArrayList<>();
    }
}
private int hash(String category) {
    return Math.floorMod(category.toLowerCase().hashCode(), TABLE_SIZE);
}
public void insert(String category, Long itemId) {

    String normalizedCategory = category.trim().toLowerCase();

    int index = hash(normalizedCategory);

    for (Entry entry : table[index]) {

        if (entry.category.equals(normalizedCategory)) {
            entry.itemIds.add(itemId);
            return;
        }
    }

    Entry newEntry = new Entry(normalizedCategory);
    newEntry.itemIds.add(itemId);

    table[index].add(newEntry);
}
public List<Long> search(String category) {

    String normalizedCategory = category.trim().toLowerCase();

    int index = hash(normalizedCategory);

    for (Entry entry : table[index]) {

        if (entry.category.equals(normalizedCategory)) {
            return entry.itemIds;
        }
    }

    return new ArrayList<>();
}
public void printTable() {

    for (int i = 0; i < TABLE_SIZE; i++) {

        if (!table[i].isEmpty()) {

            System.out.println("Bucket " + i + ":");

            for (Entry entry : table[i]) {
                System.out.println(
                        "  " + entry.category + " -> " + entry.itemIds
                );
            }
        }
    }
}
}
