package org.aston.aqa.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        WebElement goToBasketButton = driver.findElement(By.xpath("//a[@class='btn-base j-go-to-basket']"));
        goToBasketButton.click();
    }
//Какой-то треш получился, я не понял как мне элементы передавать
    public void verifyProductInCart(String productName, int quantity, double price) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By productNameLocator = By.xpath("//a[@class='img-plug list-item__good-img j-product-popup']");
        WebElement productNameElement = driver.findElement(productNameLocator);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productName = productNameElement.getAttribute("title");
        if (productName.equals("Пастила натуральная ассорти 0,8 кг ")) {
            System.out.println("Заголовок соответствует ожидаемому значению.");
        } else {
            System.out.println("Заголовок не соответствует ожидаемому значению.");
        }
        By spanLocator = By.xpath("//div[@class='b-top__count line']/span[contains(text(), 'Товары')]");
        WebElement spanElement = driver.findElement(spanLocator);
        String spanText = spanElement.getText();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(spanText);
        if (matcher.find()) {
            String quantityValue = matcher.group();
            System.out.println("Количество товаров: " + quantityValue);

        } else {
            System.out.println("Нет данных о количестве товаров");
        }
        By totalAmountLocator = By.xpath("//p[@class='b-top__total line']/span/span");

        WebElement totalAmountElement = driver.findElement(totalAmountLocator);

        String totalAmountText = totalAmountElement.getText();
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher2 = pattern2.matcher(totalAmountText);
        if (matcher2.find()) {
            String totalAmountValue = matcher2.group();
            System.out.println("Итоговая стоимость: " + totalAmountValue + " ₽");
        } else {
            System.out.println("Нет данных об итоговой стоимости");
        }
    }

    public void proceedToCheckout() {
        WebElement orderButton = driver.findElement(By.cssSelector(".j-btn-confirm-order"));
        orderButton.click();
    }
}
