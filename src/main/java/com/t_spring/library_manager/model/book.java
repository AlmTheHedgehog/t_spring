package com.t_spring.library_manager.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private LocalDate publishDate;
    private String publisher;
    private String ISBN;

    public book(){
        
    }
    public book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.publisher = "N/A";
        this.ISBN = "N/A";
    }
    public book(String title, String author, LocalDate publishDate, String publisher, String ISBN) {
        this(title, author, publishDate);
        System.out.println("yeah");
        if(!publisher.isEmpty()){
            this.publisher = publisher;
        }
        if(!ISBN.isEmpty()){
            this.ISBN = ISBN;
        }
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public String convAuthorLowerCase() {
        //make invisible for repositiry getAll
        return author.toLowerCase();
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public int getPublishYear() {
        return publishDate.getYear();
    }
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getISBN() {
        return ISBN;
    }
    public long convISBNlong() {
        //make invisible for repositiry getAll
        String longISBNstring = "";
        for(char symbol:ISBN.toCharArray()){
            if((symbol >= 48) && (symbol <= 57)){
                longISBNstring = longISBNstring + symbol;
            }
        }
        return Long.parseLong(longISBNstring);
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    @Override
    public String toString() {
        return "book [ISBN=" + ISBN + ", author=" + author + ", id=" + id + ", publishDate=" + publishDate
                + ", publisher=" + publisher + ", title=" + title + "]";
    }
    
}
