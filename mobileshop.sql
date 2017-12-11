-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 11, 2017 at 01:26 PM
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
  KEY `fk_cthoadon_hoadon` (`hoa_don_id`),
  KEY `san_pham_id` (`san_pham_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ct_hoa_don`
--

INSERT INTO `ct_hoa_don` (`id`, `hoa_don_id`, `san_pham_id`, `so_luong`, `gia_ban`, `thanh_tien`) VALUES
(1, 1, 1, 1, 22490000, 22490000),
(2, 2, 2, 1, 20490000, 20490000),
(3, 2, 3, 1, 10690000, 10690000),
(4, 3, 4, 1, 6990000, 6990000),
(5, 3, 5, 1, 5990000, 5990000),
(6, 4, 6, 2, 4990000, 9980000),
(7, 5, 7, 1, 17990000, 17990000);

-- --------------------------------------------------------

--
-- Table structure for table `hang_san_xuat`
--

DROP TABLE IF EXISTS `hang_san_xuat`;
CREATE TABLE IF NOT EXISTS `hang_san_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hang_san_xuat`
--

INSERT INTO `hang_san_xuat` (`id`, `ten`) VALUES
(1, 'Samsung'),
(2, 'Oppo'),
(3, 'Huawei'),
(4, 'Sony'),
(5, 'HTC'),
(6, 'Apple');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`id`, `ten_khach_hang`, `so_dien_thoai`, `dia_chi`, `ghi_chu`, `tong_so_luong`, `tong_tien`, `ngay_lap_phieu`, `tinh_trang_id`, `trang_thai`) VALUES
(1, 'Mạc Khải Quân', '0909234898', '123 Hùng Vương F12 Q5', NULL, 1, 22490000, '2017-12-11 00:00:00', 2, b'1'),
(2, 'Nguyễn Tấn Quang', '0912888821', '321 Hồng Bàng F5 Q5', NULL, 2, 31180000, '2017-12-11 00:00:00', 2, b'1'),
(3, 'Trương Ngọc Thiên Thanh', '0978321888', '12/21 Trần Quang Khải F7 Q8', NULL, 2, 12980000, '2017-12-11 00:00:00', 2, b'1'),
(4, 'Diệp Tư Trình', '0120323888', '67 Lãnh Binh Thăng F3 Q11', NULL, 2, 9980000, '2017-12-11 00:00:00', 2, b'1'),
(5, 'Lý Kiều Quyên', '0120898272', '81 Âu Cơ F10 Q8', NULL, 1, 17990000, '2017-12-11 00:00:00', 1, b'1');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`id`, `ten`, `hang_id`, `hinh`, `so_luong`, `gia_ban`, `man_hinh`, `he_dieu_hanh`, `camera_sau`, `camera_truoc`, `cpu`, `ram`, `rom`, `the_nho`, `the_sim`, `pin`, `mo_ta`, `ngay_dang`, `trang_thai`) VALUES
(1, 'Samsung Galaxy Note 8', 1, 'samsunggalaxynote8.png', 10, 22490000, 'Super AMOLED, 6.3\", Quad HD (2K)', 'Android 7.1', '12MP', '8MP', 'Exynos 8895 8 nhân 64 bit', '6GB', '64GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, hỗ trợ 4G', '3300 mAh, có sạc nhanh', 'Galaxy Note 8 là niềm hy vọng vực lại dòng Note danh tiếng của Samsung với diện mạo nam tính, sang trọng. Trang bị camera kép xóa phông thời thượng, màn hình vô cực như trên S8 Plus, bút Spen với nhiều tính năng mới và nhiều công nghệ được Samsung ưu ái đem lên Note 8.', '2017-12-11 00:00:00', b'1'),
(2, 'Samsung Galaxy S8 Plus', 1, 'samsunggalaxys8plus.png', 10, 20490000, 'Super AMOLED, 6.2\", Quad HD (2K)', 'Android 7.0', '12MP', '8MP', 'Exynos 8895 8 nhân 64 bit', '4GB', '64GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, (SIM 2 chung khe thẻ nhớ), hỗ trợ 4G', '3500 mAh, có sạc nhanh', 'Galaxy S8 và S8 Plus hiện đang là chuẩn mực smartphone về thiết kế trong tương lai. Sau nhiều ngày được sử dụng, mình xin chia sẻ những cảm nhận chi tiết nhất về chiếc Galaxy S8 Plus - thiết bị đang có doanh số đặt hàng khủng nhất hiện tại.', '2017-12-11 00:00:00', b'1'),
(3, 'Oppo F3 Plus', 2, 'oppof3plus.png', 10, 10690000, 'IPS LCD, 6.0\", Full HD', 'Android 6.0', '16MP', '16MP va2 8MP', 'Snapdragon 653 8 nhân 64 bit', '4GB', '64GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, hỗ trợ 4G', '4000 mAh, có sạc nhanh', 'Sau sự thành công của F1 Plus, OPPO F3 Plus đang được người dùng quan tâm yêu thích với cụm camera selfie kép, công nghệ chụp thiếu sáng đỉnh cao, cấu hình mạnh mẽ và tất nhiên đó là thiết kế nguyên khối quá ư là sang trọng.', '2017-12-11 00:00:00', b'1'),
(4, 'Oppo F5 ', 2, 'oppof5.png', 10, 6990000, 'IPS LCD, 6.0\", Full HD', 'Android 7.1', '16MP', '20MP', 'Mediatek Helio P23', '4GB', '32GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, hỗ trợ 4G', '3200 mAh', 'Chuyên gia selfie mới nổi bật với màn hình tràn cạnh thời trang và camera tích hợp trí tuệ nhân tạo AI để càng chụp càng đẹp.', '2017-12-11 00:00:00', b'1'),
(5, 'Huawei Nova 2i', 3, 'huaweinova2i.png', 10, 5990000, 'IPS LCD, 5.9\", Full HD', 'Android 7.0', '16 MP và 2 MP', '13 MP và 2 MP', 'HiSilicon Kirin 659 8 nhân', '4GB', '64GB', 'MicroSD hỗ trợ tối đa 128GB', '2 Nano SIM, hỗ trợ 4G', '3340 mAh', 'Huawei Nova 2i là chiếc smartphone phổ thông có thiết kế màn hình tràn cạnh đẹp mắt, 4 camera (2 camera kép) và hiệu năng khá tốt, đây là sự lựa chọn tuyệt vời trong tầm giá.', '2017-12-11 00:00:00', b'1'),
(6, 'Huawei Y7 Prime', 3, 'huaweiy7prime.png', 10, 4990000, 'IPS LCD, 5.5\", Full HD', 'Android 7.0', '12MP', '8MP', 'Snapdragon 435 8 nhân', '3GB', '32GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, hỗ trợ 4G', '4000 mAh', 'Huawei đã chính thức giới thiệu đến người dùng điện thoại mới mang tên Y7 Prime, mẫu smartphone kế nhiệm của Y6 Prime được ra mắt vào năm ngoái.', '2017-12-11 00:00:00', b'1'),
(7, 'Sony Xperia XZ Premium', 4, 'sonyxperiaxzpremium.png', 10, 17990000, 'IPS LCD, 5.5\", Full HD', 'Android 7.1', '19MP', '13MP', 'Qualcomm Snapdragon 835 8 nhân 64 bit', '4GB', '64GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, (SIM 2 chung khe thẻ nhớ), hỗ trợ 4G', '3230 mAh', 'Sony Xperia XZ Premium là flagship của Sony trong năm 2017 với vẻ ngoài hào nhoáng, màn hình cao cấp cũng nhiều trang bị hàng đầu khác.', '2017-12-11 00:00:00', b'1'),
(8, 'Sony Xperia XZ Dual', 4, 'sonyxperiaxzdual.png', 10, 9990000, 'TRILUMINOS, 5.2\", Full HD', 'Anroid 7.0', '23MP', '13MP', 'Snapdragon 820 4 nhân 64 bit', '3GB', '64GB', 'MicroSD hỗ trợ tối đa 256GB', '2 Nano SIM, (SIM 2 chung khe thẻ nhớ), hỗ trợ 4G', '2900 mAh', 'Sony Xperia XZ với thiết kế cực đẹp, cùng camera chất lượng hơn, nhiều tính năng tiện ích hơn.', '2017-12-11 00:00:00', b'1'),
(9, 'HTC U11', 5, 'htcu11.png', 10, 16990000, 'Super LCD, 5.5\", Quad HD (2K)', 'Android 7.1', '12MP', '16MP', 'Qualcomm Snapdragon 835 8 nhân 64 bit', '6GB', '128GB', 'MicroSD hỗ trợ tối đa 2TB', '2 Nano SIM, hỗ trợ 4G', '3000 mAh', 'HTC U11 là smartphone cao cấp nhất của HTC trong năm 2017 ', '2017-12-11 00:00:00', b'1'),
(10, 'HTC U Play', 5, 'htcuplay.png', 10, 6990000, 'Super LCD, 5.2\", Full HD', 'Android 6.0', '16MP', '16MP', 'MTK Helio P10 8 nhân 64 bit', '3GB', '32GB', 'MicroSD hỗ trợ tối đa 2TB', '2 Nano SIM, hỗ trợ 4G', '2500 mAh', 'HTC U Play đánh dấu sự trở lại của HTC ở phân khúc tầm trung với triết lý thiết kế mới: đẹp hơn - sang trọng hơn - bóng bẩy hơn, ngoài ra trải nghiệm người dùng được nâng cấp thông qua trợ lý ảo HTC Sense Companion.', '2017-12-11 00:00:00', b'1'),
(11, 'HTC Desire 10 Pro', 5, 'htcdesire10pro.png', 10, 5990000, 'IPS LCD, 5.5\", Full HD', 'Android 6.0', '20MP', '13MP', 'MTK Helio P10 8 nhân 64 bit', '4GB', '64GB', 'MicroSD hỗ trợ tối đa 2TB', '2 Nano SIM, hỗ trợ 4G', '3000 mAh', 'HTC Desire 10 Pro là smartphone tầm trung mới của HTC với thiết kế trẻ trung năng động, cấu hình mạnh mẽ với RAM 4 GB và bộ nhớ trong 64 GB hứa hẹn sẽ đem lại trải nghiệm tuyệt vời cho người dùng.', '2017-12-11 00:00:00', b'1'),
(12, 'Iphone 8 Plus 256GB', 6, 'iphone8plus256gb.png', 10, 28790000, 'LED-backlit IPS LCD, 5.5\", Retina HD', 'iOS 11', '12 MP và 12 MP', '7 MP', 'Apple A11 Bionic 6 nhân', '3GB', '256GB', 'không hỗ trợ', '1 Nano SIM, hỗ trợ 4G', '2691 mAh', 'Thừa hưởng thiết kế đã đạt đến độ chuẩn mực, thế hệ iPhone 8 Plus thay đổi phong cách bóng bẩy hơn và bổ sung hàng loạt tính năng cao cấp cho trải nghiệm sử dụng vô cùng tuyệt vời.', '2017-12-11 00:00:00', b'1'),
(13, 'Iphone 7 Plus 256GB', 6, 'iphone7plus256gb.png', 10, 19990000, 'LED-backlit IPS LCD, 5.5\", Retina HD', 'iOS 10', '12 MP và 12 MP', '7MP', 'Apple A10 Fushion 4 nhân 64 bit', '3GB', '256GB', 'không hỗ trợ', '1 Nano SIM, hỗ trợ 4G', '2900 mAh', 'Với thiết kế không quá nhiều thay đổi, vẫn bảo tồn vẻ đẹp truyền thống từ thời iPhone 6 Plus,  iPhone 7 Plus được trang bị nhiều nâng cấp đáng giá như camera kép, đạt chuẩn chống nước chống bụi cùng cấu hình cực mạnh.', '2017-12-11 00:00:00', b'1'),
(14, 'Iphone 6s 128GB', 6, 'iphone6s28gb.png', 10, 16990000, 'LED-backlit IPS LCD, 4.7\", Retina HD', 'iOS 10', '12MP', '5MP', 'Apple A9 2 nhân 64 bit', '2GB', '128GB', 'không hỗ trợ', '1 Nano SIM, hỗ trợ 4G', '1715 mAh', 'iPhone 6s xứng đáng là phiên bản nâng cấp hoàn hảo từ iPhone 6 với nhiều tính năng mới hấp dẫn.', '2017-12-11 00:00:00', b'1'),
(15, 'Iphone 5s 16GB', 6, 'iphone5s16gb.png', 10, 5990000, 'LED-backlit IPS LCD, 4\", DVGA', 'iOS 10', '8MP', '1.2MP', 'Apple A7 2 nhân 64 bit', '1GB', '16GB', 'không hỗ trợ', '2 Nano SIM, hỗ trợ 4G', '1560 mAh', 'Thiết kế sang trọng, gia công tỉ mỉ, tích hợp cảm biến vân tay cao cấp hơn, camera cho hình ảnh đẹp và sáng hơn.', '2017-12-11 00:00:00', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `tinh_trang`
--

DROP TABLE IF EXISTS `tinh_trang`;
CREATE TABLE IF NOT EXISTS `tinh_trang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mo_ta` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

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
  ADD CONSTRAINT `fk_cthoadon_hoadon` FOREIGN KEY (`hoa_don_id`) REFERENCES `hoa_don` (`id`),
  ADD CONSTRAINT `fk_cthoadon_sanpham` FOREIGN KEY (`san_pham_id`) REFERENCES `san_pham` (`id`);

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
