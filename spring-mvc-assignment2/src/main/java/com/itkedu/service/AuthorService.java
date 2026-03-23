package com.itkedu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itkedu.model.Author;
import com.itkedu.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}