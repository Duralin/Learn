package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contact().getContactList();
        app.contact().modificateContact();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(),"Ivan", null, "Maksimovich");
        app.contact().contactModification(contact);
        app.goTo().homepage();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
