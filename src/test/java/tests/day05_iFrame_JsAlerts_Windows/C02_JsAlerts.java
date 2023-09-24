package tests.day05_iFrame_JsAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsAlerts extends TestBase {
    //1. Test

    @Test
    public void test01() throws InterruptedException {
        //	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
        Thread.sleep(2000);
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualAlertYazi);
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
    //2.Test

    @Test
    public void test02() throws InterruptedException {
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();
        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }
    //3.Test
    @Test
    public void test03() throws InterruptedException {
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(5000);
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonucicerik = "Abdullah";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Thread.sleep(5000);
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucicerik));
    }


}
