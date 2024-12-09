import java.sql.*;
import java.util.Scanner;

public class MainApotek {
    private static Connection connectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/apotek";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    private static void tampilkanMenu() {
        System.out.println("==== Menu Apotek ====");
        System.out.println("1. Tambah Pasien");
        System.out.println("2. Tambah Obat");
        System.out.println("3. Update Stok Obat");
        System.out.println("4. Tampilkan Data Pasien");
        System.out.println("5. Stok Obat");
        System.out.println("6. Transaksi");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu: ");
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = connectDB();

        if (conn == null) {
            System.out.println("Database connection failed. Program terminated.");
            return;
        }

        boolean running = true;

        while (running) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: {
                    System.out.println();
                    System.out.print("Membawa Resep (true/false): ");
                    boolean membawaResep = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println();
                    System.out.print("ID Pasien: ");
                    String idPasien = scanner.nextLine();
                    System.out.print("Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Nomor Telepon: ");
                    String noTelp = scanner.nextLine();
                    System.out.println();

                    Pasien pasienBaru = new Pasien(idPasien, nama, alamat, noTelp, membawaResep);//objek pasien

                    try {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO pasien (id_pasien, nama_pasien, alamat, no_telp) VALUES (?, ?, ?, ?)");
                        stmt.setString(1, pasienBaru.getIdPasien());
                        stmt.setString(2, pasienBaru.getNamaPasien());
                        stmt.setString(3, pasienBaru.getAlamat());
                        stmt.setString(4, pasienBaru.getNoTelp());
                        stmt.executeUpdate();
                        System.out.println();
                        System.out.println("Pasien berhasil ditambahkan!");
                        System.out.println();
                    } catch (SQLException e) {
                        System.out.println("Gagal menambahkan pasien: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                    }
                case 2: {
                    System.out.print("ID Obat: ");
                    String id = scanner.nextLine();
                    System.out.print("Nama Obat: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jenis Obat: ");
                    String jenis = scanner.nextLine();
                    System.out.print("Indikasi Obat: ");
                    String indikasi = scanner.nextLine();
                    System.out.print("Golongan Obat : ");
                    String golongan = scanner.nextLine();
                    System.out.print("Stok: ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Harga: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Expired Date: ");
                    String expDate = scanner.nextLine();
                    System.out.println();
                            

                    try {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO obat (id_obat, nama_obat,jenis_obat,indikasi, golongan, stok, harga, exp_date) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
                        stmt.setString(1, id);
                        stmt.setString(2, nama);
                        stmt.setString(3, jenis);
                        stmt.setString(4, indikasi);
                        stmt.setString(5, golongan);
                        stmt.setInt(6, stok);
                        stmt.setDouble(7, harga);
                        stmt.setString(8,expDate);
                        stmt.executeUpdate();
                        
                        System.out.println();
                        System.out.println("Obat berhasil ditambahkan!");
                        System.out.println();
                    } catch (SQLException e) {
                        System.out.println("Gagal menambahkan obat: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                }
                case 3:{
                    System.out.print("Masukkan ID Obat : ");
                    String id = scanner.nextLine();
                    System.out.print("Tambahkan Stok : ");
                    int stokBaru = scanner.nextInt();
                    
                    try {
                        PreparedStatement checkStmt = conn.prepareStatement("SELECT stok FROM obat WHERE id_obat = ?");
                        checkStmt.setString(1, id);
                        ResultSet rs = checkStmt.executeQuery();
                        
                        if (rs.next()){
                            int stokLama = rs.getInt("stok");
                            int stokUpdate = stokLama + stokBaru;
                            
                            PreparedStatement updateStmt = conn.prepareStatement("UPDATE obat SET stok =? WHERE id_obat =?");
                            updateStmt.setInt(1, stokUpdate);
                            updateStmt.setString(2, id);
                            updateStmt.executeUpdate();
                            
                            System.out.println("Stok Berhasil Diperbarui, Stok Baru : "+ stokUpdate);
                        }else{
                            System.out.println("Obat Dengan ID "+id+" Tidak Ditemukan");
                        }
                    }catch (SQLException e){
                        System.out.println("Gagal Memperbarui Stok : " + e.getMessage());
                    }
                    break;
                }
                 case 4: {
                    try {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM pasien");
                        System.out.println();
                        System.out.println("==== Data Pasien ====");
                        while (rs.next()) {
                        System.out.println("ID Pasien: " + rs.getString("id_pasien"));
                        System.out.println("Nama: " + rs.getString("nama_pasien"));
                        System.out.println("Alamat: " + rs.getString("alamat"));
                        System.out.println("Nomor telepon : " + rs.getString("no_telp"));
                        System.out.println("------------------------");
                        System.out.println();
                        }
                    } catch (SQLException e) {
                        System.out.println("Gagal menampilkan data pasien: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                }
                case 5: {
                    System.out.println();
                    System.out.print("Masukkan Golongan Obat (Obat bebas, Obat Bebas terbatas,Obat Keras): ");
                    String golongan = scanner.nextLine();
                    System.out.println();

                    try {
                        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM obat WHERE golongan = ?");
                        stmt.setString(1, golongan);
                        ResultSet rs = stmt.executeQuery();
                        
                        System.out.println();
                        System.out.println("Daftar Obat Golongan " + golongan + ":");
                        while (rs.next()) {
                            System.out.println();
                            System.out.println("ID Obat: " + rs.getString("id_obat") + "\t Nama Obat: " + rs.getString("nama_obat") + "\t Indikasi Obat : " + rs.getString("indikasi") +
                            "\t Stok: " + rs.getInt("stok") + "\t Harga: " + rs.getDouble("harga")+ "\t Expired Date : " + rs.getString("exp_date"));
                            System.out.println();
                        }
                    } catch (SQLException e) {
                        System.out.println("Gagal mengambil data obat: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                }
                case 6: {
                    System.out.println();
                    System.out.print("Masukkan Nama Obat: ");
                    int namaObat = scanner.nextInt();
                    System.out.print("Masukkan Jumlah: ");
                    int jumlah = scanner.nextInt();
                    System.out.println();

                    try {
                        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM obat WHERE nama_obat = ?");
                        stmt.setInt(1, namaObat);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            String nama = rs.getString("nama_obat");
                            String golongan = rs.getString("golongan");
                            int stok = rs.getInt("stok");
                            double harga = rs.getDouble("harga");

                            if (stok >= jumlah) {
                                Transaksi transaksi = new Transaksi();//objek tranksaksi
                                double totalHarga = transaksi.hitungTotalHarga(harga * jumlah, golongan);

                                PreparedStatement updateStok = conn.prepareStatement("UPDATE obat SET stok = ? WHERE id_obat = ?");
                                updateStok.setInt(1, stok - jumlah);
                                updateStok.setInt(2, namaObat);
                                updateStok.executeUpdate();
                                
                                System.out.println();
                                System.out.println("Transaksi berhasil!");
                                System.out.println("Nama Obat: " + nama);
                                System.out.println("Jumlah: " + jumlah);
                                System.out.println("Total Harga: " + totalHarga);
                                System.out.println();
                            } else {
                                System.out.println("Stok tidak mencukupi.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("Obat tidak ditemukan.");
                            System.out.println();
                        }
                    } catch (SQLException e) {
                        System.out.println("Gagal melakukan transaksi: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                }
                case 7: {
                    running = false;
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid.");
                    System.out.println();
                }
            }
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi: " + e.getMessage());
            System.out.println();
        }

        System.out.println("Program selesai.");
    }
}
