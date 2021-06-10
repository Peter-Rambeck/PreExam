/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.member;

import entities.loan.Loan;
import entities.reservation.Reservation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author peter
 */
@Entity
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name", length = 25)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pass")
    private String passWord;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.PERSIST
    )
    private List<Loan> loans;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.PERSIST
    )
    private List<Reservation> reservations;

    public Member(String userName, String passWord) {
        this.userName = userName;
        this.passWord = BCrypt.hashpw(passWord, BCrypt.gensalt());
    }

    public Member() {
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
