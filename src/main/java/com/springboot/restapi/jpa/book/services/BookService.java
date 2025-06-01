package com.springboot.restapi.jpa.book.services;


import com.springboot.restapi.jpa.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    private static List<Book> bookList = new ArrayList<>();

//    @Autowired
//    private Book book;

    static {
        bookList.add(new Book(1010, "Java Complete Reference", "Herbert Shield"));
        bookList.add(new Book(2020, "Head First Java", "Kathy Sierra"));
        bookList.add(new Book(3030, "Spring Book", "Rod Johnson"));
        bookList.add(new Book(4040, "Think Java", "Allen Downey"));
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        for (Book s : bookList) {
            if (id == s.getId()) {
                return s;
            }
        } return null;
    }

    public Book updateBookById(Book book, int bId){
        for(Book s:bookList){
            if (bId == s.getId()){
                s.setTitle(book.getTitle());
                s.setAuthor(book.getAuthor());
                System.out.println("Title & Author name updated for id = " + bId);
                return s;
            }
        } return null;
    }

    public Book deleteBook(int bookId) {
        for(Book s: bookList) {
            if (bookId == s.getId()) {
                bookList.remove(s);
                System.out.println("Book has been deleted: " + s);
                return s;
            }
        } return null;
    }

    public Book addBook(Book b){
        bookList.add(b);
        System.out.println("new book has been added: " + b);
        return b;
    }
}

