package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("Contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    private int id;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String middlename;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Transient
    private String allPhones;
    @Expose
    @Type(type = "text")
    private String email;
    @Expose
    @Type(type = "text")
    private String address;
    @Expose
    @Type(type = "text")
    private String photo;
    @Expose
    @Transient
    private String group;


    public ContactData withGroup(String group){
        this.group = group;
        return this;
    }
    public ContactData withAllPhone(String allPhone){
        this.allPhones = allPhone;
        return this;
    }
    public ContactData withHomePhone(String homePhone){
        this.homePhone = homePhone;
        return this;
    }
    public ContactData wihtMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }
    public ContactData withWorkPhone(String workPhone){
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withEmail(String email){
        this.email = email;
        return this;
    }
    public ContactData withAddress(String address){
        this.address = address;
        return this;
    }
    public ContactData withId(int id){
        this.id = id;
        return this;
    }
    public ContactData withFirstname(String firstname){
        this.firstname = firstname;
        return this;
    }
    public ContactData withMiddlename(String middlename){
        this.middlename = middlename;
        return this;
    }
    public ContactData withLastname(String lastname){
        this.lastname= lastname;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public int getId() {
        return id;
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
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
