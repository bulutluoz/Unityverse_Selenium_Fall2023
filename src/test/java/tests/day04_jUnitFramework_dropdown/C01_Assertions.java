package tests.day04_jUnitFramework_dropdown;

import org.junit.Test;

public class C01_Assertions {
    int sayi1 = 110;
    int sayi2 = 20;
    /*
        JUnit bir test method'u calistirilirken
        hic bir hata almiyorsa
        testi PASSED olarak isaretler

        testin FAILED olabilmesi icin
        test method'u calisirken exception olusmalidir
     */

    @Test
    public void ciftSayiTesti(){

        // sayi1'in cift olup olmadigini test edin

        if (sayi1 % 2 == 0){
            System.out.println("Cift sayi testi PASSED");
        }else{
            System.out.println("Cift sayi testi FAILED");
            throw new RuntimeException("sayi1 cift degil");
        }
    }

    @Test
    public void karsilastirmaTesti(){
        // sayi1 sayi2'den buyuk mu test edin

        if (sayi1 > sayi2){
            System.out.println("Karsilastirma testi PASSED");
        }else {
            System.out.println("Karsilastirma testi FAILED");
            throw new RuntimeException("sayi1 sayi2'den buyuk degil");
        }
    }

    @Test
    public void pozitifSayiTesti(){
        // sayi2 nin pozitif oldugunu test edin

        if (sayi2 > 0){
            System.out.println("pozitif sayi testi PASSED");
        }else {
            System.out.println("pozitif sayi testi FAILED");
            throw new RuntimeException("sayi2 pozitif degil");
        }
    }
}
