package ru.stqa.pft.addressbook.tests;

import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        Contacts contacts = app.db().contacts();
        if (contacts.size() == 0){
            app.goTo().homepage();
            app.contact().create(new ContactData().withFirstname("Ivan").withLastname("Maksimovich")
                    .withHomePhone("123").wihtMobilePhone("123")
                    .withWorkPhone("123").withMiddlename("chel")
                    .withEmail("@mail").withAddress("address"));
        }
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            app.goTo().homepage();
        }
        boolean isGroupConsistContact = false;
        for(ContactData contact : contacts){
            if (contact.getGroups().size() != 0){
                isGroupConsistContact = true;
            }
        }
        if (!isGroupConsistContact){
            Groups groups = app.db().groups();
            app.goTo().homepage();
            Contacts before = app.db().contacts();
            ContactData contact = before.iterator().next();
            app.contact().addTo((groups.withAdded(groups.iterator().next()).iterator().next()), contact.inGroup(groups.iterator().next()).getId());
        }
        app.goTo().homepage();
    }
    @Test
    public void testContactDeleteFromGroup(){
        app.goTo().homepage();
        ContactData contactFromDb = new ContactData();
        Contacts before = app.db().contacts();
        app.goTo().homepage();
        for(ContactData contact : before){
            if(contact.getGroups().size() > 0){
                contactFromDb = contact;
            }
        }
        app.contact().deleteFrom(contactFromDb.getGroups().iterator().next(), contactFromDb);
        Contacts after = app.db().contacts();

        //assertThat(after.iterator().next(), equalTo(before));
    }
}
