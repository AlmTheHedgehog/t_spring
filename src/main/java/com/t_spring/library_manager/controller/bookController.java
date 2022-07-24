package com.t_spring.library_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t_spring.library_manager.model.book;
import com.t_spring.library_manager.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class bookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<book> getAllBooks(){
        return bookRepository.findAll();
    }
}
