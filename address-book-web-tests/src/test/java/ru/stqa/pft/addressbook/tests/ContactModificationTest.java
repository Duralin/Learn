package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (! app.getContactHelper().isThereAnElement()){
            app.getContactHelper().createAContact(new ContactData("Ivan", null, "Maksimovich"));
        }
    }

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomepage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().modificateContact();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(),"Ivan", null, "Maksimovich");
        app.getContactHelper().contactModification(contact);
        app.getNavigationHelper().gotoHomepage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
