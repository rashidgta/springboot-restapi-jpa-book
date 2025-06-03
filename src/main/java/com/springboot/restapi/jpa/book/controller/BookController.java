package com.springboot.restapi.jpa.book.controller;


import com.springboot.restapi.jpa.book.entities.Book;
import com.springboot.restapi.jpa.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book b) {
        Book book = bookService.addBook(b);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PostMapping("/books/saveAll")
    public ResponseEntity<List<Book>> addAllBooks(@RequestBody List<Book> list) {
        List<Book> list1 = bookService.addAllBook(list);
        if (list1.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list1);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List <Book> list1 = bookService.getAllBooks();
        if(list1.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list1));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable ("id") int id) {
        Book book1 = bookService.getBookById(id);
        if(book1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book1));
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBooks(@RequestBody Book book, @PathVariable ("bookId") int bookId) {
        Book book1 = bookService.updateBookById(book, bookId);
        if(book1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book1));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBooks(@PathVariable ("bookId")  int bookId) {
        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.ok().build();
        } catch (FindException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}



