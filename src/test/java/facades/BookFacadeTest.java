/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.BookDTO;
import entities.Role;
import entities.User;
import entities.Book;
import entities.Library;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author peter
 */
public class BookFacadeTest {

    private static EntityManagerFactory emf;
    private static BookFacade facade;
    
    Book book1;
    Book book2;
    Book book3;
     Book book;

    
    public BookFacadeTest() {
    }

    @BeforeEach
    public void setUp() {

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = BookFacade.getBookFacade(emf);

        EntityManager em = emf.createEntityManager();
       
        book1 = new Book(1, "Java1", "nogen", "Politikken", "2021");
        book2 = new Book(2, "Java2", "nogen", "Politikken", "2021");
        book3 = new Book(3, "Java3", "nogen", "Politikken", "2021");
        Library library = new Library("bogormen");

        try {
            em.getTransaction().begin();
            em.persist(library);
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

    @AfterEach
    public void tearDown() {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Book.deleteAllRows").executeUpdate();
            em.createNamedQuery("Library.deleteAllRows").executeUpdate();
         
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
//       

    }
        
        
        
    

    @Test
    public void testGetBookFacade() {
//        System.out.println("getBookFacade");
//        EntityManagerFactory _emf = null;
//        BookFacade expResult = null;
//        BookFacade result = BookFacade.getBookFacade(_emf);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateBook() {
      
        book = new Book(1432, "Hobbit", "JR", "Politikken", "1800");
        BookDTO bookDTO = new BookDTO(book);

        BookDTO x = facade.createBook(bookDTO);
        assertEquals(1432, x.getIsbn());

//        BookDTO bookDTO = null;
//        BookFacade instance = null;
//        BookDTO expResult = null;
//        BookDTO result = instance.createBook(bookDTO);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testEditBook() {
        
        
        
        book = new Book(2, "Smølferne", "JR", "Politikken", "1820");
        BookDTO bookDTO = new BookDTO(book);
        facade.editBook(bookDTO);
//        

        
    }

    @Test
    public void testDeleteBook() {
        
        BookDTO bookDTO = new BookDTO(book2);
        facade.deleteBook(bookDTO);

        
    }
    
    @Test
    public void testGetAllBooks() {
        facade.getAllBooks();
    }

}
