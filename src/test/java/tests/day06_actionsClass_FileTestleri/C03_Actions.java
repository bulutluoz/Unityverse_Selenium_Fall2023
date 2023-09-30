package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void amazonTesti() throws InterruptedException {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountsElementi = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));

        actions.moveToElement(accountsElementi).perform();

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']"))
                .click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElementi= driver.findElement(By.xpath("//*[@*='my-lists-tab']"));

        Assert.assertTrue(yourListElementi.isDisplayed());

        Thread.sleep(5000);
    }
}
