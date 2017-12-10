-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 10, 2017 at 05:36 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobileshop`
--
CREATE DATABASE IF NOT EXISTS `mobileshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `mobileshop`;

-- --------------------------------------------------------

--
-- Table structure for table `ct_hoa_don`
--

DROP TABLE IF EXISTS `ct_hoa_don`;
CREATE TABLE IF NOT EXISTS `ct_hoa_don` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoa_don_id` int(11) NOT NULL,
  `san_pham_id` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia_ban` float NOT NULL,
  `thanh_tien` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cthoadon_hoadon` (`hoa_don_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hang_san_xuat`
--

DROP TABLE IF EXISTS `hang_san_xuat`;
CREATE TABLE IF NOT EXISTS `hang_san_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
CREATE TABLE IF NOT EXISTS `hoa_don` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_khach_hang` varchar(250) NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `dia_chi` varchar(500) NOT NULL,
  `ghi_chu` varchar(500) DEFAULT NULL,
  `tong_so_luong` int(11) DEFAULT NULL,
  `tong_tien` float DEFAULT NULL,
  `ngay_lap_phieu` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tinh_trang_id` int(11) NOT NULL,
  `trang_thai` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_hoadon_tinhtrang` (`tinh_trang_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
CREATE TABLE IF NOT EXISTS `san_pham` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(250) NOT NULL,
  `hang_id` int(11) NOT NULL,
  `hinh` varchar(250) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia_ban` float NOT NULL,
  `man_hinh` varchar(250) NOT NULL,
  `he_dieu_hanh` varchar(250) NOT NULL,
  `camera_sau` varchar(250) NOT NULL,
  `camera_truoc` varchar(250) DEFAULT NULL,
  `cpu` varchar(250) NOT NULL,
  `ram` varchar(250) NOT NULL,
  `rom` varchar(250) NOT NULL,
  `the_nho` varchar(250) NOT NULL,
  `the_sim` varchar(250) NOT NULL,
  `pin` varchar(250) NOT NULL,
  `mo_ta` varchar(1000) NOT NULL,
  `ngay_dang` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `trang_thai` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_sanpham_hang` (`hang_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tinh_trang`
--

DROP TABLE IF EXISTS `tinh_trang`;
CREATE TABLE IF NOT EXISTS `tinh_trang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mo_ta` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tinh_trang`
--

INSERT INTO `tinh_trang` (`id`, `mo_ta`) VALUES
(1, 'Đang xử lí'),
(2, 'Đã giao'),
(3, 'Đã hủy');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_hoa_don`
--
ALTER TABLE `ct_hoa_don`
  ADD CONSTRAINT `fk_cthoadon_hoadon` FOREIGN KEY (`hoa_don_id`) REFERENCES `ct_hoa_don` (`id`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `fk_hoadon_tinhtrang` FOREIGN KEY (`tinh_trang_id`) REFERENCES `tinh_trang` (`id`);

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `fk_sanpham_hang` FOREIGN KEY (`hang_id`) REFERENCES `hang_san_xuat` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
