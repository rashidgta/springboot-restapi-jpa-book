package com.springboot.restapi.jpa.book.controller;


import com.springboot.restapi.jpa.book.entities.Book;
import com.springboot.restapi.jpa.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List <Book> list = bookService.getAllBooks();
        if(list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable ("id") int id) {
        Book book = bookService.getBookById(id);
        if(book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBooks(@RequestBody Book book, @PathVariable ("bookId") int bookId) {
        Book b = bookService.updateBookById(book, bookId);
        if(b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/books")
    public Book addBooks(@RequestBody Book b) {
        return this.bookService.addBook(b);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBooks(@PathVariable ("bookId")  int bookId) {
        Book b = bookService.deleteBook(bookId);
        if(b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

}



