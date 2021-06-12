/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Book;
import entities.Library;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author peter
 */
public class LibraryDTO {

   
    private String name;
    private List<Book> books;
 
    public LibraryDTO(String name) {
        this.name = name;
    }

    public LibraryDTO(Library library) {
        this.name = library.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    
    

}
