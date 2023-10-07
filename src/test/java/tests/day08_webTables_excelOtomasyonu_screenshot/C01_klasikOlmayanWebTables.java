package tests.day08_webTables_excelOtomasyonu_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_klasikOlmayanWebTables extends TestBase {

    @Test
    public void test01()  {
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        WebElement headersSatiri = driver.findElement(By.xpath("//*[@class='rt-thead -header']"));
        System.out.println("Basliklar : " + headersSatiri.getText());
        //  3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBasligi = driver.findElement(By.xpath("//*[@class='rt-thead -header']//*[@role='columnheader'][3]"));
        System.out.println("Ucuncu satir basligi : " + ucuncuSutunBasligi.getText());
        //  4. Tablodaki tum datalari yazdirin
        //  Tum body'yi tek bir webelement olarak locate edip yazdiralim
        WebElement tumBody= driver.findElement(By.xpath("//*[@class='rt-tbody']"));
        System.out.println("Tum Body : " + tumBody.getText());
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> dataList = driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td']"));

        int sayac = 0;
        for (WebElement each :dataList
             ) {
            if (!each.getText().isBlank()){
                sayac++;
            }
        }
        System.out.println("tablodaki bos olmayan hucre sayisi : " + sayac);
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList = driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Tablodaki satir sayisi : " + satirlarList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     WebTable'da sutun yapisi yok, bunun yerine herhangi bir satirdaki data sayisini yazdiralim
        List<WebElement> birinciSatirDatalari = driver.findElements(By.xpath("//*[@role='rowgroup'][1]//*[@class='rt-td']"));
        System.out.println("Tablodaki sutun sayisi : " + birinciSatirDatalari.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunDatalari = driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td'][3]"));
        System.out.println("Ucuncu sutun : ");
        for (WebElement each : ucuncuSutunDatalari
             ) {
            if (!each.getText().isBlank()){
                System.out.println(each.getText());
            }
        }
        //  9. Tabloda "First Name"i Kierra olan kisinin Salary'sini yazdirin

        String isimXpath;
        String maasXpath;
        String isim;
        String maas;
        for (int i = 1; i <= satirlarList.size() ; i++) {

            //     //*[@role='rowgroup'][  3  ]//*[@class='rt-td'][1]

            isimXpath = "//*[@role='rowgroup'][" + i + "]//*[@class='rt-td'][1]";
            maasXpath = "//*[@role='rowgroup'][" + i + "]//*[@class='rt-td'][5]";

            isim = driver.findElement(By.xpath(isimXpath)).getText();
            maas = driver.findElement(By.xpath(maasXpath)).getText();

            if (isim.equals("Kierra")){
                System.out.println("Kierra'nin maasi : " + maas);
            }

        }

        //10. bir method olusturun, satir ve sutun sayisini girdigimde bana datayi yazdirsin
        dataYazdir(3,2); // Gentry
        dataYazdir(1,5); // 10000

        ReusableMethods.bekle(3);

    }

    public void dataYazdir(int satirNo , int sutunNo){

        //      //*[@role='rowgroup'][  3  ]//*[@class='rt-td'][   1   ]

        String dinamikXpath = "//*[@role='rowgroup'][" + satirNo +
                              "]//*[@class='rt-td'][" + sutunNo + "]";

        WebElement istenenElement = driver.findElement(By.xpath(dinamikXpath));
        System.out.println(satirNo+".ci satir, " + sutunNo + ".ci sutundaki data : " + istenenElement.getText());
    }
}
