package org.neuedu.ch大练习_jdbc;

import java.util.Date;

public class SignInfo {
    private Long id;
    private Long uid;
    private Date signIn;
    private Date signOut;

    @Override
    public String toString() {
        return "SignInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", signIn=" + signIn +
                ", signOut=" + signOut +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getSignIn() {
        return signIn;
    }

    public void setSignIn(Date signIn) {
        this.signIn = signIn;
    }

    public Date getSignOut() {
        return signOut;
    }

    public void setSignOut(Date signOut) {
        this.signOut = signOut;
    }
}