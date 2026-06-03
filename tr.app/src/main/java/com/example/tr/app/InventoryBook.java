package com.example.tr.app;

public class InventoryBook {
    private Integer bookId;
    private String title;
    private double price;
    private  Integer stockCount;

    public InventoryBook(Integer bookId, String title, double price, Integer stockCount) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.stockCount = stockCount;
    }

}
