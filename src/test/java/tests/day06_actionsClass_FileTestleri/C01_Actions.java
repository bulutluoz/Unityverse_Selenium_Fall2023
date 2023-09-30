package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_Actions extends TestBase {


    @Test
    public void actionsTest() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi = "You selected a context menu";

        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        Thread.sleep(2000);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim

        // linke tikladigimizda kontrolumuz disinda yeni bir tab aciliyor
        // bu tab'a gecebilmek icin tab'in windowHandleDegerini bulmaliyiz
        // 1.adim : ilk sayfa whd'ni kaydedelim
        String ilkSayfaWhd= driver.getWindowHandle();

       driver.findElement(By.linkText("Elemental Selenium")).click();

       // 2.tab otomatik olarak acildigindan, driver'i direk geciremeyiz ama
       // 1. ve 2.sayfanin whd'lerini bir set olarak kaydedebiliriz

        Set<String> whdSeti = driver.getWindowHandles();

        // set'deki whd'lerini ilk Sayfa whd ile karsilastirip
        // ilk sayfanin whd olmayani 2.sayfanin whd olarak kaydedelim

        String ikinciSayfaWhd="";
        for (String each : whdSeti
             ) {

            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd = each;
            }
        }

        // artik ikinciSayfaWhd'ne sahibiz
        // bunu kullanarak driver'i 2.tab'a gecirebiliriz
        driver.switchTo().window(ikinciSayfaWhd);

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        WebElement yaziElement = driver.findElement(By.tagName("h1"));

        String expectedYazi = "Make sure your code lands";
        String actualYazi = yaziElement.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        Thread.sleep(2000);
    }
}
