import io.github.bonigarcia.wdm.WebDriverManager;
import org.aston.aqa.wildberries.CartPage;
import org.aston.aqa.wildberries.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WildberriesTest {

    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://www.wildberries.ru/");
    }

    @Test
    public void testAddingToCartAndCheckout() {
        homePage.addToCartByArticle("35650072");
        cartPage.open();
       cartPage.verifyProductInCart("Пастила натуральная ассорти 0,8 кг ", 1, 349);
       cartPage.proceedToCheckout();


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
