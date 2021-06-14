
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.BookDTO;
import dtos.LibraryDTO;
import entities.Book;
import entities.Library;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class LibraryFacade {

    private static EntityManagerFactory emf;
    private static LibraryFacade instance;

    LibraryFacade() {
    }

    public static LibraryFacade getLibraryFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LibraryFacade();
        }
        return instance;
    }

    public LibraryDTO getLibrary() {

        EntityManager em = emf.createEntityManager();
        Library library;
        try {
            library = (Library) em
                    .createQuery("SELECT l FROM Library l")
                    .getSingleResult();
        } catch (Exception e) {
            throw new WebApplicationException();
        } finally {
            em.close();
        }
        return new LibraryDTO(library);

    }

    public LibraryDTO addBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();
        int isbn = bookDTO.getIsbn();
        String name = "bogormen";
        
        System.out.println(bookDTO);

        try {

            Book book = (Book) em
                    .createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn")
                    .setParameter("isbn", isbn)
                    .getSingleResult();

            Library library = (Library) em
                    .createQuery("SELECT l FROM Library l WHERE l.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();

            em.getTransaction().begin();

            library.addBook(book);
            em.getTransaction().commit();
            // return new LibraryDTO(library);
        } catch (Exception e) {
            throw new WebApplicationException();
        } finally {
            em.close();
        }
        return new LibraryDTO(name);

    }

    public List<BookDTO> getAllBooks() {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
            return BookDTO.getAllBookDtoes(books);
        } catch (Exception e) {
            throw new WebApplicationException("No books today, sorry");
        } finally {
            em.close();
        }
    }

    public BookDTO editBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();
     

        try {
            Book olBook = (Book) em
                    .createQuery("SELECT b FROM b book WHERE b.isbn = :isbn")
                    .setParameter("isbn", bookDTO.getIsbn())
                    .getSingleResult();

              return new BookDTO(olBook);

        } catch (Exception e) {
            throw new WebApplicationException("Book doesn not exist");
        } finally {
            em.close();
        }
      
    }

    public void deleteBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();

        Book book = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthors(), bookDTO.getPublisher(), bookDTO.getPublishYear());

        try {
            book = (Book) em
                    .createQuery("DELETE b FROM book WHERE b.isbn = :isbn")
                    .setParameter("isbn", bookDTO.getIsbn())
                    .getSingleResult();

        } catch (Exception e) {
            throw new WebApplicationException("Book doesn not exist");
        } finally {
            em.close();
        }

    }

    public void populate() {

        EntityManager em = emf.createEntityManager();
        Book book1 = new Book(1, "Java", "nogen", "Politikken", "2021");
        Book book2 = new Book(2, "Java", "nogen", "Politikken", "2021");
        Book book3 = new Book(3, "Java", "nogen", "Politikken", "2021");

        try {
            em.getTransaction().begin();
            // em.find isbn == null 

            em.persist(book1);
            em.persist(book2);
            em.persist(book3);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException("noget gik galt");
        } finally {
            em.close();
        }

    }

}
