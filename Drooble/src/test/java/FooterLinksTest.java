import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterLinksTest {

    private WebDriver driver;
    String baseUrl = "https://drooble.com";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "..\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        //Scroll to the bottom
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @Test
    public void aboutUs() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='About us']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

        //Verify landing URL
        assertEquals(
                baseUrl + "/drooble/about",
                driver.getCurrentUrl()
        );

        //Verify page title
        assertEquals(
                "Drooble Team",
                pageTitle.getText()
        );

    }

    @Test
    public void howItWorks() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='How It Works']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

        //Verify landing URL
        assertEquals(
                baseUrl + "/how-it-works",
                driver.getCurrentUrl()
        );

        //Verify page title
        assertEquals(
                "Where Musicians Unite",
                pageTitle.getText()
        );

    }

    @Test
    public void ourMission() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Our Mission']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Our Mission']")));

        //Verify landing URL
        assertEquals(
                baseUrl + "/our-mission",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void tour() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Tour']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/tour",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Tour",
                pageTitle.getText()
        );
    }

    @Test
    public void careers() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Careers']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/careers",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Why work at Drooble?",
                pageTitle.getText()
        );
    }

    @Test
    public void contactUs() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Contact us']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/drooble",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Drooble Team",
                pageTitle.getText()
        );
    }

    @Test
    public void press() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Press']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(handleTabs.get(1));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='About Drooble']")));

        //Verify landing URL
        assertEquals(
                "https://blog.drooble.com/press/",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void radio() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Radio']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/radio",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Get Your Music Heard on Drooble Radio",
                pageTitle.getText()
        );
    }

    @Test
    public void electronicPressKit() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Electronic Press Kit']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//h2[text()='Electronic Press Kit For Musicians']")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/electronic-press-kit",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void promotionTools() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Promotion tools']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/promotion",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Promote Your Music For Free",
                pageTitle.getText()
        );
    }

    @Test
    public void metronome() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Metronome']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/metronome",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Metronome",
                pageTitle.getText()
        );
    }

    @Test
    public void chromaticTuner() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Chromatic tuner']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//b[text()='Like this tuner']")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/tuner",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Like this tuner?",
                pageTitle.getText()
        );
    }

    @Test
    public void createAPage() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Create a Page']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Grow Your Fanbase']")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/create-band",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void facebook() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='facebook']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());

        driver.switchTo().window(handleTabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Drooble']")));

        //Verify landing URL
        assertEquals(
                "https://www.facebook.com/DroobleOfficial",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void youtube() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='YouTube']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());

        driver.switchTo().window(handleTabs.get(1));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//span[@id='channel-title']")));

        //Verify landing URL
        assertEquals(
                "https://www.youtube.com/user/DroobleTube",
                driver.getCurrentUrl()
        );
        //Verify page title
        assertEquals(
                "Drooble",
                pageTitle.getText()
        );

    }

    @Test
    public void twitter() {

        WebElement footerLink = driver.findElement(By.xpath("//a[text()='twitter']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());

        driver.switchTo().window(handleTabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Drooble.com']")));

        //Verify landing URL
        assertEquals(
                "https://twitter.com/drooble",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void appStore() {

        WebElement footerLink = driver.findElement(By.xpath("//img[@alt='Get it on AppStore']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(handleTabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

        //Verify landing URL
        assertEquals(
                "https://itunes.apple.com/us/app/id1112084581",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void googlePlay() {

        WebElement footerLink = driver.findElement(By.xpath("//img[@alt='Get it on Google Play']"));
        footerLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        ArrayList<String> handleTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(handleTabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

        //Verify landing URL
        assertEquals(
                "https://play.google.com/store/apps/details?id=com.drooble.happ",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void privacyPolicy() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Privacy Policy']")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/privacy-policy",
                driver.getCurrentUrl()
        );

    }

    @Test
    public void termsOfService() {
        WebElement footerLink = driver.findElement(By.xpath("//a[text()='Terms Of Service']"));
        footerLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Terms of Service']")));
        //Verify landing URL
        assertEquals(
                baseUrl + "/terms-of-service",
                driver.getCurrentUrl()
        );

    }

    @After
    public void tearDown() {

        driver.quit();

    }

}
