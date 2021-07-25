package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;


    public ContactData(String firstname, String middlename, String lastname) {
        this.id = 0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;

    }

    public ContactData(int id, String firstname, String middlename, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;

    }
    public ContactData withId(int id){
        this.id = id;
        return this;
    }
    public ContactData withFirstname(String firstname){
        this.firstname = firstname;
        return this;
    }
    public ContactData withLastname(String lastname){
        this.lastname= lastname;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}
