// Ogrenci No: 240706088
// Ad Soyad:   Ali Suleymanlı

public abstract class Yolcu {

    private String yolcuID;
    private String adSoyad;
    private double bagajAgirligi;
    private double biletFiyati;

    public Yolcu(String yolcuID, String adSoyad, double bagajAgirligi, double biletFiyati)
            throws GecersizBagajIstisnasi, EksikBilgiIstisnasi {

        if (adSoyad == null || adSoyad.trim().isEmpty()) {
            throw new EksikBilgiIstisnasi("Hata: Yolcu ad soyad bilgisi bos olamaz.");
        }
        if (bagajAgirligi < 0) {
            throw new GecersizBagajIstisnasi("Hata: Bagaj agirligi negatif olamaz. Girilen deger: " + bagajAgirligi);
        }
        if (biletFiyati < 0) {
            throw new IllegalArgumentException("Hata: Bilet fiyati negatif olamaz. Girilen deger: " + biletFiyati);
        }

        this.yolcuID      = yolcuID;
        this.adSoyad      = adSoyad;
        this.bagajAgirligi = bagajAgirligi;
        this.biletFiyati   = biletFiyati;
    }

    

    public String getYolcuID() {
        return yolcuID;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public double getBagajAgirligi() {
        return bagajAgirligi;
    }

    public double getBiletFiyati() {
        return biletFiyati;
    }

    

    public double toplamUcretHesapla() {
        return biletFiyati;
    }

    public void bilgiYazdir() {
        System.out.println("Yolcu Turu: " + yolcuTuru());
        System.out.println("Yolcu ID: "   + yolcuID);
        System.out.println("Ad Soyad: "   + adSoyad);
        System.out.println("Bagaj Agirligi: " + bagajAgirligi + " kg");
        System.out.println("Bilet Fiyati: "   + biletFiyati   + " TL");
        System.out.println("Toplam Ucret: "   + toplamUcretHesapla() + " TL");
    }

    public abstract String yolcuTuru();

    public String dosyaKaydiOlustur() {
        return yolcuID + " - " + adSoyad + " - " + yolcuTuru() + " - " + toplamUcretHesapla() + " TL";
    }
}
