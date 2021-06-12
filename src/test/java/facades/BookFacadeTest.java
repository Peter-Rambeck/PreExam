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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    private Book book1;
    private Book book2;

    public BookFacadeTest() {
    }

    @BeforeEach
    public void setUp() {

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = BookFacade.getBookFacade(emf);

        EntityManager em = emf.createEntityManager();

    }

    @AfterEach
    public void tearDown() {
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
        System.out.println("createBook");
        book1 = new Book(1234, "Hobbit", "JR", "Politikken", "1800");
        BookDTO bookDTO = new BookDTO(book1);

        BookDTO x = facade.createBook(bookDTO);
        assertEquals(1234, x.getIsbn());

//        BookDTO bookDTO = null;
//        BookFacade instance = null;
//        BookDTO expResult = null;
//        BookDTO result = instance.createBook(bookDTO);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testEditBook() {
        
//
//        book2 = new Book(1234, "Hobbiterne", "JR", "Politikken", "1820");
//        BookDTO bookDTO = new BookDTO(book2);
//
//        BookDTO x = facade.editBook(bookDTO);
//        assertEquals(1234, x.getIsbn());

//        BookDTO bookDTO = null;
//        BookFacade instance = null;
//        BookDTO expResult = null;
//        BookDTO result = instance.editBook(bookDTO);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteBook() {
//        System.out.println("deleteBook");
//
//        book1 = new Book(1234, "Hobbit", "JR", "Politikken", "1800");
//        BookDTO bookDTO = new BookDTO(book1);
//        facade.deleteBook(bookDTO);

//        BookDTO bookDTO = null;
//        BookFacade instance = null;
//        instance.deleteBook(bookDTO);
//        fail("The test case is a prototype.");
    }

}
