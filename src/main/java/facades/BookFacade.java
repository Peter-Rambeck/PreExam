/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.BookDTO;
import entities.Book;
import entities.Library;
import java.util.List;
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
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new WebApplicationException("Book already exist");
        } finally {
            em.close();
        }
        return new BookDTO(book);
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

        int isbn = bookDTO.getIsbn();
        System.out.println("isbn: " + isbn);
        System.out.println("bookDTO: " + bookDTO);
        
        Book book = (Book) em
                .createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn")
                .setParameter("isbn", isbn)
                .getSingleResult();
       
       System.out.println("book 1: " + book);
       
        if (book == null) {
            throw new WebApplicationException("no book today!");
        }
        try {
            book = new Book(bookDTO);
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new WebApplicationException("Book doesn not exist " + bookDTO);
        } finally {
            em.close();
        }
        System.out.println("new Book: " + book);
         return new BookDTO(book);

    }

    public void deleteBook(BookDTO bookDTO) {

        EntityManager em = emf.createEntityManager();
        String name = "bogormen";
        int isbn = bookDTO.getIsbn();

        try {

            Book book = (Book) em
                    .createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn")
                    .setParameter("isbn", isbn)
                    .getSingleResult();

//            Library library = (Library) em
//                    .createQuery("SELECT l FROM Library l WHERE l.name = :name")
//                    .setParameter("name", name)
//                    .getSingleResult();

            em.getTransaction().begin();

            // library.getBooks().remove(book);
            em.remove(book);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new WebApplicationException(e.getMessage());
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

    public static void main(String[] args) {

    }

}
