package tests.day09_screenshot_JsExecutor_TestNG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_scroolIntoWiew extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        // "Back to tap" linki gorununceye kadar asagi inin
        WebElement backToTapElementi = driver.findElement(By.xpath("//*[@*='navFooterBackToTopText']"));
        ReusableMethods.bekle(1);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",backToTapElementi);

        // "Back to tap" elementinin screenshot'ini alin
        ReusableMethods.bekle(2);
        ReusableMethods.webelementScreenshotCek(backToTapElementi,"backToTap");

        // Back to tap'a tiklayip sayfanin basina donun
        jse.executeScript("arguments[0].click();",backToTapElementi);
        ReusableMethods.bekle(2);

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaFotografCek(driver,"basaDonus");

        ReusableMethods.bekle(2);

        jse.executeScript("alert('yasasinnnn');");

        ReusableMethods.bekle(2);

    }
}
