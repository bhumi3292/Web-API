package com.example.demo.controller;

import com.example.demo.entity2.Book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.service.impl.BookService;
import com.example.demo.shared.pojo.GlobalApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public GlobalApiResponse<List<Book>> getAllBooks() {
        return GlobalApiResponse
                .<List<Book>>builder()
                .data(bookService.getAllBooks())
                .statusCode(200)
                .message("Data retrieved successfully")
                .build();
    }

    @PostMapping
    public GlobalApiResponse<String> saveBook(@RequestBody @Valid BookPojo bookPojo) {
        bookService.saveBook(bookPojo);
        return GlobalApiResponse
                .<String>builder()
                .data("saved")
                .statusCode(200)
                .message("Data saved successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateBook(@PathVariable Long id, @RequestBody BookPojo bookPojo) {
        bookService.updateBook(id, bookPojo);
        return GlobalApiResponse
                .<String>builder()
                .data("updated")
                .statusCode(200)
                .message("Data updated successfully")
                .build();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return GlobalApiResponse
                .<String>builder()
                .data("deleted")
                .statusCode(200)
                .message("Data deleted successfully")
                .build();
    }
}