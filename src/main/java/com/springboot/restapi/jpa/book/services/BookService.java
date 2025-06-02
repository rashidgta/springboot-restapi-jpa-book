package com.springboot.restapi.jpa.book.services;


import com.springboot.restapi.jpa.book.dao.BookRepository;
import com.springboot.restapi.jpa.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> addAllBook(List<Book> list) {
        List<Book> list1 = (List<Book>) bookRepository.saveAll(list);
        return list1;
    }

    public List<Book> getAllBooks() {
        List<Book> list1 = (List<Book>) bookRepository.findAll();
        return list1;
    }

    public Book getBookById(int id) {
        Optional<Book> book1 = bookRepository.findById(id);
        return book1.orElse(null);
    }

    public Book updateBookById(Book book, int bId) {
        if (bId == book.getId()) {
            return bookRepository.save(book);
            }
        return null;
    }

    public void deleteBook(int bookId) {
        Optional<Book> findBook = bookRepository.findById(bookId);
        if (findBook.isEmpty()) {
            throw new FindException("Book ID not found in DB");
        }
        bookRepository.deleteById(bookId);
    }
}

