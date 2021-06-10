/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.book;

import entities.book.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peter
 */
public class BookDTO {

    private Long id;
    private int isbn;
    private String title;
    private String authors;
    private String publisher;
    private String publishYear;

    public BookDTO(int isbn, String title, String authors, String publisher, String publishYear) {
        
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
        this.publishYear = book.getPublishYear();
    }

    public static List<BookDTO> getAllBookDtoes(List<Book> allBooks) {
        List<BookDTO> allBooksDTO = new ArrayList<>();
        allBooks.forEach(book -> allBooksDTO.add(new BookDTO(book)));
        return allBooksDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "id=" + id + ", isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher + ", publishYear=" + publishYear + '}';
    }
    
    

}
