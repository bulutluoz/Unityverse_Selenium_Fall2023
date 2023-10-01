package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C09_FileUploadTesti extends TestBase {

    @Test
    public void fileUploadTesti() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        System.out.println(System.getProperty("user.home"));
        // bilgisayardaki kullanici ana dosyanin dosya yolu : /Users/ahmetbulutluoz
        System.out.println(System.getProperty("user.dir"));
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/com.unityverse_Selenium
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/com.unityverse_Selenium/src/test/java/tests/day06_actionsClass_FileTestleri/deneme.txt
        // src/test/java/tests/day06_actionsClass_FileTestleri/deneme.txt

        String dinamikDosyaYolu = System.getProperty("user.dir")
                + "/src/test/java/tests/day06_actionsClass_FileTestleri/deneme.txt";
        //Yuklemek istediginiz dosyayi secelim.
        WebElement fileUploadButonu = driver.findElement(By.id("file-upload"));
        fileUploadButonu.sendKeys(dinamikDosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadYaziElementi.isDisplayed());

        Thread.sleep(8000);
    }
}
