// Ogrenci No: 240706088
// Ad Soyad:   Ali Suleymanlı

public class VIPYolcu extends Yolcu {

    private boolean ozelTransfer;

    public VIPYolcu(String yolcuID, String adSoyad, double bagajAgirligi, double biletFiyati, boolean ozelTransfer)
            throws GecersizBagajIstisnasi, EksikBilgiIstisnasi {
        super(yolcuID, adSoyad, bagajAgirligi, biletFiyati);
        this.ozelTransfer = ozelTransfer;
    }

    @Override
    public double toplamUcretHesapla() {
        double toplam = getBiletFiyati() + 2000;
        if (ozelTransfer) {
            toplam += 750;
        }
        return toplam;
    }

    @Override
    public void bilgiYazdir() {
        super.bilgiYazdir();
        System.out.println("Ozel Transfer: " + (ozelTransfer ? "Evet" : "Hayir"));
    }

    @Override
    public String yolcuTuru() {
        return "VIP Yolcu";
    }
}
