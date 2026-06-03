package com.example.tr.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {
    private static List<Author> authorList = new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();

    @GetMapping("/addAuthor")
    public String addAuthor(@RequestParam Integer id, @RequestParam String name, @RequestParam String biography) {
        Author author = new Author(id, name, biography);
        authorList.add(author);
        return "Author added successfully";

    }

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors() {
        return authorList;
    }

    @GetMapping("/addRelationalBook")
    public String addRelationalBook(@RequestParam int id, @RequestParam String name, @RequestParam int authorId) {
        boolean authorExists = false;

        for (Author a : authorList) {
            if (a.getId() == authorId) {
                authorExists = true;
                break;
            }
        }
        if (authorExists) {
            Book book = new Book(id, name, authorId);
            bookList.add(book);
            return "Book added Successfully";
        } else {
            return "Author id does not exits";
        }
    }

    @GetMapping("/authorReport")
    public String authorReport(@RequestParam String authorName) {
        Author foundAuthor = null;

        for (Author a : authorList) {
            if (a.getName().equalsIgnoreCase(authorName)) {
                foundAuthor = a;
                break;
            }
        }
        if (foundAuthor == null) {
            return "Author not found";
        }
        StringBuilder booksWritten = new StringBuilder();

        for (Book book : bookList) {

            if (book.getAuthorId() == foundAuthor.getId()) {

                if (booksWritten.length() > 0) {
                    booksWritten.append(", ");
                }

                booksWritten.append(book.getName());
            }
        }

        if (booksWritten.length() == 0) {
            booksWritten.append("None");
        }

        return "Author ID: " + foundAuthor.getId()
                + "\nName: " + foundAuthor.getName()
                + "\nBiography: " + foundAuthor.getBiography()
                + "\nBooks Written: " + booksWritten;
    }
}

