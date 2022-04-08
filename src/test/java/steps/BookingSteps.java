package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BookingSteps {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User is on searching page")
    public void userIsOnSearchingPage() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }
    @When("User click on search")
    public void userClickOnSearch() {
        driver.findElement(By.xpath("//input[@name='ss']")).click();
    }

    @And("User add {string} in search")
    public void userAddInSearch(String name) {
       driver.findElement(By.xpath("//input[@name='ss']")).sendKeys(name);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @And("click on search result")
    public void clickOnSearchResult(){
        driver.findElement(By.xpath("(//div[@data-testid='autocomplete-result']/..)[1]")).click();

    }
    @And("click Search button")
    public void clickSearchButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Hotel with name {string} displayed on page")
    public void hotelWithNameDisplayedOnPage(String nameResult) {
        String hotel = driver.findElement(By.xpath("//div[@data-testid='title']")).getText();
        Assert.assertEquals(hotel,nameResult);
    }
    @Then("Hotel score {string} displayed")
    public void hotelScoreDisplayed(String rateExpected) {

    }
    @After
    public void tearDown(){
        driver.quit();
    }





}
