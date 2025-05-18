public class Lokasyon {
    String ulke;
    String sehir;
    String havaalani;

    public Lokasyon(String ulke, String sehir, String havaalani) {
        this.ulke = ulke;
        this.sehir = sehir;
        this.havaalani = havaalani;
    }

    public String toString() {
        return havaalani + " - " + sehir + "/" + ulke;
    }
}