package com.t_spring.library_manager.controller;

import java.util.Comparator;
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
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class bookController {
    @Autowired
    private BookRepository bookRepository;
    
    /**
     * @param author - filtering by 1 author(show all books if field is empty)
     * @param typeOfSorting - sorting specified method(down sort by id if field is empty)
     * <ul>
     *      <li>{@code DownByYear} - sorts from the oldest to the newest book</li>
     *      <li>{@code UpByYear} - sorts from the newest to the oldest book</li>
     *      <li>{@code DownByTitle} - sorts by title from A ot Z</li>
     *      <li>{@code UpByTitle} - sorts by title from Z ot A</li>
     *      <li>{@code DownByAuthor} - sorts by author from A ot Z</li>
     *      <li>{@code UpByAuthor} - sorts by author from Z ot A</li>
     *      <li>{@code DownByPublisher} - sorts by publisher from A ot Z</li>
     *      <li>{@code UpByPublisher} - sorts by publisher from Z ot A</li>
     *      <li>{@code DownByISBN} - sorts by ISBN from the smallest ot the biggest</li>
     *      <li>{@code UpByISBN} - sorts by ISBN from the biggest ot the smallest</li>
     * </ul> 
     * @return List of books which can be sorted and filtered according to parameters
     */
    @GetMapping("/books")
    public List<book> getAllBooks(@RequestParam(name = "author", defaultValue="") String author,
                                @RequestParam(name = "sorting", defaultValue="") String typeOfSorting){
        List<book> BooksList;
        if(author.isEmpty()){
            BooksList = bookRepository.findAll();
        }else{
            BooksList =  bookRepository.findAllByAuthor(author);
        }

        if(typeOfSorting.isEmpty()){
            return BooksList;
        }else{
            return SortingController.sort(BooksList, typeOfSorting);
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
