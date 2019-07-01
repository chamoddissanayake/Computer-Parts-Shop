-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2019 at 07:02 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spareparts`
--

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `customer_id` varchar(10) DEFAULT NULL,
  `feedback_topic` varchar(50) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `customer_id`, `feedback_topic`, `description`) VALUES
(2, 'C98243', 'Helpful', ' have the same problem with my own home Windows PC.  Believe me, since I tried ALL the fixes on that one, Ray will be getting my business again in the near future.'),
(3, 'C93623333', 'Quick service111', 'Got to thank Ray for the great customer service and knowledge of computers, he fixed my Mac that was sitting around for a few years collecting dust and actually also put a new glass on it as well that my kid broke'),
(4, 'C4362722', 'Good products', 'Brought in my mother in law because her HP laptop was giving her issues. Let me just tell you. The two men are so nice & very informative. It''s a really professional environment.'),
(5, 'C28357', 'Reliable service', 'This is the place you want to bring your and your families computer to. I am techie enough to troubleshoot most issues, and when I can''t solve it, Ray is my go to. He has resolved every issue that I have ever given him.'),
(6, 'C03450', 'Low quality products', 'The worst place you can possibly go. I brought my laptop in because it was running slow, several hundred dollars and a wiped hard drive in which EVERYTHING was lost without backup'),
(7, 'C92367', 'Quick', 'Amazingly helpful with my problem.\r\nIssue fixed within 3 hours.\r\nPresented professionally  staff was very polite with me\r\nWould reccomend to others and return again with future issues.'),
(8, 'C11108', 'Friendly', 'I chose this place based on the Yelp reviews and vicinity to my home. My laptop needed a new screen as well as performance upgrades. Ray was very kind and took the time to answer all of my questions.'),
(9, 'C77732', 'Quality products', ' almost feel late to the party. So many posted reviews say in their own way what I''m about to state here. Yet I suspect I have been a customer at this establishment longer than most of those who have posted. So allow me to offer some insights as someone who has been a patron of The Computer Shop for over eight years.'),
(10, 'C00012', 'Excellent service', 'It is easy to look at all the five-star reviews for this place and ask if something is fishy. I suppose it is a sign of our times that we might look a bit askance at peer feedback that seems universally laudatory.'),
(11, 'C13567', 'Fast', 'My parents come here all the time and when my IMAC stopped working they told me to go here. I am not tech savvy at all nor am I very knowledgeable about IMAC. Ray didn''t laugh at me when I said I don''t know anything about MAC''S but was extremely helpful polite and fixed the issues. Glad my parents told me about this stop.'),
(12, 'C99934', 'Helpful', 'This is what all Computer repair shops should be like : Friendly, Knowledgeable, Honest. They listen intently to you describe the problem, they tell you what they think might be wrong, but will call you and explain exactly what the issue is following a complete inspection. '),
(13, 'C34532', 'Recomend', 'Definitely recommend this business. The person who helped me update my laptop so I could have it ready for school was very kind in explaining what was going on as best as he could. '),
(14, 'C23322', 'Expensive', 'Ray was so nice, friendly and HELPFUL! He was super patient as he looked into my issue.But expensive'),
(15, 'C34511', 'Cheap products', 'What a great find! Ray and his team are the best! They have been keeping our personal and work computers in shape for the last 5 years.'),
(16, 'C02456', 'Professional', 'Laptop acting wonky so wanted a pro opinion. Got a thorough going over and my computer is humming. '),
(17, 'C35632', 'Good service', 'His knowledge and ability to identify a problem and execute a solution was most impressive to me. '),
(18, 'C63674', 'Fair', 'His price was very fair and appropriate and he did more than he needed to in helping me set it up. '),
(19, 'C63157', 'Good products', 'He goes above and beyond for clients. He loves what he does and it shows.'),
(20, 'C86435', 'Best service', 'Ray is excellent in his prompt and friendly customer service! He helped us immensely and even when we got home, he helped us troubleshoot an issue over the phone. ');

-- --------------------------------------------------------

--
-- Table structure for table `spare_part`
--

CREATE TABLE `spare_part` (
  `spare_part_id` int(11) NOT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  `designation` varchar(15) DEFAULT NULL,
  `available_count` int(11) DEFAULT '0',
  `spare_part_type` varchar(10) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `manufacture` varchar(30) DEFAULT NULL,
  `modelNo` varchar(20) DEFAULT NULL,
  `screenSize` varchar(10) DEFAULT NULL,
  `technology` varchar(10) DEFAULT NULL,
  `hddCapacity` varchar(10) DEFAULT NULL,
  `hddRPM` varchar(10) DEFAULT NULL,
  `ramCapacity` varchar(10) DEFAULT NULL,
  `ramType` varchar(10) DEFAULT NULL,
  `printerType` varchar(10) DEFAULT NULL,
  `sheetSize` varchar(10) DEFAULT NULL,
  `voltage` varchar(10) DEFAULT NULL,
  `ampHour` varchar(10) DEFAULT NULL,
  `runtime` varchar(10) DEFAULT NULL,
  `dvdWriterSpeed` varchar(10) DEFAULT NULL,
  `dvdWriterType` varchar(10) DEFAULT NULL,
  `megaPixel` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spare_part`
--

INSERT INTO `spare_part` (`spare_part_id`, `price`, `designation`, `available_count`, `spare_part_type`, `description`, `manufacture`, `modelNo`, `screenSize`, `technology`, `hddCapacity`, `hddRPM`, `ramCapacity`, `ramType`, `printerType`, `sheetSize`, `voltage`, `ampHour`, `runtime`, `dvdWriterSpeed`, `dvdWriterType`, `megaPixel`) VALUES
(4, '15000.00', 'E002', 21, 'monitor', 'A curved screen', 'SAMSUNG', 'C27F391', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, '14500.00', 'E003', 26, 'monitor', 'Super Slim', 'HP', '27VM', '27', 'LED', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, '12000.00', 'E003', 10, 'hdd', '320 SLIM 7mm', 'Hitachi', 'Z5K320', NULL, NULL, '1TB', '5400rpm', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, '8200.00', 'E001', 12, 'hdd', 'SATA III (6.0Gb/s) ', 'MaxDigitalData', 'MD4000G', NULL, NULL, '500GB', '7200rpm', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, '20000.00', 'E005', 15, 'hdd', 'AvailableSATA 3.0Gb/s ', 'Seagate', 'MG123', NULL, NULL, '2TB', '7200rpm', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, '14600.00', 'E003', 20, 'hdd', 'RPM performance ', 'HGST', 'D01-1219', NULL, NULL, '4TB', '7200rpm', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, '25000.00', 'E002', 24, 'ram', 'PC3-12800 ', 'Samsung', 'DS232', NULL, NULL, NULL, NULL, '8GB', 'DDR3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '5000.00', 'E002', 16, 'ram', '100% New chips', 'HP', 'AR231', NULL, NULL, NULL, NULL, '16GB', 'DDR4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '4000.00', 'E002', 25, 'ram', '240-Pin DDR4', 'HP', 'A098', NULL, NULL, NULL, NULL, '4GB', 'DDR4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, '6000.00', 'E003', 10, 'ram', 'PC3-12800   ', 'Fury', 'HL2432', NULL, NULL, NULL, NULL, '32GB', 'DDR3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(14, '25000.00', 'E003', 20, 'printer', 'Droplet Technology', 'Epson', 'WF-7710DWF', NULL, NULL, NULL, NULL, NULL, NULL, 'Laser', 'A4', NULL, NULL, NULL, NULL, NULL, NULL),
(15, '22400.00', 'E003', 23, 'printer', 'A brand-new', 'EPSON ', 'M1120', NULL, NULL, NULL, NULL, NULL, NULL, 'Monochrome', 'A4', NULL, NULL, NULL, NULL, NULL, NULL),
(16, '30000.00', 'E004', 32, 'printer', 'HP Mobile Printer ', 'HP', 'Officejet 100', NULL, NULL, NULL, NULL, NULL, NULL, 'Laser', 'A3', NULL, NULL, NULL, NULL, NULL, NULL),
(17, '24000.00', 'E002', 18, 'printer', 'HP Envy Photo', 'HP', 'Envy 6220', NULL, NULL, NULL, NULL, NULL, NULL, 'Ink jet', 'A4', NULL, NULL, NULL, NULL, NULL, NULL),
(18, '20000.00', 'E002', 16, 'ups', 'APC(325 VA) ', 'APC', 'AD432', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '240V', '650AH', '30 mins', NULL, NULL, NULL),
(19, '3500.00', 'E002', 12, 'ups', 'Recharge - 5.10 Minute', 'Prolink', 'SD234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '240V', '850AH', '45 mins', NULL, NULL, NULL),
(20, '8300.00', 'E005', 20, 'ups', 'Smart-UPS 1400 ', 'APC', 'DL1400RM', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '240V', '80 AH', '25 mins', NULL, NULL, NULL),
(21, '7800.00', 'E004', 18, 'ups', 'BRAND NEW ', 'Belkin', 'BU3DC001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '240V', '45 AH', '10 mins', NULL, NULL, NULL),
(22, '4000.00', 'E002', 15, 'dvdWriter', 'DVD-RW drive', 'HP', 'TS-H653', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '52X', 'internal', NULL),
(23, '5600.00', 'E005', 12, 'dvdWriter', 'ABS plastic ', 'Asus', 'AD923', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '24X', 'external', NULL),
(24, '5000.00', 'E003', 12, 'dvdWriter', 'DVD-RAM, ', 'Asus', 'GW231', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '24X', 'internal', NULL),
(25, '6900.00', 'E003', 31, 'dvdWriter', 'Ultra-slim ', 'HP', 'FWRS24', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '52X', 'external', NULL),
(26, '9000.00', 'E004', 10, 'webCam', 'Full-HD video', 'Logitech', 'C920 HD ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '5MP'),
(27, '5650.00', 'E001', 8, 'webCam', 'Brighter images', 'Logitech', 'AFE1233D', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12MP'),
(28, '8000.00', 'E002', 13, 'webCam', 'Night vision. ', 'Sony', 'DF12D', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '5MP'),
(29, '12500.00', 'E004', 23, 'webCam', 'Record videos', 'Logitech', 'SH12W', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12MP'),
(30, '0.00', 'tr', 34, 'monitor', 'er', 'ewq', 'qwe', 'try', 'et', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(31, '54.00', 'g', 45, 'monitor', 'dfg', 'yu', 'ew', 'tr', 'rt', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(32, '56.64', 'yt', 43, 'monitor', 'r', 'wer', 'dsf', 'er', 'rrew', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(33, '43.00', 'sf', 34, 'monitor', 'sdf', 'sf', 'ds', 'dg', 'e', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(34, '23.00', 'xz', 23, 'webCam', 'zx', 'sa', 'sa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'vss');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `spare_part`
--
ALTER TABLE `spare_part`
  ADD PRIMARY KEY (`spare_part_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `spare_part`
--
ALTER TABLE `spare_part`
  MODIFY `spare_part_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
