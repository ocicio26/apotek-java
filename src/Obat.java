public class Obat {
    private final int idObat;
    private final String nama;
    private final String golongan;
    private int stok;
    private final double harga;

    public Obat(int idObat, String nama, String golongan, int stok, double harga) {
        this.idObat = idObat;
        this.nama = nama;
        this.golongan = golongan;
        this.stok = stok;
        this.harga = harga;
    }

    public int getIdObat() {
        return idObat;
    }

    public String getNama() {
        return nama;
    }

    public String getGolongan() {
        return golongan;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    public double getHarga() {
        return harga;
    }
}
