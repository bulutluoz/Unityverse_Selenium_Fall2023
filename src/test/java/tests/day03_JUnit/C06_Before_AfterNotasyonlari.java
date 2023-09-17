package tests.day03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Before_AfterNotasyonlari {

    // 3 test method'u olusturun
    // 3 method da ayri ayri google, youtube ve amazon'a gidip
    // Title'larinda google, youtube ve amazon gectigini test edip
    // sayfayi kapatin

    /*
        Bir Test calisirken
        Her test method'undan once calismasini istediginiz ortak kodlar varsa
        her method'da tekrar tekrar yazmak yerine
        @Before notasyonuna sahip ayri bir method olarak yazabilirsiniz

        @Before notasyonuna sahip method'lar bagimsiz olarak CALISTIRILAMAZ
        bulunduklari class'da var olan tum @Test notasyonuna sahip method'lar
        calismaya baslamadan devreye girip ilgili ayarlari yaparlar.

        Bunun icin de isimleri genelde setup olur

        Ayni sekilde @Test notasyonuna sahip her method'dan sonra
        calismasini istedigimiz kodlar icin de
        @After notasyonuna sahip teardown() olusturulur

        @Before ve @After method'lari sayesinde
        @Test method'lari daha anlasilabilir olur
        ve sadece testlere odaklanir

        JUnit test'in passed veya failed olmasina
        test method'unun sorunsuz calisip calismadigina bakarak karar verir
        test method'u hic bir sorun olmadan execute edilirse test PASSED
        method calisirken bir hata olusursa test FAILED olarak isaretlenir


     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void googleTest() throws InterruptedException {

        driver.get("https://www.google.com");

        String expectedicerik = "google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedicerik)){
            System.out.println("google testi PASSED");
        }else{
            System.out.println("google testi FAILED");
            System.out.println("Actual title : " + actualTitle);
            throw new RuntimeException();
        }

    }

    @Test
    public void youtubeTest() throws InterruptedException {


        driver.get("https://www.youtube.com");

        String expectedicerik = "youtube";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedicerik)){
            System.out.println("youtube testi PASSED");
        }else{
            System.out.println("youtube testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }

    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");

        String expectedicerik = "amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedicerik)){
            System.out.println("amazon testi PASSED");
        }else{
            System.out.println("amazon testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }

    }
}
