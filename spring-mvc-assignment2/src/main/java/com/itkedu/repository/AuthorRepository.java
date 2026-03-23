package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
