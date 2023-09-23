package tests.day04_jUnitFramework_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //   asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void urlTesti(){
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTesti(){
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unExpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));
    }

    @Test
    public void logoTesti(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisTesti(){
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francaisLinkElementi = driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francaisLinkElementi.isDisplayed());

    }

}
