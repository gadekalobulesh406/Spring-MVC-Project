package com.itkedu.controller;

import com.itkedu.model.Book;
import com.itkedu.service.BookService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private  BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // GET all books with pagination & sorting

    @GetMapping
    public Page<Book> getAllBooks(Pageable pageable){
        return bookService.getAllBooks(pageable);
    }

    // GET book by id

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    // POST create book

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    // PUT update book

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book book){

        return ResponseEntity.ok(bookService.updateBook(id,book));
    }

    // DELETE book

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }

}
