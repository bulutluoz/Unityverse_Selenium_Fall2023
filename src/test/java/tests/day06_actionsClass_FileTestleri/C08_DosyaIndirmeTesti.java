package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaIndirmeTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti() throws InterruptedException {

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. sample.png dosyasını indirelim
        driver.findElement(By.linkText("sample.png")).click();
        Thread.sleep(3000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        /*
            Dosya herkesin Downloads klasorune indirildi
            oncelikle dinamik dosya yolunu hazirlamaliyiz
         */

        String dinamikDosyaYolu = System.getProperty("user.home")
                                    +"/Downloads/sample.png";

        System.out.println(dinamikDosyaYolu); // /Users/ahmetbulutluoz/Downloads/sample.png

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
