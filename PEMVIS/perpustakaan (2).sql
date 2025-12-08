-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 08, 2025 at 03:25 AM
-- Server version: 8.0.30
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
  `id_buku` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `judul_buku` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_penulis` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tahun_terbit` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `tebal_buku` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `databuku`
--

INSERT INTO `databuku` (`id_buku`, `judul_buku`, `nama_penulis`, `tahun_terbit`, `tebal_buku`) VALUES
('buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('MDLG1', 'Madilog', 'Tan Malaka', '1960', '120');

-- --------------------------------------------------------

--
-- Table structure for table `datapetugas`
--

CREATE TABLE `datapetugas` (
  `id_petugas` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `nm_petugas` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `jenis` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapetugas`
--

INSERT INTO `datapetugas` (`id_petugas`, `nm_petugas`, `username`, `password`, `jenis`, `alamat`) VALUES
('admin1', 'rahul', 'rahul', 'fb469d7ef430b0baf0cab6c436e70375', 'Laki-Laki', 'depok'),
('admin2', 'kurnia', 'kurnia', '098f6bcd4621d373cade4e832627b4f6', 'Laki-Laki', 'depok'),
('admin3', 'Abizar', 'abizar', '99a85cdbdda267f60f881d37fe46e7ea', 'Laki-Laki', 'bekasi');

-- --------------------------------------------------------

--
-- Table structure for table `datasiswa`
--

CREATE TABLE `datasiswa` (
  `id_siswa` varchar(6) COLLATE utf8mb4_general_ci NOT NULL,
  `nm_siswa` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `kelas` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `jenis` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `telepon` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `alamat` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datasiswa`
--

INSERT INTO `datasiswa` (`id_siswa`, `nm_siswa`, `kelas`, `jenis`, `telepon`, `alamat`) VALUES
('1733', 'Dennis Abizar', 'R6S', 'Laki-Laki', '08121213', 'Bekasi'),
('20211', 'kurnia', 'r6s', 'Laki-Laki', '0895', 'depok');

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `id_detail` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `id_peminjaman` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_buku` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nama_buku` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `penerbit` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tahun_terbit` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tebal_buku` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id_detail`, `id_peminjaman`, `id_buku`, `nama_buku`, `penerbit`, `tahun_terbit`, `tebal_buku`) VALUES
('PMJ0002-DT001', 'PMJ0002', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0002-DT002', 'PMJ0002', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0003-DT001', 'PMJ0003', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0003-DT002', 'PMJ0003', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0004-DT001', 'PMJ0004', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0004-DT002', 'PMJ0004', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0005-DT001', 'PMJ0005', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0005-DT002', 'PMJ0005', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0006-DT001', 'PMJ0006', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0006-DT002', 'PMJ0006', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0007-DT001', 'PMJ0007', 'buku2', 'Nyali untuk beristri 4', 'Kurnia Setiawan', '2004', '20'),
('PMJ0007-DT002', 'PMJ0007', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0008-DT001', 'PMJ0008', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120'),
('PMJ0009-DT001', 'PMJ0009', 'MDLG1', 'Madilog', 'Tan Malaka', '1960', '120');

-- --------------------------------------------------------

--
-- Table structure for table `detail_pengembalian`
--

CREATE TABLE `detail_pengembalian` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_pengembalian` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_buku` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_buku` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `kondisi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsifisik` text COLLATE utf8mb4_general_ci NOT NULL,
  `denda` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_pengembalian`
--

INSERT INTO `detail_pengembalian` (`id`, `id_pengembalian`, `id_buku`, `nama_buku`, `kondisi`, `deskripsifisik`, `denda`) VALUES
('IN0001-DT001', 'IN0001', 'MDLG1', 'Madilog', 'rusak', 'yes king aaaawhhhh', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `id_siswa` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nama_siswa` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `kelas` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telp` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_kembali` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `tgl_pinjam`, `id_siswa`, `nama_siswa`, `kelas`, `telp`, `tgl_kembali`) VALUES
('PMJ0002', '2025-11-28', '1733', 'Dennis Abizar', 'R6S', '08121213', '2025-12-28'),
('PMJ0003', '2025-11-30', '1733', 'Dennis Abizar', 'R6S', '08121213', '2025-12-30'),
('PMJ0004', '2025-11-30', '20211', 'kurnia', 'r6s', '0895', '2025-12-30'),
('PMJ0005', '2025-11-30', '20211', 'kurnia', 'r6s', '0895', '2025-12-30'),
('PMJ0006', '2025-11-30', '20211', 'kurnia', 'r6s', '0895', '2025-12-30'),
('PMJ0007', '2025-11-30', '1733', 'Dennis Abizar', 'R6S', '08121213', '2025-12-30'),
('PMJ0008', '2025-12-08', '1733', 'Dennis Abizar', 'R6S', '08121213', '2026-01-07'),
('PMJ0009', '2025-12-08', '1733', 'Dennis Abizar', 'R6S', '08121213', '2026-01-07');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_siswa` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_siswa` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_kembali` date NOT NULL,
  `total_denda` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id`, `id_siswa`, `nama_siswa`, `tgl_kembali`, `total_denda`) VALUES
('IN0001', '1733', 'Dennis Abizar', '2025-12-04', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `rakbuku`
--

CREATE TABLE `rakbuku` (
  `id_rak` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `nomor_rak` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `baris_rak` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `kategori` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_peminjaman` (`id_peminjaman`);

--
-- Indexes for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pengembalian` (`id_pengembalian`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD CONSTRAINT `detail_peminjaman_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD CONSTRAINT `detail_pengembalian_ibfk_1` FOREIGN KEY (`id_pengembalian`) REFERENCES `pengembalian` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
