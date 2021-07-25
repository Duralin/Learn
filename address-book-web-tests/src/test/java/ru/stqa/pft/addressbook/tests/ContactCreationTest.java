package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().getContactList();
    ContactData contact = new ContactData("Ivan", null, "Maksimovich");
    app.contact().create(contact);
    app.goTo().homepage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
