package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.List;


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
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 1;
    app.contact().deletion(index);
    app.goTo().homepage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
