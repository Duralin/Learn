package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

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
    WebElement table = wd.findElement(By.id("maintable"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));
    for (int i = 0; i<rows.size(); i++) {
      WebElement row = rows.get(i);
      List<WebElement> cols1 = row.findElements(By.cssSelector("td:nth-child(2)"));
      List<WebElement> cols2 = row.findElements(By.cssSelector("td:nth-child(3)"));
      List<WebElement> cols3 = row.findElements(By.tagName("input"));
      for(int j = 0; j < cols1.size(); j++){
        WebElement col = cols1.get(j);
        WebElement col2 = cols2.get(j);
        WebElement col3 = cols3.get(j);
        String firstname = col.getText();
        String secondname = col2.getText();
        String id = col3.getAttribute("value");
        ContactData contact = new ContactData(id, secondname, firstname, null);
        contacts.add(contact);
      }
    }
    return contacts;
  }
}
