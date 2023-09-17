package tests.day03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //2 ) Berlin’i  3 farkli relative locator ile locate edin

        /*
            Relative locator, HTML kodlarina ulasabildigimiz
            ANCAK locate edemedigimiz elementleri etrafindaki elementleri kullanarak
            locate etmemize izin verir

            berlin elementinin HTML kodlari :

            <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">
         */
        WebElement sailorElementi = driver.findElement(By.id("pid11_thumb"));
        WebElement nycElementi = driver.findElement(By.id("pid3_thumb"));
        WebElement bostonElementi = driver.findElement(By.id("pid6_thumb"));
        // tag'i img olup, sailor'in ustundeki element
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));

        // class attribute degeri ui-li-thumb olup, NYC'nin altinda olan

        WebElement berlin2 = driver
                            .findElement(RelativeLocator.with(By.className("ui-li-thumb")).below(nycElementi));

        // id attribute degeri pid7_thumb olup, boston'in saginda olan element

        WebElement berlin3 = driver
                .findElement(RelativeLocator.with(By.id("pid7_thumb")).toRightOf(bostonElementi));

        //3 ) Relative locator’larin dogru calistigini test edin

        if (berlin1.getAttribute("id").equals("pid7_thumb")){
            System.out.println("berlin1 locator'i calisiyor");
        }else{
            System.out.println("berlin1 locator'i calismiyor");
        }

        if (berlin2.getAttribute("id").equals("pid7_thumb")){
            System.out.println("berlin2 locator'i calisiyor");
        }else{
            System.out.println("berlin2 locator'i calismiyor");
        }

        if (berlin3.getAttribute("id").equals("pid7_thumb")){
            System.out.println("berlin3 locator'i calisiyor");
        }else{
            System.out.println("berlin3 locator'i calismiyor");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
