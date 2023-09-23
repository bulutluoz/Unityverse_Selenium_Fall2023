package tests.day04_jUnitFramework_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //	     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
        //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Elementi = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2Elementi = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //	c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1Elementi.isSelected()){
            checkbox1Elementi.click();
        }
        Thread.sleep(2000);
        //	d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2Elementi.isSelected()){
            checkbox2Elementi.click();
        }
        Thread.sleep(2000);
        //	e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin

        Assert.assertTrue(checkbox1Elementi.isSelected());
        Assert.assertTrue(checkbox2Elementi.isSelected());

        // f. Checkbox1 ve Checkbox2’nin tiklerini kaldirin
        checkbox1Elementi.click();
        checkbox2Elementi.click();
        Thread.sleep(2000);

        // g.Checkbox1 ve Checkbox2’nin secili olmadigini test edin

        Assert.assertFalse(checkbox1Elementi.isSelected());
        Assert.assertFalse(checkbox2Elementi.isSelected());
    }
}
