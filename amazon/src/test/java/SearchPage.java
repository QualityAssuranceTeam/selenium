import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageObject {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()[contains(.,'Departments')] and @class='a-expander-prompt']")
    private WebElement expandDepartments;

    @FindBy(xpath = "//h4[text()='Toys & Games']")
    private WebElement linkToysGames;

    @FindBy(id = "low-price")
    private WebElement minPrice;

    @FindBy(id = "high-price")
    private WebElement maxPrice;

    @FindBy(xpath = "//span[text()='14 Years & Up']")
    private WebElement ageRange;

    @FindBy(id = "result_0")
    private WebElement firstResult;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void enterSearchTerm(String searchTerm){
        this.searchField.clear();
        this.searchField.sendKeys(searchTerm);
        this.searchField.sendKeys(Keys.ENTER);
    }

    public void clickDepartments(){
        this.expandDepartments.click();
    }

    public void clickToysAndGames(){
        this.linkToysGames.click();
    }

    public void setMinMaxPrice(String setMinPrice, String setMaxPrice){
        this.wait.until(ExpectedConditions.elementToBeClickable(minPrice));
        this.minPrice.sendKeys(setMinPrice);
        this.maxPrice.sendKeys(setMaxPrice);
        this.maxPrice.sendKeys(Keys.ENTER);
    }

    public void selectAgeRange(){
        this.ageRange.click();
    }

    public void selectFirstProduct(){
        this.wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        this.firstResult.click();
    }

}
