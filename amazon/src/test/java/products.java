import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class products {

    private WebDriver driver;
    String baseUrl = "https://www.amazon.com/";

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "..\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void addToCart() {

        driver.get(baseUrl);
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.clear();
        searchField.sendKeys("Harry Potter");
        searchField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement expandDepartments = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//span[text()[contains(.,'Departments')] and @class='a-expander-prompt']")));
        expandDepartments.click();
        WebElement linkToysGames = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//h4[text()='Toys & Games']")));
        linkToysGames.click();

        WebElement minPrice = wait.until(ExpectedConditions.elementToBeClickable(By.id("low-price")));
        minPrice.sendKeys("10");
        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys("150");
        maxPrice.sendKeys(Keys.ENTER);

        WebElement ageRange = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//span[text()='14 Years & Up']")));
        ageRange.click();

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.id("result_0")));
        firstResult.click();

        String productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle"))).getText();
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='quantity']"));
        dropDown.click();
        Select dropDownValue = new Select(dropDown);
        dropDownValue.selectByValue("4");
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement viewCart = driver.findElement(By.id("hlb-view-cart-announce"));
        viewCart.click();

        WebElement cartProductName = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")));

        assertEquals(
                cartProductName.getText(),
                productName
        );
    }

    @After
    public void tearDown() {

        driver.quit();

    }
}
