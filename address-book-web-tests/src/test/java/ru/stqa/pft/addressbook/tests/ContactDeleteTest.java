package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.List;


public class ContactDeleteTest extends TestBase {


  @Test
  public void testContactDeleteClass() throws Exception {
    if (! app.getContactHelper().isThereAnElement()){
      app.getContactHelper().createAContact(new ContactData("Ivan", "Ivanov", "Maksimovich"));
    }
    app.getNavigationHelper().gotoHomepage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectElement(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAcceptMethod();
    app.getNavigationHelper().gotoHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
