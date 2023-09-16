package tests.day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findElements {

    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryList  = driver.findElements(By.className("panel-title"));

        //4- Category bolumunde 3 element oldugunu test edin
        int expectedCategorySayisi = 3;
        int actualCategorySayisi = categoryList.size();

        if (expectedCategorySayisi == actualCategorySayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else{
            System.out.println("Kategori sayisi testi FAILED");
        }
        //5- Category isimlerini yazdirin

        System.out.println(categoryList);
        // WebElement'ler obje olduklarindan direk yazdirilamazlar
        // uzerindeki yaziyi yazdirmak icin webElement.getText() kullanilir

        for (WebElement eachElement: categoryList
             ) {
            System.out.println(eachElement.getText() );

        }

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
