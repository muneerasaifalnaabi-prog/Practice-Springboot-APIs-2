package com.example.tr.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private static List<Author> authorList=new ArrayList<>();
    private static List<Book> bookList =new ArrayList<>();

    @GetMapping("/add-author")
public String addAuthor(@RequestParam Integer id ,@RequestParam String name,@RequestParam String biography){
    Author author = new Author(id,name,biography);
    authorList.add(author);
    return "Author added successfully";

}

public


}
