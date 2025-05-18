import java.util.*;
import java.time.LocalDateTime;

public class UcakRezervasyonApp {
    static List<Ucus> ucuslar = new ArrayList<>();
    static List<Rezervasyon> rezervasyonlar = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static DosyaYazici dosyaYazici;

    public static void main(String[] args) {
        verileriHazirla();

        System.out.println("Uçuş Listesi:");
        for (int i = 0; i < ucuslar.size(); i++) {
            System.out.println((i + 1) + ". " + ucuslar.get(i));
        }

        System.out.print("Lütfen uçuş seçiniz (numara): ");
        int secim = input.nextInt();
        input.nextLine();

        if (secim < 1 || secim > ucuslar.size()) {
            System.out.println("Geçersiz seçim yaptınız.");
            return;
        }

        Ucus secilen = ucuslar.get(secim - 1);
        if (secilen.kalanKoltuk == 0) {
            System.out.println("Bu uçuşta yer kalmamış.");
            return;
        }

        System.out.print("Adınız: ");
        String ad = input.nextLine();
        System.out.print("Soyadınız: ");
        String soyad = input.nextLine();
        System.out.print("Yaşınız: ");
        int yas = input.nextInt();

        if (secilen.koltukAyir()) {
            Rezervasyon rez = new Rezervasyon(ad, soyad, yas, secilen);
            rezervasyonlar.add(rez);
            System.out.println("Rezervasyon başarıyla yapıldı!");
        } else {
            System.out.println("Koltuk ayırtılamadı.");
        }

        System.out.println("Kaydetme formatını seçin: 1- TXT");
        int formatSec = input.nextInt();

        if (formatSec == 1) {
            dosyaYazici = new TxtDosyaYazici();
            dosyaYazici.yaz(rezervasyonlar);
        } else {
            System.out.println("Geçersiz seçim, varsayılan TXT kaydedilecek.");
            dosyaYazici = new TxtDosyaYazici();
            dosyaYazici.yaz(rezervasyonlar);
        }
    }

    private static void verileriHazirla() {
        Ucak u1 = new Ucak("737", "Boeing", "A001", 4);
        Ucak u2 = new Ucak("A320", "Airbus", "B002", 3);

        Lokasyon l1 = new Lokasyon("Türkiye", "İstanbul", "IST");
        Lokasyon l2 = new Lokasyon("Fransa", "Paris", "CDG");

        Ucus ucusA = new Ucus(l1, LocalDateTime.of(2025, 6, 10, 14, 0), u1);
        Ucus ucusB = new Ucus(l2, LocalDateTime.of(2025, 6, 11, 10, 30), u2);

        ucuslar.add(ucusA);
        ucuslar.add(ucusB);
    }
}