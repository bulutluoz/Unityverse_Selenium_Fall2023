package tests.day03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeClass_AfterClass {

    // 3 ayri test method'u olusturup, asagidaki 3 gorevi bu method'larda yapin
    // 1- amazon anasayfaya gidip title'in "Amazon" icerdigini test edin
    // 2- Nutella aratip, arama sonuclarinin "Nutella" icerdigini test edin
    // 3- Ilk urune tiklayin, ilk urun sayfasi acildiginda,
    //    urun isminin "Nutella" icerdigini test edin

    /*
        Eger class icinde calistiracagimiz test method'lari
        belirli adimlarla ilerliyorsa
        bir test method'unun saglikli calismasi,
        baska bir test method'unun calismasina bagli ise
        her method'dan sonra driver'i kapatip,
        sonraki method'da acmak MANTIKLI OLMAZ

        Bunun yerine testlerin sirali calismasini saglamak icin
        test01, test02... gibi isimler verip
        driver'in en basta olusturulmasi ve
        test method'larinin tamami calistirildiktan sonra kapatilmasi icin
        @Before ve @After notasyonlari yerine
        @BeforeClass ve @AfterClass notasyonlari kullanilir

        BeforeClass ve @AfterClass notasyonlari kullanirken
        dikkat etmemiz gereken konu, bu notasyonlara sahip
        method'larin static olmasinin zorunlu olmasidir.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        // 1- amazon anasayfaya gidip title'in "Amazon" icerdigini test edin

        driver.get("https://www.amazon.com");
        String expectedIcerik = "Amazon";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Amazon title testi PASSED");
        }else{
            System.out.println("Amazon title testi FAILED");
        }
    }

    @Test
    public void test02(){
        // 2- Nutella aratip, arama sonuclarinin "Nutella" icerdigini test edin

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik = "Nutella";

        String actualAramaSonucu= aramaSonucElementi.getText();

        if (actualAramaSonucu.contains(expectedIcerik)){
            System.out.println("Nutella arama testi PASSED");
        }else{
            System.out.println("Nutella arama testi FAILED");
        }
    }

    @Test
    public void test03(){
        // 3- Ilk urune tiklayin, ilk urun sayfasi acildiginda,
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        //    urun isminin "Nutella" icerdigini test edin

        String ilkUrunIsim = driver.findElement(By.xpath("//span[@id='productTitle']"))
                                    .getText();

        String expectedIcerik = "Nutella";

        if (ilkUrunIsim.contains(expectedIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else{
            System.out.println("Ilk urun testi FAILED");
        }

    }
}
