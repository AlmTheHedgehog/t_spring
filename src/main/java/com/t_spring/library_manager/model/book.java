package com.t_spring.library_manager.model;

import java.io.Console;
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
    private long id;
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDate getPublishDate() {
        return publishDate;
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
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    @Override
    public String toString() {
        return "book [ISBN=" + ISBN + ", author=" + author + ", id=" + id + ", publishDate=" + publishDate
                + ", publisher=" + publisher + ", title=" + title + "]";
    }
    
}
