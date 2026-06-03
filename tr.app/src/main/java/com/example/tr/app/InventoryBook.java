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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }
}
