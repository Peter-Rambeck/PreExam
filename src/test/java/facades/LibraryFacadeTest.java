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
public class LibraryFacadeTest {

    private static EntityManagerFactory emf;
    private static LibraryFacade facade;

    public LibraryFacadeTest() {
    }

    @BeforeEach
    public void setUp() {

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = LibraryFacade.getLibraryFacade(emf);

        EntityManager em = emf.createEntityManager();

        Book book1 = new Book(1, "Java", "nogen", "Politikken", "2021");
        Book book2 = new Book(2, "Java", "nogen", "Politikken", "2021");
        Book book3 = new Book(3, "Java", "nogen", "Politikken", "2021");
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
    }

   
    @Test
        public void testAddBook() {
        
        BookDTO bookDTO = new BookDTO(1, "Java", "nogen", "Politikken", "2021");
        facade.addBook(bookDTO);
        assertEquals(1, bookDTO.getIsbn());
    }
//        System.out.println("addBook");
//        BookDTO bookDTO = null;
//        LibraryFacade instance = null;
//        instance.addBook(bookDTO);
//        fail("The test case is a prototype.");
    }
