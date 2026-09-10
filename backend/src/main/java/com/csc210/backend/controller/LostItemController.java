package com.csc210.backend.controller;

import com.csc210.backend.model.LostItem;
import com.csc210.backend.service.LostItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost-items")
public class LostItemController {

    private final LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    @PostMapping
    public LostItem createLostItem(@RequestBody LostItem lostItem) {
        return lostItemService.saveLostItem(lostItem);
    }

    @GetMapping
    public List<LostItem> getAllLostItems() {
        return lostItemService.getAllLostItems();
    }
}