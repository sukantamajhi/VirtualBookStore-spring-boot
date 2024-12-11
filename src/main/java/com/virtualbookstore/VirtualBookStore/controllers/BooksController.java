package com.virtualbookstore.VirtualBookStore.controllers;

import com.virtualbookstore.VirtualBookStore.config.ApiResponse;
import com.virtualbookstore.VirtualBookStore.models.Book;
import com.virtualbookstore.VirtualBookStore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books", produces = "application/json")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    // Register book
    @PostMapping("")
    public ResponseEntity<ApiResponse<Book>> create(@RequestBody Book book) {
        ApiResponse<Book> bookApiResponse = bookService.create(book);

        if (bookApiResponse.isError()) {
            return new ResponseEntity<>(bookApiResponse, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(bookApiResponse, HttpStatus.OK);
        }
    }

    // Get all books

    @GetMapping("")
    public ResponseEntity<ApiResponse<Iterable<Book>>> getAllBooks() {
        ApiResponse<Iterable<Book>> bookApiResponse = bookService.getAllBooks();

        if (bookApiResponse.isError()) {
            return new ResponseEntity<>(bookApiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(bookApiResponse, HttpStatus.OK);
        }
    }

    // Get a particular book based on title or description or author

    // Update a book

    // Delete book from server

    // Delete book permanently

}