package com.example.tr.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> books = new ArrayList<>();
    @GetMapping("/add-book")
    public String addBook(@RequestParam Integer id,@RequestParam String name){

       Book book = new Book(id,name);
       books.add(book);
       return "Books added successfully";

    }
    @GetMapping("/all-books")
    public List<Book> printBook(){
        return books;
    }

    @GetMapping("/find-by-name")
    public Book findByName(@RequestParam String name){
        for (Book b:books) {
            if (b.getName().equalsIgnoreCase(name)) {
                return b;
            }
        }
            return null;

        }
        @GetMapping("/search-msg")
        public String searchMsg(@RequestParam Integer id){


        }



}
