package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KlavyeActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        Thread.sleep(1000);
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        // video iframe icinde oldugundan once o iframe'e gecis yapmaliyiz
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        Thread.sleep(1000);


        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        //5- videoyu calistirdiginizi test edin
        Thread.sleep(3000);
        WebElement kontrolLogo= driver.findElement(By.xpath("(//a[@aria-label='Watch on YouTube'])[2]"));
        Assert.assertTrue(kontrolLogo.isDisplayed());
        Thread.sleep(3000);
    }
}
