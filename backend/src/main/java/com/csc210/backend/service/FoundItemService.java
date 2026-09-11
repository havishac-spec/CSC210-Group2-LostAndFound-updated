package com.csc210.backend.service;

import com.csc210.backend.dsa.FoundItemBinarySearch;
import com.csc210.backend.dsa.FoundItemHashTable;
import com.csc210.backend.model.FoundItem;
import com.csc210.backend.repository.FoundItemRepository;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FoundItemService {

    private final FoundItemRepository foundItemRepository;
    private final FoundItemHashTable foundItemHashTable;
    private final FoundItemBinarySearch foundItemBinarySearch;

    public FoundItemService(
            FoundItemRepository foundItemRepository,
            FoundItemHashTable foundItemHashTable,
            FoundItemBinarySearch foundItemBinarySearch
    ) {
        this.foundItemRepository = foundItemRepository;
        this.foundItemHashTable = foundItemHashTable;
        this.foundItemBinarySearch = foundItemBinarySearch;
    }
    @PostConstruct
public void loadExistingFoundItemsIntoHashTable() {

    List<FoundItem> existingItems = foundItemRepository.findAll();

    for (FoundItem item : existingItems) {

        foundItemHashTable.insert(
                item.getCategory(),
                item.getId()
        );
    }
}

    public FoundItem saveFoundItem(FoundItem foundItem) {

        FoundItem savedItem = foundItemRepository.save(foundItem);

        foundItemHashTable.insert(
                savedItem.getCategory(),
                savedItem.getId()
        );

        return savedItem;
    }

    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    public List<FoundItem> getFoundItemsByDateRange(
            LocalDateTime start,
            LocalDateTime end
    ) {
        List<FoundItem> foundItems = foundItemRepository.findAll();
        List<FoundItem> sortedItems = new ArrayList<>();

        for (FoundItem item : foundItems) {
            if (item.getDateTime() != null) {
                sortedItems.add(item);
            }
        }

        sortedItems.sort(Comparator.comparing(FoundItem::getDateTime));

        return foundItemBinarySearch.searchByDateRange(sortedItems, start, end);
    }

    public List<FoundItem> getFoundItemsByCategory(String category) {

    List<Long> itemIds = foundItemHashTable.search(category);

    return foundItemRepository.findAllById(itemIds);
}
}