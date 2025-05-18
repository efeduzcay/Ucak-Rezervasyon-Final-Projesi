public abstract class UcakBase {
    String model;
    String marka;
    String seriNo;
    int koltukKapasitesi;

    public UcakBase(String model, String marka, String seriNo, int koltukKapasitesi) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
    }

    public abstract String getUcakBilgisi();
}