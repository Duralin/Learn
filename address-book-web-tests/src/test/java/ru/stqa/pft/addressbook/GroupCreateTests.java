package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreateTests {
  private WebDriver webDriver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    webDriver = new FirefoxDriver();
    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    webDriver.get("http://localhost/addressbook/");
    webDriver.findElement(By.name("user")).click();
    webDriver.findElement(By.name("user")).click();
    webDriver.findElement(By.name("user")).sendKeys(username);
    webDriver.findElement(By.name("pass")).click();
    webDriver.findElement(By.name("pass")).sendKeys(password);
    webDriver.findElement(By.id("LoginForm")).click();
    webDriver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

  private void returnToGroupPage() {
    webDriver.findElement(By.linkText("group page")).click();
  }

  private void submitGroupCreation() {
    webDriver.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupData groupData) {
    webDriver.findElement(By.name("group_name")).click();
    webDriver.findElement(By.name("group_name")).clear();
    webDriver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    webDriver.findElement(By.name("group_header")).click();
    webDriver.findElement(By.name("group_header")).clear();
    webDriver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    webDriver.findElement(By.name("group_footer")).click();
    webDriver.findElement(By.name("group_footer")).clear();
    webDriver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation() {
    webDriver.findElement(By.name("new")).click();
  }

  private void gotoGroupPage() {
    webDriver.findElement(By.linkText("groups")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    webDriver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      webDriver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      webDriver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
