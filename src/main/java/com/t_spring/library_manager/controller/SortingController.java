package com.t_spring.library_manager.controller;

import java.util.Comparator;
import java.util.List;

import com.t_spring.library_manager.model.book;

public class SortingController {
    
    public enum SortingTypes {
        DownByYear("DownByYear"),
        UpByYear("UpByYear"),
        DownByTitle("DownByTitle"),
        UpByTitle("UpByTitle"),
        DownByAuthor("DownByAuthor"),
        UpByAuthor("UpByAuthor"),
        DownByPublisher("DownByPublisher"),
        UpByPublisher("UpByPublisher"),
        DownByISBN("DownByISBN"),
        UpByISBN("UpByISBN");
    
        private String StringType;
    
        SortingTypes(String StringType) {
            this.StringType = StringType;
        }
    
        public String getString() {
            return StringType;
        }
    }    

    public static List<book> sort(List<book> BooksList, String TypeOfSorting){
        if(TypeOfSorting.equals(SortingTypes.DownByYear.getString())){
            BooksList.sort(Comparator.comparingInt(book::getPublishYear));
        }else if(TypeOfSorting.equals(SortingTypes.UpByYear.getString())){
            BooksList.sort(Comparator.comparingInt(book::getPublishYear).reversed());
        }
        else if(TypeOfSorting.equals(SortingTypes.DownByTitle.getString())){
            BooksList.sort(Comparator.comparing(book::getTitle));
        }else if(TypeOfSorting.equals(SortingTypes.UpByTitle.getString())){
            BooksList.sort(Comparator.comparing(book::getTitle).reversed());
        }
        else if(TypeOfSorting.equals(SortingTypes.DownByAuthor.getString())){
            BooksList.sort(Comparator.comparing(book::convAuthorLowerCase));
        }else if(TypeOfSorting.equals(SortingTypes.UpByAuthor.getString())){
            BooksList.sort(Comparator.comparing(book::convAuthorLowerCase).reversed());
        }
        else if(TypeOfSorting.equals(SortingTypes.DownByPublisher.getString())){
            BooksList.sort(Comparator.comparing(book::getPublisher));
        }else if(TypeOfSorting.equals(SortingTypes.UpByPublisher.getString())){
            BooksList.sort(Comparator.comparing(book::getPublisher).reversed());
        }
        else if(TypeOfSorting.equals(SortingTypes.DownByISBN.getString())){
            BooksList.sort(Comparator.comparingLong(book::convISBNlong));
        }else if(TypeOfSorting.equals(SortingTypes.UpByISBN.getString())){
            BooksList.sort(Comparator.comparingLong(book::convISBNlong).reversed());
        }

        return BooksList;
    }
}
