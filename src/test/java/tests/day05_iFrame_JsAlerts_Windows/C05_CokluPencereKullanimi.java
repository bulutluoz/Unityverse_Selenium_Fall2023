package tests.day05_iFrame_JsAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_CokluPencereKullanimi extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // amazon'a gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWhd = driver.getWindowHandle();

        System.out.println(driver.getWindowHandle()); // CB842110AAB70158722CE88D57FAFBF6
        System.out.println(driver.getWindowHandles()); // [CB842110AAB70158722CE88D57FAFBF6]


        // yeni bir tab acarak youtube'a gidelim

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);

        driver.get("https://www.youtube.com");
        String ikinciSayfaWhd = driver.getWindowHandle();

        System.out.println(driver.getWindowHandle()); // AF28AFA699177812468008852315D0D1
        System.out.println(driver.getWindowHandles());
        //[CB842110AAB70158722CE88D57FAFBF6, AF28AFA699177812468008852315D0D1]



        // Yeni bir sayfa acarak arabam.com'a gidin

        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(1000);
        String ucuncuSayfaWhd = driver.getWindowHandle();

        driver.get("https://www.arabam.com");


        System.out.println(driver.getWindowHandle()); // AF28AFA699177812468008852315D0D1
        System.out.println(driver.getWindowHandles());
        //[CB842110AAB70158722CE88D57FAFBF6, AF28AFA699177812468008852315D0D1]


        // amazon'un acik oldugu sayfaya gidin
        // ve title'in Amazon icerdigini test edin
        // an itibariyle driver'imiz arabam.com'un oldugu sayfada
        // gecis icin amazon'un acik oldugu sayfanin window handle degerine ihtiyacimiz var
        driver.switchTo().window(ilkSayfaWhd);
        String expectedTitleIcerik = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // youtube'un acik oldugu sayfaya gidin
        // ve url'in youtube icerdigini test edin
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedUrlIcerik = "youtube";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // arabam.com'un acik oldugu sayfaya gidin
        // ve logonun gorundugunu test edin

        driver.switchTo().window(ucuncuSayfaWhd);

        WebElement logoElementi = driver.findElement(By.xpath("//img[@alt='arabam.com']"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
