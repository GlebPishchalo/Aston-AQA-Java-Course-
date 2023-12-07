package org.aston.aqa;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.assertEquals;


public class MtsTest {
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
        WebElement closeButton = cookiePopup.findElement(By.className("cookie__close"));
        closeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cookie")));
        WebElement optionElement = driver.findElement(By.xpath("//option[@value='Услуги связи']"));
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
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
        WebElement amountLabel = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        String displayedAmount = amountLabel.getText();
        assertEquals("100.00 BYN", displayedAmount);

        WebElement paymentInfo = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        String displayedPaymentInfo = paymentInfo.getText();
        assertTrue(displayedPaymentInfo.contains("Оплата: Услуги связи Номер:375297777777"));
        WebElement cardNumber = driver.findElement(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        String displayedcardNumber = cardNumber.getText();
        assertTrue(displayedcardNumber.contains("Номер карты"));
        WebElement dateOfCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        String displayedDateOfCard = dateOfCard.getText();
        assertTrue(displayedDateOfCard.contains("Срок действия"));
        WebElement cvcNumber = driver.findElement(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        String displayedcvcNumber = cvcNumber.getText();
        assertTrue(displayedcvcNumber.contains("CVC"));
        WebElement nameCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        String displayednameCard = nameCard.getText();
        assertTrue(displayednameCard.contains("Имя держателя (как на карте)"));

        java.util.List<WebElement> logos = driver.findElements(By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c53-0 ng-trigger ng-trigger-brandsState ng-star-inserted']//img"));
        assertTrue(logos.size() > 0);


    }

    @Test
    public void testDomashniyInternet() {
        WebElement selectElement = driver.findElement(By.id("pay"));
        Select select = new Select(selectElement);
        select.selectByValue("Домашний интернет");
        WebElement internetPhoneInput = driver.findElement(By.id("internet-phone"));
        WebElement internetSumInput = driver.findElement(By.id("internet-sum"));
        WebElement internetEmailInput = driver.findElement(By.id("internet-email"));
        Assert.assertEquals(internetPhoneInput.getAttribute("placeholder"), "Номер абонента");
        Assert.assertEquals(internetSumInput.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(internetEmailInput.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test
    public void testRassrochka() {
        WebElement selectElement = driver.findElement(By.id("pay"));
        Select select = new Select(selectElement);
        select.selectByValue("Рассрочка");
        WebElement internetPhoneInput = driver.findElement(By.id("score-instalment"));
        WebElement internetSumInput = driver.findElement(By.id("instalment-sum"));
        WebElement internetEmailInput = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals(internetPhoneInput.getAttribute("placeholder"), "Номер счета на 44");
        Assert.assertEquals(internetSumInput.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(internetEmailInput.getAttribute("placeholder"), "E-mail для отправки чека");


    }

    @Test
    public void testZadolzhenost() {
        WebElement selectElement = driver.findElement(By.id("pay"));
        Select select = new Select(selectElement);
        select.selectByValue("Задолженность");
        WebElement internetPhoneInput = driver.findElement(By.id("score-arrears"));
        WebElement internetSumInput = driver.findElement(By.id("arrears-sum"));
        WebElement internetEmailInput = driver.findElement(By.id("arrears-email"));
        Assert.assertEquals(internetPhoneInput.getAttribute("placeholder"), "Номер счета на 2073");
        Assert.assertEquals(internetSumInput.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(internetEmailInput.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
