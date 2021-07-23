package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        int before = app.getContactHelper().elementsCount();
        if (! app.getContactHelper().isThereAnElement()){
            app.getContactHelper().createAContact(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
            before++;
        }
        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().modificateContact();
        app.getContactHelper().fillContactField(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomepage();
        int after = app.getContactHelper().elementsCount();
        Assert.assertEquals(after, before);
    }
}
