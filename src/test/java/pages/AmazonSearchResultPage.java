package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchResultPage {
    public AmazonSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(tagName = "a")
    private List<WebElement> resultLinks;

    public int getResultCount(){
        return resultLinks.size();
    }


}
