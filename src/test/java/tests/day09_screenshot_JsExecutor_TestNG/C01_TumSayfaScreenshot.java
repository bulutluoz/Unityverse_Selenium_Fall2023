package tests.day09_screenshot_JsExecutor_TestNG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_TumSayfaScreenshot extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin ve screenshot alin
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.tumSayfaFotografCek(driver,"amazon");
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        // urun isminin Nutella icerdigini test edin ve screenshot alin

        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik));
        ReusableMethods.tumSayfaFotografCek(driver,"ilkUrun");
    }
}
