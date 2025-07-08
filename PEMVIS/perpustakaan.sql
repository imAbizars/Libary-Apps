-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 08, 2025 at 09:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `databuku`
--

CREATE TABLE `databuku` (
  `id_buku` varchar(100) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `nama_penulis` varchar(100) NOT NULL,
  `tahun_terbit` varchar(100) NOT NULL,
  `tebal_buku` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `databuku`
--

INSERT INTO `databuku` (`id_buku`, `judul_buku`, `nama_penulis`, `tahun_terbit`, `tebal_buku`) VALUES
('BK001', 'Pemrograman Java', 'Andi wijaya', '2021', '250'),
('BK003', 'Struktur Data', 'Budi Santosa', '2025', '275');

-- --------------------------------------------------------

--
-- Table structure for table `datapeminjaman`
--

CREATE TABLE `datapeminjaman` (
  `id_pinjam` varchar(255) NOT NULL,
  `id_buku` varchar(255) NOT NULL,
  `nama_buku` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `tahun_terbit` varchar(255) NOT NULL,
  `tebal_buku` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapeminjaman`
--

INSERT INTO `datapeminjaman` (`id_pinjam`, `id_buku`, `nama_buku`, `penerbit`, `tahun_terbit`, `tebal_buku`, `qty`) VALUES
('IN0001', 'BK001', 'Pemrograman Java', 'Andi wijaya', '2021', '250', 1),
('IN0002', 'BK003', 'Struktur Data', 'Budi Santosa', '2025', '275', 3);

-- --------------------------------------------------------

--
-- Table structure for table `datapetugas`
--

CREATE TABLE `datapetugas` (
  `id_petugas` varchar(8) NOT NULL,
  `nm_petugas` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapetugas`
--

INSERT INTO `datapetugas` (`id_petugas`, `nm_petugas`, `username`, `password`, `jenis`, `alamat`) VALUES
('admin1', 'rahul', 'rahul', 'fb469d7ef430b0baf0cab6c436e70375', 'Laki-Laki', 'depok'),
('admin2', 'kurnia', 'kurnia', '098f6bcd4621d373cade4e832627b4f6', 'Laki-Laki', 'depok'),
('DPP002', 'Rahul Dwi', 'Rahul', '01cfcd4f6b8770febfb40cb906715822', 'Laki-Laki', 'Jl.Tanah Merdeka'),
('DPP003', 'El Hazel', 'Hazel', '4e3e7abb40faf35536d7a520a7303510', 'Laki-Laki', 'Jl.Raya Tengah');

-- --------------------------------------------------------

--
-- Table structure for table `datasiswa`
--

CREATE TABLE `datasiswa` (
  `id_siswa` varchar(6) NOT NULL,
  `nm_siswa` varchar(25) NOT NULL,
  `kelas` varchar(15) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datasiswa`
--

INSERT INTO `datasiswa` (`id_siswa`, `nm_siswa`, `kelas`, `jenis`, `telepon`, `alamat`) VALUES
('DSP002', 'Wika Maulana', 'XI', 'Laki-Laki', '081216479852', 'Jl.Cempaka Emas'),
('DSP003', 'Franscesco igor', 'XII', 'Laki-Laki', '087894238846', 'Jl.Tanjung Raja');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` varchar(255) NOT NULL,
  `id_siswa` varchar(255) NOT NULL,
  `nm_siswa` varchar(255) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `id_petugas` varchar(255) NOT NULL,
  `totalbuku` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `id_siswa`, `nm_siswa`, `tgl_pinjam`, `id_petugas`, `totalbuku`) VALUES
('IN0001', 'DSP002', 'Wika Maulana', '2025-07-08', 'admin2', '1'),
('IN0002', 'DSP003', 'Franscesco igor', '2025-07-08', 'admin2', '3');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id` varchar(255) NOT NULL,
  `id_pinjam` varchar(255) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `id_siswa` varchar(255) NOT NULL,
  `nm_siswa` varchar(255) NOT NULL,
  `id_buku` varchar(255) NOT NULL,
  `nm_buku` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `tahunterbit` varchar(255) NOT NULL,
  `tebalhalaman` varchar(255) NOT NULL,
  `jumlah` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id`, `id_pinjam`, `tgl_pinjam`, `tgl_kembali`, `id_siswa`, `nm_siswa`, `id_buku`, `nm_buku`, `penerbit`, `tahunterbit`, `tebalhalaman`, `jumlah`) VALUES
('IN0001', 'IN0001', '2025-07-08', '2025-07-16', 'DSP002', 'Wika Maulana', 'BK001', 'Pemrograman Java', 'Andi wijaya', '2021', '250', '3'),
('IN0002', 'IN0002', '2025-07-08', '2025-07-31', 'DSP003', 'Franscesco igor', 'BK003', 'Struktur Data', 'Budi Santosa', '2025', '275', '2');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalianbuku`
--

CREATE TABLE `pengembalianbuku` (
  `id` varchar(255) NOT NULL,
  `idpinjam` varchar(255) NOT NULL,
  `idsiswa` varchar(255) NOT NULL,
  `nmsiswa` varchar(255) NOT NULL,
  `tglpinjam` varchar(255) NOT NULL,
  `tglkembali` varchar(255) NOT NULL,
  `denda` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalianbuku`
--

INSERT INTO `pengembalianbuku` (`id`, `idpinjam`, `idsiswa`, `nmsiswa`, `tglpinjam`, `tglkembali`, `denda`) VALUES
('IN0001', 'IN0001', 'DSP002', 'Wika Maulana', '2025-07-08', '2025-07-16', 'Rp 3000'),
('IN0002', 'IN0002', 'DSP003', 'Franscesco igor', '2025-07-08', '2025-07-31', 'Rp 5000');

-- --------------------------------------------------------

--
-- Table structure for table `rakbuku`
--

CREATE TABLE `rakbuku` (
  `id_rak` varchar(8) NOT NULL,
  `nomor_rak` varchar(10) NOT NULL,
  `baris_rak` varchar(10) NOT NULL,
  `kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rakbuku`
--

INSERT INTO `rakbuku` (`id_rak`, `nomor_rak`, `baris_rak`, `kategori`) VALUES
('RAK002', '05', 'B', 'Sejarah'),
('RAK003', '03', 'C', 'Pendidikan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `databuku`
--
ALTER TABLE `databuku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `datapetugas`
--
ALTER TABLE `datapetugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `datasiswa`
--
ALTER TABLE `datasiswa`
  ADD PRIMARY KEY (`id_siswa`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengembalianbuku`
--
ALTER TABLE `pengembalianbuku`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
