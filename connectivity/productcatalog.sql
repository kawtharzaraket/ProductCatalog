-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 19, 2021 at 08:25 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `productcatalog`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `CommentId` int(11) NOT NULL AUTO_INCREMENT,
  `UID` varchar(11) NOT NULL,
  `Comment` longtext NOT NULL,
  PRIMARY KEY (`CommentId`),
  KEY `UID` (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`CommentId`, `UID`, `Comment`) VALUES
(1, '1', 'beautiful'),
(2, '2', 'nicee'),
(3, '2', 'VERRRY GOOD QUALTIY!'),
(4, '2', 'VERRRY GOOD QUALTIY!'),
(5, '2', 'beautyyyy');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `PID` varchar(11) NOT NULL,
  `UID` varchar(11) NOT NULL,
  `Quantity` varchar(11) NOT NULL,
  PRIMARY KEY (`PID`,`UID`),
  KEY `UID` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`PID`, `UID`, `Quantity`) VALUES
('13', '2', '2'),
('15', '2', '1'),
('8', '2', '1');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` varchar(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Category` varchar(10) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `Price` varchar(11) NOT NULL,
  `Size` varchar(2) DEFAULT NULL,
  `Description` text,
  `ImgPath` text,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductId`, `Name`, `Type`, `Category`, `Color`, `Price`, `Size`, `Description`, `ImgPath`) VALUES
('1', 'Pure Pineapple', 'Sweater', 'Women', 'Orange', '34', 'M', 'Wool Woman Sweater', 'img\\products\\women-1.jpg'),
('10', 'HK Jacket', 'Coat', 'Men', 'Green', '42', 'XL', 'Modern Man Coat ', 'img\\products\\man-4.jpg'),
('11', 'LV Bag', 'Bag', 'Women', 'White', '50', NULL, 'Modern Woman Bag ', 'img\\products\\women-4.jpg'),
('12', 'HK Sweater', 'Sweater', 'Women', 'Gray', '35', 'S', 'Modern Woman Sweater ', 'img\\products\\women-3.jpg'),
('13', 'Ankle Strap Pump', 'Shoes', 'Women', 'Blacl', '60', 'L', 'Modern Highheels ', 'img\\products\\ankle strap pump.png'),
('14', 'Cowl Neck', 'Sweater', 'Women', 'Green', '34', 'XL', 'Wool Cowl Nechl Sweater ', 'img\\products\\crew neck.png'),
('15', 'Driver', 'Shoes', 'Men', 'Orange', '68', 'L', 'Modern Shoes ', 'img\\products\\driver.png'),
('17', 'Cowl Neck', 'Sweater', 'Men', 'Green', '34', 'XL', 'Wool Cowl Nechl Sweater ', 'img\\products\\crew neck.png'),
('2', 'Guangzhou sweater', 'Sweater', 'Women', 'Beige', '13', 'M', 'Modern Woman Sweater', 'img\\products\\women-2.jpg'),
('20', 'Microfiber Wool Scarf', 'Scarf', 'Women', 'Gray', '64', NULL, 'Gray Wool Scarf ', 'img\\products\\product-4.jpg'),
('21', 'Sweaterkk', 'sweater', 'Women', 'red', '34', 'L', NULL, NULL),
('23', 'Sweaterkm', 'SW', 'Women', 'red', '55', 'L', NULL, NULL),
('3', 'Guangzhou coat', 'Coat', 'Men', 'Green', '34', 'L', 'Green Man Coat', 'img\\products\\product-3.jpg'),
('4', 'Microfiber Wool Scarf', 'Scarf', 'Men', 'Gray', '64', NULL, 'Gray Wool Scarf ', 'img\\products\\product-4.jpg'),
('5', 'Man\'s Painted Hat', 'Hat', 'Men', 'Orange', '44', NULL, 'Yellow Modern Hat ', 'img\\products\\product-5.jpg'),
('6', 'Lovely Sweater', 'Sweater', 'Women', 'Beige', '34', 'L', 'Wool Woman Beije Sweater ', 'img\\products\\product-6.jpg'),
('7', 'HK Backpack', 'Sweater', 'Men', 'Orange', '64', NULL, 'Cool Orange Backpack ', 'img\\products\\product-7.jpg'),
('8', '2 Layer Windbreaker', 'Coat', 'Men', 'Green', '44', 'XL', 'Green Man Coat ', 'img\\products\\product-8.jpg'),
('9', 'Converse Shoes', 'Shoes', 'Men', 'Orange', '50', 'M', 'Modern Shoes ', 'img\\products\\product-9.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `Email` varchar(200) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `Username`, `password`, `Email`) VALUES
(1, 'kawtharzaraket', 'zaraket2', 'k.zaraket36@gmail.com'),
(2, 'hossamzaraket', 'hossam', 'hossamzaraket45@gmail.com'),
(4, 'kawtharzzz', 'ewe', 'gngsva@gmail.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`PID`) REFERENCES `product` (`ProductId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
