package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.TestBase;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homepage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Maksimovich"));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().homepage();
        Contacts before = app.contact().all();
        app.contact().modifButtonClick();
        ContactData modyfiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modyfiedContact.getId()).withFirstname("Ivan").withLastname("Maksimovich");
        app.contact().modification(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modyfiedContact).withAdded(contact)));
    }


}
