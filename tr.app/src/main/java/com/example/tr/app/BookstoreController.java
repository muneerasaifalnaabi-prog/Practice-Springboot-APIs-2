package com.example.tr.app;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    public  List<InventoryBook> inventoryBooks = new ArrayList<>();
}
