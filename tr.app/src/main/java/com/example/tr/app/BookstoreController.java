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
        InventoryBook inventoryBook = new InventoryBook(id, title, price, stock);
        inventoryBooks.add(inventoryBook);

        return " Booke added successfully to catalog ";
    }

    @GetMapping("/checkStock")
    public String checkStock(@RequestParam Integer id) {
        for (InventoryBook i : inventoryBooks) {
            if (i.getBookId() == id) {
                if (i.getStockCount() > 0) {
                    return "Available Book : " + i.getTitle() + " Price : " + i.getPrice();
                } else {
                    return "Sorry, " + i.getTitle() + " is currently sold out .. :(";
                }
            }

        }
        return "Sorry ,the BookStore does not carry this title";
    }

    @GetMapping("/report")
    public String stockReport(@RequestParam Integer stockThreshold) {
        String report = "";

        for (InventoryBook book : inventoryBooks) {
            if (book.getStockCount() <= stockThreshold) {
                report += "Title :" + book.getTitle() + "|  Stock : " + book.getStockCount();
            }
        }
        if (report.equals("")) {

            return "No book need recording ";
        }
        return report;
    }

}
