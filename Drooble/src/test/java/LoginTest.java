import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    String baseUrl = "https://drooble.com/";
    String validUsername = "YOUR_USER_NAME";
    String validPassword = "YOUR_PASSWORD";
    String firstName = "Yuksel";
    String lastName = "Ahmedov";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "..\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void loginValid() {

        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Email address...']"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        //Verify landing URL
        assertEquals(
                baseUrl,
                driver.getCurrentUrl()
        );

        //Verify user name
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement displayName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + firstName + "']")));

        assertEquals(
                firstName + " " + lastName,
                displayName.getText()
        );
    }

    @After
    public void tearDown() {

        driver.quit();
    }

}
