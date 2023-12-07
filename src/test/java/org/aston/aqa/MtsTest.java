package org.aston.aqa;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;


public class MtsTest
{
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by/");
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//div[contains(@class, 'pay__wrapper')]/h2"));
        assertEquals("Онлайн пополнение\n" +
                "без комиссии", blockTitle.getText());
    }

    @Test
    public void testPaymentSystemLogos() {
        java.util.List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        assertTrue(logos.size() > 0);
    }

    @Test
    public void testServiceDetailsLink() {
        //у меня возникли проблемы с этим методом, я использовал ExpectedConditions.visibilityOfElementLocated но оно не видело 'cookie show'
        //не по названию класса не по xPath,  я нашел в интернете js executor, который игнорирует это. Не знаю правильно ли это?
        WebElement detailsLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", detailsLink);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void testContinueButton() {

        WebElement optionElement = driver.findElement(By.xpath("//option[@value='Услуги связи']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", optionElement);
        optionElement.click();
        WebDriverWait formWait = new WebDriverWait(driver, 10);
        formWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='pay-connection']")));
        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumInput.sendKeys("100");
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='connection-email']"));
        emailInput.sendKeys("test@example.com");
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        continueButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
