package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KlavyeActions extends TestBase {

    @Test
    public void actionsTest() throws InterruptedException {
        //1- Bir Class olusturalim KeyboardActions1
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin
        Actions actions = new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71").perform();

        //   ve Enter’a basarak arama yaptirin

            aramaKutusu.sendKeys(Keys.ENTER);
        //4- aramanin gerceklestigini test edin

        WebElement sonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik = "Samsung A71";
        String actualYazi = sonucElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedIcerik));
        Thread.sleep(5000);
    }
}
