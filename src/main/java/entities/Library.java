/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.BookDTO;
import entities.Role;
import entities.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Library.deleteAllRows", query = "DELETE from Library")
})
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "library",
            cascade = CascadeType.PERSIST
    )
    private List<Book> books;

    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
            book.setLibrary(this);
        } else {
            throw new WebApplicationException();
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    public static List<Book> getAllBooks(List<BookDTO> allBooks) {
//        List<Book> books = new ArrayList<>();
//        allBooks.forEach(book -> books.add(new Book(book)));
//        return books;
//    }

    public Library(String name) {
        this.name = name;
    }

    public Library() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
