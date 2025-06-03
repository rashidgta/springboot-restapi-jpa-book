package com.springboot.restapi.jpa.book.dao;

import com.springboot.restapi.jpa.book.entities.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> {
}
