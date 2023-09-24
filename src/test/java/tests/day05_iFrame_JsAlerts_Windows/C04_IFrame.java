package tests.day05_iFrame_JsAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElementi.isEnabled());

        System.out.println(anIframeElementi.getText());
        //	- Text Box’a “Merhaba Dunya!” yazin.
        /*
            Eger kullanmak istedigimiz WebElement bir iFrame'in icinde ise
            direk kullanamayiz
            once iFrame'i locate edip, iFrame'e gecis yapmalyiz

         */

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        Thread.sleep(200);
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));

        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya");

        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        /*
            Bir web sayfasinin icinde bulunan iFrame'e gecis yaptiktan sonra
            yeniden ana sayfadan bir webelement kullanmak istersek

            once gecis yaptigimiz ifarame'den anasayfaya donmemiz gerekir.
         */
        driver.switchTo().defaultContent();

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(elementalSelenium.isDisplayed());

        System.out.println(elementalSelenium.getText());


        Thread.sleep(5000);
    }
}
