import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;

public class test_QA {

    private WebDriver driver;
    String baseUrl = "https://lab.uk.qateam.eu/wp-login.php";
    String validUsename = "admin";
    String validPass = "Test1234";
    String expectedURL = "https://lab.uk.qateam.eu/wp-admin/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "..\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void LoginValid() {



        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys(validUsename);

        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys(validPass);

        WebElement loginButton = driver.findElement(By.name("wp-submit"));
        loginButton.click();

        assertEquals(
                expectedURL,
                driver.getCurrentUrl()
        );

        WebElement displayName = driver.findElement(By.className("display-name"));

        assertEquals(
                validUsename,
                displayName.getText()
        );
    }

    @Test
    public void another_test() {
        driver.get(baseUrl);
        assertEquals(
                baseUrl,
                driver.getCurrentUrl()
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
