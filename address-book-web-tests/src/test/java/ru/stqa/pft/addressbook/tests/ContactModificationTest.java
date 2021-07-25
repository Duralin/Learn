package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homepage();
        if (app.contact().contactSet().size() == 0){
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Maksimovich"));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().homepage();
        Set<ContactData> before = app.contact().contactSet();
        app.contact().modifButtonClick();
        ContactData modyfiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modyfiedContact.getId()).withFirstname("Ivan").withLastname("Maksimovich");
        app.contact().modification(contact);
        app.goTo().homepage();
        Set<ContactData> after = app.contact().contactSet();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modyfiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
