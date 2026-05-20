// Ogrenci No: 240706088
// Ad Soyad:   Ali Suleymanlı

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Yolcu[] yolcular = new Yolcu[6];

        
        try {
            yolcular[0] = new EkonomiYolcusu("Y001", "Ali Demir", 18.0, 2500.0, 10);
            System.out.println("Yolcu olusturma islemi tamamlandi.");
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y001 islem blogu tamamlandi.");
        }

        try {
            yolcular[1] = new EkonomiYolcusu("Y002", "Ayse Kaya", 22.0, 2800.0, 15);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y002 islem blogu tamamlandi.");
        }

        
        try {
            yolcular[2] = new BusinessYolcu("Y003", "Mehmet Can", 15.0, 6000.0, true);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y003 islem blogu tamamlandi.");
        }

        try {
            yolcular[3] = new BusinessYolcu("Y004", "Zeynep Ak", 12.0, 5500.0, false);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y004 islem blogu tamamlandi.");
        }

        
        try {
            yolcular[4] = new VIPYolcu("Y005", "Can Yilmaz", 10.0, 9000.0, true);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y005 islem blogu tamamlandi.");
        }

        try {
            yolcular[5] = new VIPYolcu("Y006", "Ece Nur", 8.0, 8500.0, false);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println(e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Y006 islem blogu tamamlandi.");
        }

        
        System.out.println("\n--- Hatali Veri Testleri ---");

        try {
            Yolcu hataliYolcu = new EkonomiYolcusu("Y099", "Test Kisi", -5.0, 1000.0, 5);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println("Yakalanan istisna: " + e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println("Yakalanan istisna: " + e.getMessage());
        } finally {
            System.out.println("Hatali bagaj test blogu tamamlandi.");
        }

        try {
            Yolcu hataliYolcu2 = new EkonomiYolcusu("Y098", "", 10.0, 1000.0, 5);
        } catch (GecersizBagajIstisnasi e) {
            System.out.println("Yakalanan istisna: " + e.getMessage());
        } catch (EksikBilgiIstisnasi e) {
            System.out.println("Yakalanan istisna: " + e.getMessage());
        } finally {
            System.out.println("Hatali ad test blogu tamamlandi.");
        }

        
        System.out.println("\n=== YOLCU BILGILERI ===");
        for (int i = 0; i < yolcular.length; i++) {
            if (yolcular[i] != null) {
                yolcular[i].bilgiYazdir();
                System.out.println("-----------------------------");
            }
        }

        
        int ekonomiSayisi  = 0;
        int businessSayisi = 0;
        int vipSayisi      = 0;
        double toplamGelir = 0;

        for (int i = 0; i < yolcular.length; i++) {
            if (yolcular[i] != null) {
                toplamGelir += yolcular[i].toplamUcretHesapla();
                if (yolcular[i] instanceof EkonomiYolcusu) {
                    ekonomiSayisi++;
                } else if (yolcular[i] instanceof BusinessYolcu) {
                    businessSayisi++;
                } else if (yolcular[i] instanceof VIPYolcu) {
                    vipSayisi++;
                }
            }
        }

        System.out.println("=== GENEL RAPOR ===");
        System.out.println("Ekonomi Yolcusu Sayisi: " + ekonomiSayisi);
        System.out.println("Business Yolcu Sayisi: "  + businessSayisi);
        System.out.println("VIP Yolcu Sayisi: "       + vipSayisi);
        System.out.println("Toplam Gelir: "           + toplamGelir + " TL");

        
        dosyayaYaz(yolcular);
        dosyadanOku();
    }

    public static void dosyayaYaz(Yolcu[] yolcular) {
        BufferedWriter yazar = null;
        try {
            yazar = new BufferedWriter(new FileWriter("ucus_kayitlari.txt"));
            for (int i = 0; i < yolcular.length; i++) {
                if (yolcular[i] != null) {
                    yazar.write(yolcular[i].dosyaKaydiOlustur());
                    yazar.newLine();
                }
            }
            System.out.println("\nDosya olusturuldu: ucus_kayitlari.txt");
            System.out.println("Yolcu kayitlari dosyaya yazildi.");
        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatasi: " + e.getMessage());
        } finally {
            if (yazar != null) {
                try {
                    yazar.close();
                } catch (IOException e) {
                    System.out.println("Dosya kapatma hatasi: " + e.getMessage());
                }
            }
        }
    }

    public static void dosyadanOku() {
        BufferedReader okuyucu = null;
        try {
            okuyucu = new BufferedReader(new FileReader("ucus_kayitlari.txt"));
            System.out.println("\n=== DOSYADAN OKUNAN KAYITLAR ===");
            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (IOException e) {
            System.out.println("Dosyadan okuma hatasi: " + e.getMessage());
        } finally {
            if (okuyucu != null) {
                try {
                    okuyucu.close();
                } catch (IOException e) {
                    System.out.println("Dosya kapatma hatasi: " + e.getMessage());
                }
            }
        }
    }
}
