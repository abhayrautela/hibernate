package com.learn.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER_DETAILS2")
public class UserDetailsGetterAccess {

    private int userId;
    private String userName;
    private String userMail;

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Column(name = "USER_MAIL")
    public String getUserMail() {
        return userMail + " from getter";
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
