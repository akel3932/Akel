package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;

public class AmazonStepDefs {
    WebDriver driver; //instance variable
    AmazonHomePage amazonHomePage;
    AmazonSearchResultPage amazonSearchResultPage;

    @When("I navigated to Amazon home page")
    public void i_navigated_to_amazon_home_page() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");

    }

    @When("I search for iPhone 13 case")
    public void i_search_for_i_phone_case() {
        amazonHomePage= new AmazonHomePage(driver);
        amazonHomePage.search("iphone 13 case");

        WebElement amazonSearchBar= driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBar.sendKeys("iphone 13 case");
        WebElement searchButton= driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        /*
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.search("iphone 13 case");
         */

    }

    @Then("I should get more than {int} results")
    public void i_should_get_more_than_results(Integer resultCount) {
        amazonSearchResultPage= new AmazonSearchResultPage(driver);

       // List<WebElement> resultLinks=driver.findElements(By.tagName("a"));
        Assert.assertTrue(amazonSearchResultPage.getResultCount()>resultCount);



    }

    @Then("I validate the search result number")
    public void i_validate_the_search_result_number() {
        WebElement quantityResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] resultArray= quantityResult.getText().split(" ");
        String resultNum= resultArray[3].replace(",","");
        int results = Integer.parseInt(resultNum);

        Assert.assertEquals(results,20000);

    }



}
