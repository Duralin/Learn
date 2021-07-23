package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

public class GroupDeleteTest extends TestBase {

  @Test
  public void testGroupDeleteClass() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().elementsCount();
    if (! app.getGroupHelper().isThereAnElement()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
      before++;
    }
    app.getGroupHelper().selectElement(before - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().elementsCount();
    Assert.assertEquals(after, before - 1);
  }
}
