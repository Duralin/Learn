package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.TestBase;


public class ContactDeleteClass extends TestBase {


  @Test
  public void testContactDeleteClass() throws Exception {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAcceptMethod();
  }
}
