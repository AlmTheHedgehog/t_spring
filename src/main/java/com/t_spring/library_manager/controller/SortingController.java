package com.t_spring.library_manager.controller;

import java.util.Comparator;
import java.util.List;

import com.t_spring.library_manager.model.book;

public class SortingController {

    public enum SortingTypes {
        DownByYear("DownByYear"),
        UpByYear("UpByYear");
    
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

        return BooksList;
    }
}
