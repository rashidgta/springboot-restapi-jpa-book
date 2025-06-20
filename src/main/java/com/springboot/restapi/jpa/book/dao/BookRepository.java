package com.springboot.restapi.jpa.book.dao;

import com.springboot.restapi.jpa.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
