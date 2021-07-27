package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/profile.png");
    ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Maksimovich").withHomePhone("123").wihtMobilePhone("123").withWorkPhone("123")
            .withPhoto(photo);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
