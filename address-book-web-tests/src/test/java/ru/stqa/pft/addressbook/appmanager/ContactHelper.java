package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("home"), contactData.getHomePhone());
      type(By.name("mobile"), contactData.getMobilePhone());
      type(By.name("work"), contactData.getWorkPhone());
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

    public void modifButtonClick() {
      click(By.xpath("//img[@alt='Edit']"));
    }
    public void updateContact() {
      click(By.xpath("//div[@id='content']/form/input[22]"));
  }

    public void returnToHomepage(){
      {
        if (isElementPresent(By.id("maintable"))) {
          return;
        }
        click(By.linkText("home"));
      }
    }

    public void create(ContactData contactData) {
      iniContactCreation();
      fillContactField(contactData);
      contactCache = null;
      returnToContactInfo();
      returnToHomepage();
    }

    public void modification(ContactData contact) {
      fillContactField(contact);
      updateContact();
      contactCache = null;
      returnToHomepage();
    }

    public void deletion(ContactData contact) {
      selectContactById(contact.getId());
      deleteContact();
      alertAcceptMethod();
      contactCache = null;
      returnToHomepage();
    }

    private Contacts contactCache = null;
    public Contacts all() {
      if (contactCache != null){
        return new Contacts(contactCache);
      }
      contactCache = new Contacts();
      WebElement table = wd.findElement(By.id("maintable"));
      List<WebElement> rows = table.findElements(By.tagName("tr"));
      for (int i = 0; i<rows.size(); i++) {
        WebElement row = rows.get(i);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        List<WebElement> cols1 = row.findElements(By.cssSelector("td:nth-child(2)"));
        List<WebElement> cols2 = row.findElements(By.cssSelector("td:nth-child(3)"));
        List<WebElement> cols3 = row.findElements(By.tagName("input"));
        List<WebElement> cols4 = row.findElements(By.cssSelector("td:nth-child(4)"));
        List<WebElement> cols5 = row.findElements(By.cssSelector("td:nth-child(5)"));
        for(int j = 0; j < cols1.size(); j++){
          WebElement col = cols1.get(j);
          WebElement col2 = cols2.get(j);
          WebElement col3 = cols3.get(j);
          WebElement col4 = cols4.get(j);
          WebElement col5 = cols5.get(j);
          String lastname = col.getText();
          String firstname = col2.getText();
          String address = col4.getText();
          String email = col5.getText();
          String[] phones = cells.get(5).getText().split("\n");
          String homePhone = phones[0];
          String mobilPhone = phones[1];
          String workPhone = phones[2];
          int id = Integer.parseInt(col3.getAttribute("value"));
          contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withHomePhone(homePhone)
                  .wihtMobilePhone(mobilPhone).withWorkPhone(workPhone).withAddress(address).withEmail(email));
        }
      }
      return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact){
      initContactModificationById(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String homePhone = wd.findElement(By.name("home")).getAttribute("value");
      String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
      String workPhone = wd.findElement(By.name("work")).getAttribute("value");
      String email = wd.findElement(By.name("email")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      returnToHomepage();
      return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(homePhone)
              .wihtMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail(email).withAddress(address);
    }

    public void initContactModificationById(int id){
      wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }
}
