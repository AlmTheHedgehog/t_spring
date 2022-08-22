package com.t_spring.library_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t_spring.library_manager.exeption.ResourceNotFoundExeption;
import com.t_spring.library_manager.model.book;
import com.t_spring.library_manager.repository.BookRepository;

@CrossOrigin(origins = "https://library-online-t.herokuapp.com")
@RestController
@RequestMapping("/api/v1/")
public class bookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<book> getAllBooks(@RequestParam(name = "author", defaultValue="") String author){
        if(author.isEmpty()){
            return bookRepository.findAll();
        }else{
            return bookRepository.findAllByAuthor(author);
        }
    }

    @PostMapping("/books")
    public book createBook(@RequestBody book newBook){
        return bookRepository.save(newBook);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<book> getBookById(@PathVariable long id){
        book findBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Book with id:" + id + "doesn`t exist"));
        return ResponseEntity.ok(findBook);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<book> updateBook(@PathVariable long id, @RequestBody book BookInfo){
        book findBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Book with id:" + id + "doesn`t exist"));
        findBook.setAuthor(BookInfo.getAuthor());
        findBook.setISBN(BookInfo.getISBN());
        findBook.setPublishDate(BookInfo.getPublishDate());
        findBook.setPublisher(BookInfo.getPublisher());
        findBook.setTitle(BookInfo.getTitle());
        book updatedBook = bookRepository.save(findBook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable(value = "id") Long bookId) {
        bookRepository.deleteById(bookId);
        return ResponseEntity.ok(bookId);
    }

}
