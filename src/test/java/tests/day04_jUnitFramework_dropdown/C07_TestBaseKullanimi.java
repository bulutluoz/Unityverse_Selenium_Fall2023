package tests.day04_jUnitFramework_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_TestBaseKullanimi extends TestBase{

    /*
        extends keyword
        icinde oldugumuz C07 class'ini
        TestBase class'inin child class'i yapar
        Bu sayede C07 class'indan TestBase class'indaki
        tum variable ve method'lari DIREK kullanabiliriz
         (static keyword'e dikkat etmek gerekir)
     */

    @Test
    public void amazonTest(){

        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonuclarinin Nutella icerdigini test edin
        WebElement sonucElementi = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']"));
        String  actualSonucYazisi = sonucElementi.getText();

        String expectedIcerik ="Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
}
