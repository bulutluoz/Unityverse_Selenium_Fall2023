package tests.day03_JUnit;

import org.junit.Ignore;
import org.junit.Test;

public class C05_TestNotasyonu {
    /*
        @Test notasyonu, method'lara bagimsiz olarak calistirilabilme yetenegi katar

        Testlerin bagimsiz olarak calisabilmesi,
        Framework uzerinde bu test method'larindan olusan farkli test gruplarini
        istedigimiz zamanlarda calistirabilme imkani tanir

        Testlerin buyukluklerine gore tesleri su sekilde siralayabiliriz

        Test Suit (Birden fazla test icerir)
            - Smoke Test
            - Entegrasyon Testleri
            - End2End Testing
            - Regression
        Test : Bir amac icin bir araya getirilmis
               Test class'lari, Test Method'lari veya Package'lardan olusur
               ornegin bizim Smoke testimiz icin
                - day01 package'indaki tum class'lar
                - day02 den C01 ve C03
                - day03 deki C05 class'indaki test01 ve test02 test method'lari calissin diyebiliriz

          ayni test method'lari, class'lar veya package'lar
          birden fazla Test icin calistirilabilir

          JUnit testlerin bagimsiz olarak calistirilabilmesine imkan tanir
          ANCAK siralamayi j=kontrol etmez,
          bizim kontrol etmemize de imkan tanimaz

          JUnit @Test kullanan method'larin static olarak isaretlenmesine izin vermez
          1. Method test01() should not be static

     */


    @Test // Test method'u
    public void test01(){
        System.out.println("Test01 calisti");
    }

    @Test @Ignore
    public void test02(){
        System.out.println("Test02 calisti");
    }
    @Test
    public void test03(){
        System.out.println("Test03 calisti");
    }
}
