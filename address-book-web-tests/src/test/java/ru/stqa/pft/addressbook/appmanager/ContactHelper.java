package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.tests.ContactData;

public class ContactHelper extends HelperBase {
      private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactInfo() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactField(ContactData contactData) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("middlename"), contactData.getMiddlename());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("nickname"), contactData.getNickname());
      type(By.name("company"), contactData.getCompany());
      type(By.name("home"), contactData.getHomephone());
      type(By.name("mobile"), contactData.getMobilephone());
      type(By.name("work"), contactData.getWorkphone());
      type(By.name("email"), contactData.getEmail());
      type(By.name("title"), contactData.getTitle());
      type(By.name("homepage"), contactData.getHomephone());
    }

    public void deleteContact() {
      click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
      click(By.name("selected[]"));
    }

    public void alertAcceptMethod() {
      alertAcceptMeth();
    }

    public void modificateContact() {
      click(By.xpath("//img[@alt='Edit']"));
    }
    public void updateContact() {
      click(By.xpath("//div[@id='content']/form/input[22]"));
  }
}
