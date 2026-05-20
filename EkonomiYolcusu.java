// Ogrenci No: 240706088
// Ad Soyad:   Ali Suleymanlı

public class EkonomiYolcusu extends Yolcu {

    private int ekBagajHakki;

    public EkonomiYolcusu(String yolcuID, String adSoyad, double bagajAgirligi, double biletFiyati, int ekBagajHakki)
            throws GecersizBagajIstisnasi, EksikBilgiIstisnasi {
        super(yolcuID, adSoyad, bagajAgirligi, biletFiyati);
        this.ekBagajHakki = ekBagajHakki;
    }

    @Override
    public double toplamUcretHesapla() {
        return getBiletFiyati() + (getBagajAgirligi() * 25);
    }

    @Override
    public void bilgiYazdir() {
        super.bilgiYazdir();
        System.out.println("Ek Bagaj Hakki: " + ekBagajHakki + " kg");
    }

    @Override
    public String yolcuTuru() {
        return "Ekonomi Yolcusu";
    }
}
