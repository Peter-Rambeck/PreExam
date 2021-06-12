/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.BookDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author peter
 */
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int isbn;
    private String title;
    private String authors;
    private String publisher;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private String publishYear;
    
     @OneToMany(
        mappedBy = "book",
        cascade = CascadeType.PERSIST
    )
     private List<Loan> loans; 
     
     @OneToMany(
        mappedBy = "book",
        cascade = CascadeType.PERSIST
    )
     private List<Reservation> reservations; 
    
    @ManyToOne(optional = true)
    private Library library;

    public Book(int isbn, String title, String authors, String publisher, String publishYear) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }
    
     public Book(BookDTO bookDTO) {
        this.id = bookDTO.getId();
        this.isbn = bookDTO.getIsbn();
        this.title = bookDTO.getTitle();
        this.authors = bookDTO.getAuthors();
        this.publisher = bookDTO.getAuthors();
        this.publishYear = bookDTO.getPublisher();
    }

    public Book() {
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher + ", publishYear=" + publishYear + ", library=" + library + '}';
    }
    
    
    
    
}
