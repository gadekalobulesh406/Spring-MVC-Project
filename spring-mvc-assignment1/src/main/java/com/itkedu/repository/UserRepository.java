package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
