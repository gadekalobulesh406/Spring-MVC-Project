package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.Book;
public interface BookRepository extends JpaRepository<Book, Long> {

}
