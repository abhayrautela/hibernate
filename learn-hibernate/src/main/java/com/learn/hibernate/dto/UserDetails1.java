package com.learn.hibernate.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_DETAILS3")
public class UserDetails1 {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID")
    )
    @GenericGenerator(name = "sequence", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "sequence", type = @Type(type = "long"))
    private List<Address> listOfAddresses = new ArrayList<Address>();

    public List<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(List<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDetails1{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", listOfAddresses=" + listOfAddresses +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
