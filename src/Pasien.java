public class Pasien {
    private String idPasien;
    private String namaPasien;
    private String alamat;
    private String noTelp;
    private boolean membawaResep;

    // Constructor
    public Pasien(String idPasien, String namaPasien, String alamat, String noTelp, boolean membawaResep) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.membawaResep = membawaResep;
    }

    // Getters and setters
    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public boolean isMembawaResep() {
        return membawaResep;
    }

    public void setMembawaResep(boolean membawaResep) {
        this.membawaResep = membawaResep;
    }
}
