package com.itkedu.service;

import java.awt.print.Pageable;

import org.springframework.stereotype.Service;

import com.itkedu.reposirtory.BookRepository;
import com.itkedu.exception.ResourceNotFoundException;
import com.itkedu.model.Book;
import org.springframework.data.domain.Page;

@Service
public class BookService {

	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Page<Book> getAllBooks(org.springframework.data.domain.Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new  ResourceNotFoundException("Book not found with id " + id));
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book){

        Book existing = getBookById(id);

        existing.setTitle(book.getTitle());
        existing.setGenre(book.getGenre());
        existing.setPrice(book.getPrice());
        existing.setAuthor(book.getAuthor());

        return bookRepository.save(existing);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
