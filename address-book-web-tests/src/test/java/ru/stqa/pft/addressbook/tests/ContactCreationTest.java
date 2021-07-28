package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    File photo = new File("src/test/resources/profile.png");
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1])
      .withHomePhone(split[2]).withAddress(split[3]).withEmail(split[4]).withPhoto(photo)});
      line = reader.readLine();
    }
    return list.iterator();
  }
  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
