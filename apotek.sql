-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Des 2024 pada 05.40
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `id_obat` varchar(10) NOT NULL,
  `nama_obat` varchar(60) NOT NULL,
  `jenis_obat` varchar(15) NOT NULL,
  `indikasi` varchar(60) NOT NULL,
  `golongan` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `exp_date` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `jenis_obat`, `indikasi`, `golongan`, `harga`, `stok`, `exp_date`) VALUES
('00001', 'Paracetamol ', 'tablet', 'analgesik/antipiretik', 'Obat Bebas', 10000, 50, '12/29'),
('00002', 'Polysilane', 'syrup', 'antasida', 'Obat Bebas', 25000, 10, '03/29'),
('00003', 'Oralit', 'serbuk', 'diare', 'Obat Bebas', 5000, 50, '03/29'),
('00004', 'Decolgen', 'tablet', 'dekongestan & antihistamin', 'Obat Bebas', 5000, 10, '03/28'),
('00005', 'OBH Combi', 'syrup', 'expectorant', 'Obat Bebas', 50000, 5, '08/29'),
('00006', 'asam mefenamat', 'syrup', 'analgesik', 'Obat Bebas', 10000, 50, '08/29'),
('00007', 'Promag', 'tablet', 'antasida', 'Obat Bebas', 10000, 10, '10/29'),
('00008', 'CTM', 'tablet', 'antihistamin', 'Obat Bebas Terbatas', 3000, 50, '10/29'),
('00009', 'Siladex', 'syrup', 'antitusif ', 'Obat Bebas', 55000, 5, '12/29'),
('00010', 'vit C IPI', 'Tablet', 'Vitamin', 'Obat Bebas', 7000, 10, '12/29'),
('00011', 'Cetirizine HCL 10mg', 'tablet', 'antihistamin', 'Obat Bebas Terbatas', 15000, 50, '12/29'),
('00012', 'WOODS\'', 'syrup', 'expectorant', 'Obat Bebas Terbatas', 60000, 5, '12/29'),
('00013', 'Panadol Cold Flu ', 'kaplet', 'demam,flu dan antitusif', 'Obat Bebas Terbatas', 10000, 15, '12/29'),
('00014', 'Antimo', 'tablet', 'antivertigo,mual,pening', 'Obat Bebas Terbatas', 10000, 15, '09/28'),
('00015', 'VICKS Formula 44', 'syrup', 'expectorant', 'Obat Bebas Terbatas', 50000, 5, '12/29'),
('00016', 'Bodrex Flu&Batuk', 'kaplet', 'antihistamin & antitusif', 'Obat Bebas Terbatas', 10000, 10, '08/29'),
('00017', 'insto', 'Eye drop', 'antiinflamasi ', 'Obat Bebas Terbatas', 25000, 10, '12/29'),
('00018', 'Komix OBH', 'syrup', 'expectorant', 'Obat Bebas Terbatas', 3000, 20, '12/29'),
('00019', 'Benadryl', 'syrup', 'antihistamin ', 'Obat Bebas Terbatas', 30000, 10, '10/29'),
('00020', 'Proris drop', 'syrup', 'analgesik', 'Obat Bebas Terbatas', 35000, 5, '03/29'),
('00021', 'Ketorolac', 'eye drop', 'NSAID/Kortikosteroid', 'Obat Keras', 40000, 10, '12/29'),
('00022', 'Cefixime 200mg', 'kaplet', 'antibiotik', 'Obat Keras', 10000, 20, '12/29'),
('00023', 'Clopidogrel 75mg', 'kaplet', 'kardiovaskular', 'Obat Keras', 25000, 20, '12/30'),
('00024', 'Simvastatin 20mg', 'kaplet', 'kolesterol', 'Obat Keras', 15000, 20, '12/29'),
('00025', 'Simvastatin 10mg', 'kaplet', 'kolesterol', 'Obat Keras', 10000, 30, '12/29'),
('00026', 'omeprazole', 'kapsul', 'gastritis', 'Obat Keras', 20000, 30, '02/30'),
('00027', 'Amoxicillin', 'Tablet', 'antibiotik', 'Obat Keras', 15000, 50, '12/29'),
('00028', 'Amlodipine 5mg', 'tablet', 'hipertensi', 'Obat Keras', 20000, 50, '12/29'),
('00029', 'Amlodipine 10mg', 'tablet', 'hipertensi', 'Obat Keras', 15000, 50, '12/29'),
('00030', 'Metformin', 'tabel', 'diabetes II', 'Obat Keras', 10000, 50, '12/30'),
('00031', 'Miconazole', 'salep', 'infeksi Fungi', 'Obat Bebas Terbatas', 10000, 10, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` varchar(5) NOT NULL,
  `nama_pasien` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `alamat`, `no_telp`) VALUES
('0001', 'aziz', 'lio', '0987654345'),
('0002', 'joko', 'jl.mawar', '09876543456');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
