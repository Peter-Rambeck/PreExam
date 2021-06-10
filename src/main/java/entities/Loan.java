/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.loan;

import entities.book.Book;
import entities.library.Library;
import entities.member.Member;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author peter
 */
@Entity
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkoutDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dueDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnedDate;
    
    
    @ManyToOne(optional = true)
    private Book book;
    
    @ManyToOne(optional = true)
    private Member member;

    public Loan(Date checkoutDate, Date dueDate, Date returnedDate) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    public Loan() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
