public class Ucak extends UcakBase {

    public Ucak(String model, String marka, String seriNo, int koltukKapasitesi) {
        super(model, marka, seriNo, koltukKapasitesi);
    }

    @Override
    public String getUcakBilgisi() {
        return marka + " " + model + " (" + seriNo + ") - Kapasite: " + koltukKapasitesi;
    }

    public String toString() {
        return getUcakBilgisi();
    }
}