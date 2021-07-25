package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.List;
import java.util.Set;


public class ContactDeleteTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homepage();
    if (! app.contact().isEmpty()){
      app.contact().create(new ContactData("Ivan", null, "Maksimovich"));
    }
  }

  @Test
  public void testContactDeleteClass() throws Exception {
    app.goTo().homepage();
    Set<ContactData> before = app.contact().contactSet();
    ContactData deletedContact = before.iterator().next();
    app.contact().deletion(deletedContact);
    app.goTo().homepage();
    Set<ContactData> after = app.contact().contactSet();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}
