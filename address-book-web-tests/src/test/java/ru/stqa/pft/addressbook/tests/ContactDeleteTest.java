package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;


public class ContactDeleteTest extends TestBase {


  @Test
  public void testContactDeleteClass() throws Exception {
    int before = app.getContactHelper().elementsCount();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createAContact(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
      before++;
    }
    app.getNavigationHelper().gotoHomepage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAcceptMethod();
    app.getNavigationHelper().gotoHomepage();
    int after = app.getContactHelper().elementsCount();
    Assert.assertEquals(after, before - 1);
  }
}
