import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsPage extends PageObject {

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "productTitle")
    private WebElement productName;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement dropDown;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public String storeProductName(){
        this.wait.until(ExpectedConditions.visibilityOf(productName));
        return this.productName.getText();
    }

    public void selectDropDown(String value){
        this.dropDown.click();
        Select dropDownValue = new Select(dropDown);
        dropDownValue.selectByValue(value);
    }

    public void clickAddToCart(){
        this.addToCartButton.click();
    }
}
