/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Member;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author peter
 */
public class MemberDTO {
    
    private String userName;
    private String passWord;

    public MemberDTO(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public MemberDTO(Member member) {
        this.userName = member.getUserName();
        this.passWord = member.getPassWord();
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
    
    
    
    
    
}
