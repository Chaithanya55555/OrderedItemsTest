package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class orderedItemsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaorderitems.ccbp.tech/");
        List<WebElement> items = driver.findElements(By.cssSelector("li.ordered-item"));
        if (items.size() == 3 ){
            System.out.println("Ordered item count is correct");
        }else {
            System.out.println("Ordered item count is incorrect");
        }
        List < WebElement> cancel = driver.findElements(By.cssSelector("button[id *= 'button']"));
        for (WebElement item: cancel){
            item.click();
        }
        WebElement text = driver.findElement(By.cssSelector("p.text-secondary"));
        String currentText = text.getText();
        String expectedText = "Cart is empty";
        if (currentText.equals(expectedText)){
            System.out.println("Empty Cart Text Displayed");
        }else {
            System.out.println("Empty Cart Text Missing");
        }
        driver.quit();
    }
}
