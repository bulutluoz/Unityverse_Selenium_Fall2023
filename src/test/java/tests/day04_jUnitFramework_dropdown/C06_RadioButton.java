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

public class C06_RadioButton {

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
        //driver.close();
    }

    @Test
    public void radioButtonTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://facebook.com
        driver.get("https://facebook.com");
        Thread.sleep(1000);
        //	b. Cookies’i kabul edin
        driver.findElement(By.xpath("//*[@title='Allow all cookies']")).click();
        Thread.sleep(1000);
        //	c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //	d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinRadioButton= driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        WebElement erkekRadioButton= driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        WebElement digerRadioButton= driver.findElement(By.xpath("//input[@name='sex' and @value='-1']"));

        erkekRadioButton.click();

        //	e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

    }
}
