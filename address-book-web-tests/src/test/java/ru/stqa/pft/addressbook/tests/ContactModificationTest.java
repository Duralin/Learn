package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereAnElement()){
            app.getContactHelper().createAContact(new ContactData("Ivan", "Maksimovich", null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().modificateContact();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Ivan", "Maksimovich", null);
        app.getContactHelper().fillContactField(contact);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomepage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
