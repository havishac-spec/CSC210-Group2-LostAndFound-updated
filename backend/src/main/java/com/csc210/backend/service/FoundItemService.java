package com.csc210.backend.service;

import com.csc210.backend.dsa.FoundItemHashTable;
import com.csc210.backend.model.FoundItem;
import com.csc210.backend.repository.FoundItemRepository;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class FoundItemService {

    private final FoundItemRepository foundItemRepository;
    private final FoundItemHashTable foundItemHashTable;

    public FoundItemService(
            FoundItemRepository foundItemRepository,
            FoundItemHashTable foundItemHashTable
    ) {
        this.foundItemRepository = foundItemRepository;
        this.foundItemHashTable = foundItemHashTable;
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

    public List<FoundItem> getFoundItemsByCategory(String category) {

    List<Long> itemIds = foundItemHashTable.search(category);

    return foundItemRepository.findAllById(itemIds);
}
}