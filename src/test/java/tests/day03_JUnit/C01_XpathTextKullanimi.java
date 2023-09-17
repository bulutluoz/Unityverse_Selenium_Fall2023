package tests.day03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathTextKullanimi {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButtonElementi = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButtonElementi.isDisplayed()){
            System.out.println("Delete butonu testi PASSED");
        }else {
            System.out.println("Delete butonu testi FAILED");
        }
        //4- Delete tusuna basin
        deleteButtonElementi.click();
        Thread.sleep(2000);
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveElementi.isDisplayed()){
            System.out.println("Add remove elementi testi PASSED");
        }else{
            System.out.println("Add remove elementi testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
