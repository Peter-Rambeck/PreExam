/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Loan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public class LoanDTO {

    private Date checkoutDate;
    private Date dueDate;
    private Date returnedDate;

    public LoanDTO(Date checkoutDate, Date dueDate, Date returnedDate) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }
    
    public LoanDTO(Loan loan) {
        this.checkoutDate = loan.getCheckoutDate();
        this.dueDate = loan.getDueDate();
        this.returnedDate = loan.getReturnedDate();
    }

    public static List<LoanDTO> getAllLoanDtoes(List<Loan> allLoans) {
        List<LoanDTO> allLoansDTO = new ArrayList<>();
        allLoans.forEach(loan -> allLoansDTO.add(new LoanDTO(loan)));
        return allLoansDTO;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
    
    
    


}
