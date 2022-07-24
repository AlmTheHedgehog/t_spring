package com.t_spring.library_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t_spring.library_manager.model.book;

@Repository
public interface BookRepository extends JpaRepository<book, Long> {
    
}
