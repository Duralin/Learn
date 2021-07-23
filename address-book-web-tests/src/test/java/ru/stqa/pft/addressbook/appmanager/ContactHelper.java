package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
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
    String firstname = null;
    String secondname = null;
    List<ContactData> contacts = new ArrayList<ContactData>();
    WebElement table = wd.findElement(By.id("maintable"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));
    for (WebElement row : rows) {
      List<WebElement> cols1 = row.findElements(By.cssSelector("td:nth-child(2)"));
      for (WebElement col : cols1) {
        firstname = String.valueOf(col);
      }
      List<WebElement> cols2 = row.findElements(By.cssSelector("td:nth-child(3)"));
      for (WebElement col : cols2) {
        secondname = String.valueOf(col);
      }
      ContactData contact = new ContactData(firstname, secondname, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
