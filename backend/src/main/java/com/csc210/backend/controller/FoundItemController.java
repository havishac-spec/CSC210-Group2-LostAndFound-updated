package com.csc210.backend.controller;

import com.csc210.backend.model.FoundItem;
import com.csc210.backend.service.FoundItemService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/found-items")
public class FoundItemController {

    private final FoundItemService foundItemService;

    public FoundItemController(FoundItemService foundItemService) {
        this.foundItemService = foundItemService;
    }

    @PostMapping
    public FoundItem createFoundItem(@RequestBody FoundItem foundItem) {
        return foundItemService.saveFoundItem(foundItem);
    }

    @GetMapping
    public List<FoundItem> getAllFoundItems() {
        return foundItemService.getAllFoundItems();
    }

    @GetMapping("/category/{category}")
    public List<FoundItem> getFoundItemsByCategory(@PathVariable String category) {
        return foundItemService.getFoundItemsByCategory(category);
    }

    @GetMapping("/date-range")
    public List<FoundItem> getFoundItemsByDateRange(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime start,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime end
    ) {
        return foundItemService.getFoundItemsByDateRange(start, end);
    }
}