import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreCartPage extends PageObject {
    public PreCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hlb-view-cart-announce")
    private WebElement viewCart;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void clickViewCart(){
        this.wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        this.viewCart.click();
    }
}
