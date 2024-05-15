package com.example.demo.service.impl;

import com.example.demo.entity2.Book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(BookPojo bookPojo) {
        Book book = new Book();
        book.setId(bookPojo.getId());
        book.setBookName(bookPojo.getBookName());

        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(Long id, BookPojo bookPojo) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book -> {
            book.setBookName(bookPojo.getBookName());
            bookRepository.save(book);
        });
    }
}