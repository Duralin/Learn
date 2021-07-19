package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactModificationClass extends TestBase {
    @Test
    public void testContactModification(){
        app.getContactHelper().modificateContact();
        app.getContactHelper().fillContactField(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
        app.getContactHelper().updateContact();
    }
}
