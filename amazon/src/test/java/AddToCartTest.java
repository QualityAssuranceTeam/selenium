import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddToCartTest extends FunctionalTest {

    String baseUrl = "https://www.amazon.com/";

    @Test
    public void addToCart(){

        driver.get(baseUrl);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchTerm("Harry Potter");
        searchPage.clickDepartments();
        searchPage.clickToysAndGames();
        searchPage.setMinMaxPrice("10","150");
        searchPage.selectAgeRange();
        searchPage.selectFirstProduct();

        DetailsPage detailsPage = new DetailsPage(driver);
        String selectedProductName = detailsPage.storeProductName();
        detailsPage.selectDropDown("4");
        detailsPage.clickAddToCart();

        PreCartPage preCartPage = new PreCartPage(driver);
        preCartPage.clickViewCart();

        ShoppingCart shoppingCart = new ShoppingCart(driver);

        assertEquals(
                selectedProductName,
                shoppingCart.storeCartProductName()
        );

    }

}
