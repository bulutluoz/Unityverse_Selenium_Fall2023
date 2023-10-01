package tests.day07_Waits_Webtables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void cookiesTesti(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti = driver.manage().getCookies();

        int siraNo =1;
        for (Cookie each: cookieSeti
             ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi= 5;
        int actualCookieSayisi= cookieSeti.size();
        Assert.assertTrue(actualCookieSayisi > expectedMinCookieSayisi);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieDegeri = "USD";
        String actualCookieDegeri = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin

            Cookie cikolataliCookie = new Cookie("en sevdigim cookie","cikolatali");
            driver.manage().addCookie(cikolataliCookie);

        cookieSeti = driver.manage().getCookies();
        System.out.println("=======================");
        siraNo =1;
        for (Cookie each: cookieSeti
        ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        //   ismi "en sevdigim cookie" olan cookie degerinin "cikolatali" oldugunu test edelim
        expectedCookieDegeri = "cikolatali";
        actualCookieDegeri = driver.manage()
                                    .getCookieNamed("en sevdigim cookie")
                                    .getValue();
        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        cookieSeti = driver.manage().getCookies();
        System.out.println("=======================");
        siraNo =1;
        for (Cookie each: cookieSeti
        ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }
        // olmayan bir elementi, kendisi uzerinden test etmek mumkun degil
        // flag ve for loop kullanarak, tek tek tum cookie'lere bakip
        // ismi skin olan var mi? diye kontrol edebilirim
        // eger ismi skin olan varsa, flag'i degistiririz
        // loop bittiginde flag'i kontrol ederek, silinip silinmedigine karar verebiliriz

        boolean flag=true;
        for (Cookie each : cookieSeti
             ) {
            if (each.getName().equals("skin")){
                flag=false;
            }
        }

        // bu satira geldigimizde skin ismindeki cookie silinmisse
        // for loop'da skin bulunamaz
        // flag degismez ve true kalir
        Assert.assertTrue(flag);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSeti = driver.manage().getCookies();

        int expectedCookiSetiSize = 0;
        int actualSize= cookieSeti.size();

        System.out.println("==================");
        System.out.println("Tum cookie'ler silinince cookieSeti : " + cookieSeti);

        Assert.assertEquals(expectedCookiSetiSize , actualSize);

    }
}
