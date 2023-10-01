package tests.day07_Waits_Webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {

    @Test
    public void implicitlyWaitTesti() throws InterruptedException {
        //1. Test Base kullanmadan ayarlari yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //3. Remove butonuna tıklayın ve it's gone! yazisi cikincaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //4. “It’s gone!” mesajinin goruntulendigini dogrulayın.
        WebElement itsGoneElementi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //5. Add butonuna tıklayın ve it's back! yazisi cikincaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //6. “It’s back!” mesajinin goruntulendigini dogrulayın.
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void explicitlyWaitTesti(){

        //1. Test Base kullanmadan ayarlari yapin,implicitlyWait suresini 1 saniye yapip
        //   ExplicitlyWait ile asagidaki bekleme islemlerini gerceklestirin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //3. Remove butonuna tıklayın ve it's gone! yazisi cikincaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //4. “It’s gone!” mesajinin goruntulendigini dogrulayın.

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        WebElement itsGoneElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        //driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //5. Add butonuna tıklayın ve it's back! yazisi cikincaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //6. “It’s back!” mesajinin goruntulendigini dogrulayın.
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
         //driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
}
