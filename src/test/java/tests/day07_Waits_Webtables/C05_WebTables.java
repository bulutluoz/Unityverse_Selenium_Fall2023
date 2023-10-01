package tests.day07_Waits_Webtables;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {

    @Test
    public void amazonWebTableTesti() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        //3.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElementi.getText());
        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=7;
        int actualSatirSayisi = satirElementleriList.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin
        System.out.println("==================");

        for (int i = 0; i <satirElementleriList.size() ; i++) {

            System.out.println(i+1 +". satir     :    " + satirElementleriList.get(i).getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        //   Web table'da sutun bilgisi yoktur
        //   her bir satir icindeki, datalar vardir
        //   sutun sayisini bulabilmek icin, bir satirdaki data sayisina bakabiliriz

        List<WebElement> birinciSatirDatalariList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedSutunSayisi = 13;
        int actualSutunsayisi = birinciSatirDatalariList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunsayisi);

        //7. 5.sutunu yazdirin
        //   WebTable'da sutun yapisi yoktur
        //   Bunun yerine her satirdaki 5.datayi alip bir liste olusturabiliriz

        List<WebElement> besinciSutunListesi = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("====== 5.Sutun========");
        for (WebElement each: besinciSutunListesi
             ) {
            System.out.println(each.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("===============================");
        System.out.println(hucredekiBilgi(7, 5));

    }

    public String hucredekiBilgi(int satirNo, int sutunNo){

        //         //tbody/tr[1]/td[7]

        String dinamikXPath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXPath));

        return istenenDataElementi.getText();

    }
}
