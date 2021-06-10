/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.book.BookDTO;
import entities.book.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author peter
 */
public class BookFacade {

    private static EntityManagerFactory emf;
    private static BookFacade instance;

    private BookFacade() {
    }

    public static BookFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookFacade();
        }
        return instance;
    }

    public BookDTO createBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();
        Book book = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthors(), bookDTO.getPublisher(), bookDTO.getPublishYear());

        try {
            em.getTransaction().begin();
            // em.find isbn == null 

            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException("Book already exist");
        } finally {
            em.close();
        }
        return new BookDTO(book);
    }

    public BookDTO editBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();
        Book book = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthors(), bookDTO.getPublisher(), bookDTO.getPublishYear());

        try {
            Book olBook = (Book) em
                    .createQuery("SELECT b FROM book WHERE b.isbn = :isbn")
                    .setParameter("isbn", bookDTO.getIsbn())
                    .getSingleResult();
            
            System.out.println(olBook);
            
                    } catch (Exception e) {
            throw new WebApplicationException("Book doesn not exist");
        } finally {
            em.close();
        }
        return new BookDTO(book);
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

}
