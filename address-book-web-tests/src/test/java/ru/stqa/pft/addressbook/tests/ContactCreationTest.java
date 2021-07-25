package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().contactSet();
    ContactData contact = new ContactData("Ivan", null, "Maksimovich");
    app.contact().create(contact);
    app.goTo().homepage();
    Set<ContactData> after = app.contact().contactSet();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
