package tests.day08_webTables_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    Sheet sayfa1;
    @Test
    public void excelTesti() throws IOException {

        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu); // Java
        Workbook workbook = WorkbookFactory.create(fileInputStream); // Apache poi

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        sayfa1 = workbook.getSheet("Sayfa1");
        Row row = sayfa1.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("Cell : "+cell); // Başkent (İngilizce)
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("String olarak istenen hucre : " + istenenHucre);

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedBaskent = "Kabil";
        String actualBaskent = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedBaskent,actualBaskent);

        //		- Satir sayisini bulalim
            int satirSayisi = sayfa1.getLastRowNum(); // son satirin index'ini verir
        System.out.println("Exceldeki satir sayisi : " + (satirSayisi+1));
        //		- Fiziki olarak kullanilan satir sayisini bulun
            int kullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();
        System.out.println("Aktif olarak kullanilan satir sayisi : " + kullanilanSatirSayisi);

        // sayfada turkce baskent olarak Bern bulundugunu test edin

        boolean bernVarMi = false;
        String turkceBaskentIsmi;

        for (int i = 0; i <=satirSayisi ; i++) {

            turkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            if (turkceBaskentIsmi.equals("Bern")){
                bernVarMi = true;
                break;
            }
        }

        Assert.assertTrue(bernVarMi);

        // bir method olusturun, istedigim satir ve sutun numarasina sahip
        // cell'deki yaziyi yazdirsin

        hucreYazdir(3,3); // Arnavutluk
        hucreYazdir(10,2); // Canberra
        // hucreYazdir(200,2); // NullPointerException
        // hucreYazdir(5,12); // NullPointerException


    }

    public void hucreYazdir(int satirNo , int sutunNo){

        String istenenHucreYazi = sayfa1.getRow(satirNo-1).getCell(sutunNo-1).toString();
        System.out.println(satirNo + ". satir, " + sutunNo + ". sutundaki bilgi : " + istenenHucreYazi);
    }
}
