package ru.stqa.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeleteTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homepage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Maksimovich"));
    }
  }

  @Test
  public void testContactDeleteClass() throws Exception {
    app.goTo().homepage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().deletion(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
