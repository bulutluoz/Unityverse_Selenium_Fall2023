package tests.day09_screenshot_JsExecutor_TestNG;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edin

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // rapora eklenmek uzere sonuc yazisinin fotografini cekin

        // 1.adim : fotografini cekmek istediginiz webelementi locate edin
        //          biz zaten sonuc yazi elementini locate etmistik

        // 2.adim : fotografi kaydedecegimiz dosyayi olusturun

        File sonucYazisiFotografi = new File("target/screenshots/sonucYazisi.jpg");

        // 3.adim : webelementi kullanarak screenshot olusturun ve
        //          gecici bir dosyaya kaydedin

        File geciciDosya = sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,sonucYazisiFotografi);

    }
}
