package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().elementsCount();
    app.getContactHelper().createAContact(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
    app.getNavigationHelper().gotoHomepage();
    int after = app.getContactHelper().elementsCount();
    Assert.assertEquals(after, before + 1);
  }
}
