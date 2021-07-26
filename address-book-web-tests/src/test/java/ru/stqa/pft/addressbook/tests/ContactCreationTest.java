package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.TestBase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Maksimovich");
    app.contact().create(contact);
    app.goTo().homepage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
