package tests.day04_jUnitFramework_dropdown;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertions {

    int sayi1 = 210;
    int sayi2 = 100;

    @Test
    public void ciftSayiTesti(){
        // sayi1'in cift olup olmadigini test edin
        Assert.assertTrue("sayi1 cift degil",sayi1 % 2 == 0);

    }

    @Test
    public void karsilastirmaTesti(){
        // sayi1 sayi2'den buyuk mu test edin
        Assert.assertTrue("sayi1 sayi2'den buyuk degil",sayi1 > sayi2);
    }

    @Test
    public void pozitifSayiTesti(){
        // sayi2 nin pozitif oldugunu test edin
        Assert.assertTrue("sayi2 pozitif degil",sayi2 > 0);
    }

    @Test
    public void buyukOlmamaTesti(){
        // sayi1'in sayi2'den buyuk olmadigini test edin
        // sayi1 > sayi2 ==> false olmali

        Assert.assertFalse("sayi1 sayi2'den buyuk",sayi1 > sayi2);
    }

    @Test
    public void kucukTesti(){
        // eger sayi1'in sayi2'den kucuk oldugunu test edin
        // sayi1 < sayi2 ==> true olmali
    }
}
