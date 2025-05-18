import java.time.LocalDateTime;

public class Ucus {
    Lokasyon lokasyon;
    LocalDateTime saat;
    Ucak ucak;
    int kalanKoltuk;

    public Ucus(Lokasyon lokasyon, LocalDateTime saat, Ucak ucak) {
        this.lokasyon = lokasyon;
        this.saat = saat;
        this.ucak = ucak;
        this.kalanKoltuk = ucak.koltukKapasitesi;
    }

    public boolean koltukAyir() {
        if (kalanKoltuk > 0) {
            kalanKoltuk--;
            return true;
        }
        return false;
    }

    public String toString() {
        return lokasyon + " | Saat: " + saat.toString() + " | Uçak: " + ucak.toString() + " | Kalan Koltuk: " + kalanKoltuk;
    }
}