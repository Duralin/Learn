package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contacts().size() == 0){
            Groups groups = app.db().groups();
            app.goTo().homepage();
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Maksimovich")
                    .withHomePhone("123").wihtMobilePhone("123")
                    .withWorkPhone("123").withMiddlename("chel")
                    .withEmail("@mail").withAddress("address").inGroup(groups.iterator().next()));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().homepage();
        Contacts before = app.db().contacts();
        ContactData modyfiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modyfiedContact.getId()).withFirstname("Ivan").withLastname("Maksimovich")
                .withHomePhone("123").wihtMobilePhone("123")
                .withWorkPhone("123").withMiddlename("chel")
                .withEmail("@mail").withAddress("address");
        app.contact().modification(contact);
        Groups groups = app.db().groups();
        app.contact().addTo((groups.withAdded(groups.iterator().next()).iterator().next()), modyfiedContact.getId());
        assertThat(app.contact().elementsCount(), equalTo(before.size()));
    }
}
