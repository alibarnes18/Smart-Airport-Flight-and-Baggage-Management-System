// Ogrenci No: 240706088
// Ad Soyad:   Ali Suleymanlı

public class BusinessYolcu extends Yolcu {

    private boolean loungeKullandiMi;

    public BusinessYolcu(String yolcuID, String adSoyad, double bagajAgirligi, double biletFiyati, boolean loungeKullandiMi)
            throws GecersizBagajIstisnasi, EksikBilgiIstisnasi {
        super(yolcuID, adSoyad, bagajAgirligi, biletFiyati);
        this.loungeKullandiMi = loungeKullandiMi;
    }

    @Override
    public double toplamUcretHesapla() {
        double toplam = getBiletFiyati() + (getBagajAgirligi() * 15);
        if (loungeKullandiMi) {
            toplam += 500;
        }
        return toplam;
    }

    @Override
    public void bilgiYazdir() {
        super.bilgiYazdir();
        System.out.println("Lounge Kullanimi: " + (loungeKullandiMi ? "Evet" : "Hayir"));
    }

    @Override
    public String yolcuTuru() {
        return "Business Yolcu";
    }
}
