package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homepage();
        if (! app.contact().isEmpty()){
            app.contact().create(new ContactData("Ivan", null, "Maksimovich"));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().homepage();
        Set<ContactData> before = app.contact().contactSet();
        app.contact().modifButtonClick();
        ContactData modyfiedContact = before.iterator().next();
        ContactData contact = new ContactData(modyfiedContact.getId(),"Ivan", null, "Maksimovich");
        app.contact().modification(contact);
        app.goTo().homepage();
        Set<ContactData> after = app.contact().contactSet();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modyfiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
