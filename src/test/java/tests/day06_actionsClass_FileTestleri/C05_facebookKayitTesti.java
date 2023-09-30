package tests.day06_actionsClass_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class C05_facebookKayitTesti extends TestBase {

    @Test
    public void kayitTesti() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies kabul edin
        driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))
                .click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutuElementi = driver.findElement(By.xpath("//*[@placeholder='First name']"));

        Actions actions= new Actions(driver);
        Faker faker= new Faker();
        String emailAdresi= faker.internet().emailAddress();

        actions.click(isimKutuElementi)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Sep")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        //5- Kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

        Thread.sleep(7000);
    }
}
