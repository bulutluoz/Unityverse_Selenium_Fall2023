package tests.day03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubuguElementi = driver.findElement(By.id("APjFqb"));
        aramaCubuguElementi.sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucElementi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucElementi.getText());
        // About 150.000.000 results (0,30 seconds)

        String sonucYazisi = sonucElementi.getText();
        int ilkBoslukIndexi= sonucYazisi.indexOf(" ");
        int ikinciBoslukIndexi = sonucYazisi.indexOf(" ", ilkBoslukIndexi+1);

        String sonucSayiStr = sonucYazisi
                            .substring(ilkBoslukIndexi,ikinciBoslukIndexi)
                            .replaceAll("\\D",""); // "150000000"

        int sonucSayisi = Integer.parseInt(sonucSayiStr);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        if (sonucSayisi>10000000){
            System.out.println("Sonuc sayisi testi PASSED");
        }else{
            System.out.println("Sonuc sayisi testi FAILED");
        }

        //8- Sayfayi kapatin

        Thread.sleep(5000);
        driver.close();
    }
}
