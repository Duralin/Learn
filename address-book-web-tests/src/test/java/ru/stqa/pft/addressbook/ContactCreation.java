package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreation {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  private void login() {
    driver.get("http://localhost/addressbook/group.php");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.xpath("//form[@id='LoginForm']/label[2]")).click();
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    fillContactField(new ContactData("Ivan", "Ivanov", "Maksimovich", "imaks", "spacegroup", "152135", "152136", "152437", "katalonec@mail.ru", "have no foto", "railway.com", "27", "September", "1999"));
    returnToContactInfo();
  }

  private void returnToContactInfo() {
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactField(ContactData contactData) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    driver.findElement(By.name("company")).click();
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contactData.getHomephone());
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contactData.getMobilephone());
    driver.findElement(By.name("work")).click();
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contactData.getWorkphone());
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
    driver.findElement(By.name("homepage")).click();
    driver.findElement(By.name("homepage")).clear();
    driver.findElement(By.name("homepage")).sendKeys(contactData.getWebsite());
    driver.findElement(By.name("bday")).click();
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthday());
    driver.findElement(By.xpath("//option[@value='27']")).click();
    driver.findElement(By.name("bmonth")).click();
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthmounth());
    driver.findElement(By.xpath("//option[@value='September']")).click();
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(contactData.getBirthyear());
  }

  private void gotoContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  
}
