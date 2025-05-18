import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtDosyaYazici implements DosyaYazici {
    @Override
    public void yaz(List<Rezervasyon> rezervasyonListesi) {
        try {
            FileWriter fw = new FileWriter("rezervasyonlar.txt", true);
            for (Rezervasyon r : rezervasyonListesi) {
                fw.write(r.toString() + "\n");
            }
            fw.close();
            System.out.println("Rezervasyonlar .txt dosyasına kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya yazılırken hata oluştu.");
        }
    }
}