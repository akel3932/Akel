package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    public AmazonHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement serarchButton;

    public void search(String searchText){
        searchBox.sendKeys(searchText);
        serarchButton.click();

    }


}
