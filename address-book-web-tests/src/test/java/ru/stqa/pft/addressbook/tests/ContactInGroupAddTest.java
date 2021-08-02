package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactInGroupAddTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
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
    }
    @Test
    public void testContactAdding() {
        app.goTo().homepage();
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        ContactData contact = before.iterator().next();
        app.contact().addTo(groups.withAdded(group).iterator().next(), contact.inGroup(group).getId());
        Contacts after = app.db().contacts();

        //assertThat(after.iterator().next().inGroup(group), equalTo(before.iterator().next().inGroup(group)));
    }

}
