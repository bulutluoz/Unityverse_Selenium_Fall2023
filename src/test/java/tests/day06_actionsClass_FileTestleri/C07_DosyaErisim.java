package tests.day06_actionsClass_FileTestleri;

import org.junit.Test;

public class C07_DosyaErisim {

    @Test
    public void dosyaTesti(){

        // /Users/ahmetbulutluoz/Desktop/sample.png
        // C:\Users\eyupe\OneDrive\Desktop\sample.png
        // C:\Users\gamze\OneDrive\Masaüstü\sample.png
        // C:\Users\aykut\OneDrive\Masaüstü
        // C:\Users\PC\Desktop


        System.out.println(System.getProperty("user.home"));
        // /Users/ahmetbulutluoz
        // C:\Users\aykut
        // C:\Users\PC


        /*
            Selenium bilgisayarimiza ulasamaz ve
            bilgisayarimizdaki dosyalari test edemez

            Bilgisayarimizdaki dosyalarla ilgili islemler icin
            java'dan yardim alabiliriz

            Java'nin bilgisayarimizdaki bir dosyaya ulasabilmesi icin ise
            dosya yoluna ihtiyaci vardir

            Testimiz birden fazla bilgisayarda calisacaksa
            her bilgisayarin dosya yapisi farkli olacagindan
            dosya testleri hata verebilir

            Bu hatalarin onune gecmek icin
            dosya yollarimizi dinamik yapmayi terdih ederiz


            dosya yolunu 2 parcaya ayiralim
            1- sadece benim bilgisayarima ozel kisim
            2- herkeste ortak olan kisim

            /Users/ahmetbulutluoz                    /Desktop/sample.png
            C:\Users\eyupe\           OneDrive       \Desktop\sample.png
            // C:\Users\gamze\        OneDrive       \Masaüstü\sample.png

         */

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/sample.png";


    }
}
