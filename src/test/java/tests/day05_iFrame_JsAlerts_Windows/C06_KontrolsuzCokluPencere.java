package tests.day05_iFrame_JsAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluPencere extends TestBase {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWhd = driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualyazi = openingYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println(driver.getWindowHandle()); // 64DF3A0D49A8471F8C0888628C85C1B4
        System.out.println(driver.getWindowHandles());// [64DF3A0D49A8471F8C0888628C85C1B4]

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandle()); // 64DF3A0D49A8471F8C0888628C85C1B4
        System.out.println(driver.getWindowHandles());
        // [64DF3A0D49A8471F8C0888628C85C1B4, C75AD30C88AE32AA27224E31C9A16F25]

        String ikinciSayfaWhd = "";
        Set<String> whdSeti = driver.getWindowHandles();

        /*
            Ikinci sayfa bizim kontrolumuz disinda acilinca
            driver otomatik olarak ikinci sayfaya GECMEZ

            ikinci sayfa acildiktan sonra
            driver.getWindowHandle() ==> hala ilk sayfanin window handle degerini verir
            driver.getWindowHandles() ==> ise acik olan iki sayfanin window handle degerlerini
                                          bir set olarak verir
            set index'i desteklemedigi icin
            bir foreach loop yardimi ile set'deki 2 whd'ni
            ilk sayfanin whd ile karsilastiracagiz
            ilk sayfanin whd'ne ESIT OLMAYANI, ikinciSayfaWhd olarak atayacagiz
         */

        for (String each : whdSeti
             ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd = each;
            }
        }
        System.out.println("ilk sayfa : "+ilkSayfaWhd);
        System.out.println("ikinci sayfa : "+ikinciSayfaWhd);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedIkinciSayfaTitle= "New Window";
        String actualIkinciSayfaTitle = driver.getTitle();
        Assert.assertEquals(expectedIkinciSayfaTitle,actualIkinciSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedIkinciSayfaYazi = "New Window";
        String actualIkinciSayfaYazi = newWindowYaziElementi.getText();
        Assert.assertEquals(expectedIkinciSayfaYazi,actualIkinciSayfaYazi);
        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWhd);
        String expectedIlksayfaTitle = "The Internet";
        String actualIlkSayfaTitle = driver.getTitle();
        Assert.assertEquals(expectedIlksayfaTitle,actualIlkSayfaTitle);


    }
}
