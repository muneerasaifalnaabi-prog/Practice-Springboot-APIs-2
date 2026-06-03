package com.example.tr.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {
    public List<InventoryBook> inventoryBooks = new ArrayList<>();

    @GetMapping("/addInventoryBook")
    public String addInventoryBook(@RequestParam Integer id, @RequestParam String title, @RequestParam Double price, @RequestParam Integer stock) {
           InventoryBook inventoryBook =new InventoryBook(id,title,price,stock);
           inventoryBooks.add(inventoryBook);

           return " Booke added successfully to catalog ";
    }

    @GetMapping(" /checkStock")
    public String checkStock(@RequestParam Integer bookId){
        for (InventoryBook i :inventoryBooks){

        }
    }
}
