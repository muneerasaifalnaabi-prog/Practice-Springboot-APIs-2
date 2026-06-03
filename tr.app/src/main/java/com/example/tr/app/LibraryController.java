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

    @GetMapping("/addAuthor")
public String addAuthor(@RequestParam Integer id ,@RequestParam String name,@RequestParam String biography){
    Author author = new Author(id,name,biography);
    authorList.add(author);
    return "Author added successfully";

}
@GetMapping("/allAuthors")
public List<Author> authorList(){
        return authorList;
}
@GetMapping("/addRelationalbBook")
public String addRelationalBook(@RequestParam int id, @RequestParam String name, @RequestParam int authorId) {
    boolean authorExists = false;

    for (Author a :authorList){
        if(a.getId()==authorId){
            authorExists=true;
            break;
        }
    }
    if (authorExists){
        Book book = new Book(id,name,authorId);
        bookList.add(book);
    }

}



}
