package tests.day08_webTables_excelOtomasyonu_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_TumSayfaScreenshot extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {

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

        // rapora eklenmek uzere tum sayfanin fotografini cekin

        // 1.adim obje olustur ve driver'i deger olarak ata
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosyayi hazirlayalim
        //   bunun icin olusturacagimiz dosyanin dosya yolunu hazirlamaliyiz
        File tumSayfaFotograf = new File("target/screenshots/tumSayfaSS.png");

        // 3. takesScreenshot objesini kullanarak fotografi cekin
        //    ve ilerde kullanilmak uzere gecici bir dosyaya kaydedin
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4. gecici dosyayi, resmi kaydetmek uzere hazirladigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaFotograf);

        ReusableMethods.bekle(3);
    }
}
