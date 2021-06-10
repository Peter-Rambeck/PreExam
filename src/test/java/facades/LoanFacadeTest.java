/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.loan.LoanDTO;
import entities.book.Book;
import entities.loan.Loan;
import java.util.Date;
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
public class LoanFacadeTest { 
    
    private static EntityManagerFactory emf;
    private static LoanFacade facade;

    private Loan loan1;
    private Loan loan2;

    public LoanFacadeTest() {
    }

    @BeforeEach
    public void setUp() {

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = LoanFacade.getFacadeLoan(emf);

        EntityManager em = emf.createEntityManager();

    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetFacadeLoan() {
//        System.out.println("getFacadeLoan");
//        EntityManagerFactory _emf = null;
//        LoanFacade expResult = null;
//        LoanFacade result = LoanFacade.getFacadeLoan(_emf);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateLoan() {
        System.out.println("createLoan");
        
       Date checkoutDate = new Date(01/01/2021);
       Date dueDate = new Date((2020/11/18));
       Date returnedDate = new Date((2020/11/18));
       
       loan1 = new Loan( new java.util.Date(System.currentTimeMillis()),  new java.util.Date(System.currentTimeMillis()),  new java.util.Date(System.currentTimeMillis()));
        
       LoanDTO hejsa = facade.createLoan(new LoanDTO(loan1));
        System.out.println(hejsa);
       
//        LoanDTO loanDTO = null;
//        LoanFacade instance = null;
//        LoanDTO expResult = null;
//        LoanDTO result = instance.createLoan(loanDTO);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }
    
}
