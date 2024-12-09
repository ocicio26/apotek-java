public class Transaksi {
    public double hitungTotalHarga(double hargaObat, String golongan) {
        double margin = 0.1;
        if (golongan.equalsIgnoreCase("keras")) {
            margin = 0.2;
        }
        return hargaObat + (hargaObat * 0.1) + (hargaObat * margin);
    }
}
