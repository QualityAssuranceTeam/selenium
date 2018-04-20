import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart extends PageObject {
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']")
    private WebElement cartProductName;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public String storeCartProductName(){
        this.wait.until(ExpectedConditions.elementToBeClickable(cartProductName));
        return this.cartProductName.getText();
    }
}
