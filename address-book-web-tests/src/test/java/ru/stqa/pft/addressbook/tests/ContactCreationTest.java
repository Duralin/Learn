package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createAContact(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
    app.getNavigationHelper().gotoHomepage();
  }
}
