package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void iniContactCreation(){
      click(By.linkText("add new"));
    }
    public void deleteContact() {
      click(By.xpath("//input[@value='Delete']"));
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

    public void createAContact(ContactData contactData) {
      iniContactCreation();
      fillContactField(contactData);
      returnToContactInfo();
    }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    WebElement firstnameCell = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[2]"));
    WebElement secondnameCell = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[3]"));
    String name = firstnameCell.getText();
    String secondName = secondnameCell.getText();
    ContactData contact = new ContactData(name, secondName, null, null, null, null, null, null, null, null, null, null, null, null);
    contacts.add(contact);
    return contacts;
  }
}
