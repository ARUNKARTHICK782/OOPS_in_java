package Inheritance.ContactBook;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String phNo;
    private String email;
    private boolean isBlocked;

    public Contact(String name, String phNo, String email) {
        this.name = name;
        this.phNo = phNo;
        this.email = email;
        this.isBlocked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "\nName : " + name+" PhNo : " + phNo + " Email : " + email + '\n';
    }
}
