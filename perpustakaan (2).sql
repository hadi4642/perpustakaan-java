-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 16, 2022 at 12:32 PM
-- Server version: 5.7.33
-- PHP Version: 8.0.15

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
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `nim` varchar(255) NOT NULL,
  `nama_anggota` varchar(255) NOT NULL,
  `tempat_lahir` varchar(255) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`nim`, `nama_anggota`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `no_telp`, `alamat`) VALUES
('H201600435', 'Ferdian', 'Samarinda', '2011-06-03', 'Laki-Laki', '08234234', 'Bumi	');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `no_induk_buku` varchar(255) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `pengarang` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `kategori_id` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tersedia` int(11) NOT NULL,
  `keluar` int(11) NOT NULL,
  `tahun_terbit` varchar(4) NOT NULL,
  `no_klasifikasi` varchar(255) NOT NULL,
  `lokasi_buku` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`no_induk_buku`, `judul`, `pengarang`, `penerbit`, `kategori_id`, `jumlah`, `tersedia`, `keluar`, `tahun_terbit`, `no_klasifikasi`, `lokasi_buku`) VALUES
('0001', 'Bukan untuk dibaca', 'Ferdi As', 'Gusti As', 'K1 ', 100, 100, 0, '2002', '12345', 'Rak'),
('0002', 'Untuk untuk dibaca', 'Ferdi As', 'Gusti As', 'K1 ', 100, 99, 1, '2002', '12345', 'Rak');

-- --------------------------------------------------------

--
-- Table structure for table `denda`
--

CREATE TABLE `denda` (
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `denda`
--

INSERT INTO `denda` (`jumlah`) VALUES
(500);

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE `detail_peminjaman` (
  `no_peminjaman` varchar(255) NOT NULL,
  `no_induk_buku` varchar(255) NOT NULL,
  `status` enum('Dipinjam','Kembali') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`no_peminjaman`, `no_induk_buku`, `status`) VALUES
('PJM-1', '0002', 'Kembali'),
('PJM-1', '0001', 'Kembali'),
('PJM-2', '0002', 'Kembali'),
('PJM-3', '0002', 'Kembali'),
('PJM-3', '0001', 'Kembali'),
('PJM-4', '0001', 'Kembali'),
('PJM-4', '0002', 'Kembali'),
('PJM-5', '0001', 'Kembali'),
('PJM-5', '0002', 'Kembali'),
('PJM-6', '0002', 'Dipinjam');

-- --------------------------------------------------------

--
-- Table structure for table `detail_pengembalian`
--

CREATE TABLE `detail_pengembalian` (
  `no_peminjaman` varchar(255) NOT NULL,
  `no_induk_buku` varchar(255) NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `denda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_pengembalian`
--

INSERT INTO `detail_pengembalian` (`no_peminjaman`, `no_induk_buku`, `tanggal_kembali`, `denda`) VALUES
('PJM-1', '0002', '2022-06-15', 0),
('PJM-1', '0001', '2022-06-15', 0),
('PJM-2', '0002', '2022-06-15', 1500),
('PJM-3', '0002', '2022-06-15', 2000),
('PJM-3', '0001', '2022-06-15', 2000),
('PJM-4', '0002', '2022-06-15', 0),
('PJM-4', '0001', '2022-06-15', 0),
('PJM-5', '0001', '2022-06-15', 2000),
('PJM-5', '0002', '2022-06-15', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id` varchar(255) NOT NULL,
  `nama_kategori` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `nama_kategori`) VALUES
('K1', 'Petualangan'),
('K2', 'Romantis');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `no_peminjaman` varchar(255) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `batas_pengembalian` date NOT NULL,
  `total_buku` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`no_peminjaman`, `nim`, `tanggal_pinjam`, `batas_pengembalian`, `total_buku`) VALUES
('PJM-1', 'H201600435', '2022-06-15', '2022-06-21', 2),
('PJM-2', 'H201600435', '2022-06-10', '2022-06-12', 1),
('PJM-3', 'H201600435', '2022-06-04', '2022-06-11', 2),
('PJM-4', 'H201600435', '2022-06-15', '2022-06-21', 2),
('PJM-5', 'H201600435', '2022-06-04', '2022-06-11', 2),
('PJM-6', 'H201600435', '2022-06-15', '2022-06-21', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `no_peminjaman` varchar(255) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `total_denda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`no_peminjaman`, `nim`, `tanggal_kembali`, `total_denda`) VALUES
('PJM-1', 'H201600435', '2022-06-15', 0),
('PJM-2', 'H201600435', '2022-06-15', 1500),
('PJM-3', 'H201600435', '2022-06-15', 4000),
('PJM-4', 'H201600435', '2022-06-15', 0),
('PJM-5', 'H201600435', '2022-06-15', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` varchar(255) NOT NULL,
  `nama_pengguna` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama_pengguna`, `username`, `password`, `no_telp`, `alamat`) VALUES
('P1', 'admin', 'admin', 'admin', '08234324234', 'Bumi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`no_induk_buku`),
  ADD KEY `kategori_id` (`kategori_id`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD KEY `detail_peminjaman_no_peminjaman_index` (`no_peminjaman`),
  ADD KEY `detail_peminjaman_no_induk_buku_index` (`no_induk_buku`);

--
-- Indexes for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD KEY `detail_pengembalian_no_peminjaman_index` (`no_peminjaman`),
  ADD KEY `detail_pengembalian_no_induk_buku_index` (`no_induk_buku`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`no_peminjaman`),
  ADD KEY `peminjaman_nim_index` (`nim`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD KEY `pengembalian_no_peminjaman_index` (`no_peminjaman`),
  ADD KEY `pengembalian_nim_index` (`nim`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`kategori_id`) REFERENCES `kategori` (`id`);

--
-- Constraints for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
  ADD CONSTRAINT `detail_peminjaman_ibfk_1` FOREIGN KEY (`no_peminjaman`) REFERENCES `peminjaman` (`no_peminjaman`),
  ADD CONSTRAINT `detail_peminjaman_ibfk_2` FOREIGN KEY (`no_induk_buku`) REFERENCES `buku` (`no_induk_buku`);

--
-- Constraints for table `detail_pengembalian`
--
ALTER TABLE `detail_pengembalian`
  ADD CONSTRAINT `detail_pengembalian_ibfk_1` FOREIGN KEY (`no_peminjaman`) REFERENCES `peminjaman` (`no_peminjaman`),
  ADD CONSTRAINT `detail_pengembalian_ibfk_2` FOREIGN KEY (`no_induk_buku`) REFERENCES `buku` (`no_induk_buku`);

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `anggota` (`nim`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`no_peminjaman`) REFERENCES `peminjaman` (`no_peminjaman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
