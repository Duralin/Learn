package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String company;
    private final String homephone;
    private final String mobilephone;
    private final String workphone;
    private final String email;
    private final String title;
    private final String website;
    private final String birthday;
    private final String birthmounth;
    private final String birthyear;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String homephone, String mobilephone, String workphone, String email, String title, String website, String birthday, String birthmounth, String birthyear) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.email = email;
        this.title = title;
        this.website = website;
        this.birthday = birthday;
        this.birthmounth = birthmounth;
        this.birthyear = birthyear;
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

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBirthmounth() {
        return birthmounth;
    }

    public String getBirthyear() {
        return birthyear;
    }
}
