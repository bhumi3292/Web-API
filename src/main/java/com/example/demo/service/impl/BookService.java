package com.example.demo.service.impl;

import com.example.demo.entity2.Book;
import com.example.demo.pojo.BookPojo;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void saveData(BookPojo bookPojo);

    void saveBook(BookPojo bookPojo);

    List<Book> getAllBooks();

    void deleteBook(Long id);

    Optional<Book> getBookById(Long id);

    void updateBook(Long id, BookPojo bookPojo);
}
