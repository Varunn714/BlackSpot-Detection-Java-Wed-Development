-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2022 at 07:51 PM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `black_spot_detection`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminauth`
--

CREATE TABLE IF NOT EXISTS `adminauth` (
  `id` int(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminauth`
--

INSERT INTO `adminauth` (`id`, `name`, `email`, `pass`) VALUES
(1, 'Varun Agrawal', 'Admin@123', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `blackspot_details`
--

CREATE TABLE IF NOT EXISTS `blackspot_details` (
  `spot_id` int(11) NOT NULL,
  `pid` int(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `reason` varchar(20) NOT NULL,
  `latitude` double(70,20) NOT NULL,
  `longitude` double(70,20) NOT NULL,
  `level` int(2) NOT NULL,
  `city` varchar(255) NOT NULL,
  `added_by` varchar(255) NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blackspot_details`
--

INSERT INTO `blackspot_details` (`spot_id`, `pid`, `location`, `address`, `reason`, `latitude`, `longitude`, `level`, `city`, `added_by`, `added_on`) VALUES
(12, 14, 'Dhule District Court', '26 , B  Maha Nagar', 'Crime', 20.89292300000000000000, 74.76911700000000000000, 1, 'Dhule', 'Shivaji Station', '2022-02-18 16:56:53'),
(13, 15, 'Gandi Chowk', '56B, Mali Wada', 'Accident', 21.54256200000000000000, 74.46670200000000000000, 2, 'Shahada', 'Main Station', '2022-02-18 17:15:53'),
(14, 15, 'Mohida Road', 'Near Shukala Colony', 'Crime', 21.54296600000000000000, 74.46442700000000000000, 0, 'Shahada', 'Main Station', '2022-02-18 17:17:21'),
(15, 15, 'Prakasha Road', 'Near Shivaji Maharaj Statue', 'Accident', 21.52893800000000000000, 74.47660500000000000000, 2, 'Shahada', 'Main Station', '2022-02-18 17:22:41'),
(16, 15, 'Bus Stand', 'Swami Colony', 'Crime', 21.53235500000000000000, 74.46973100000000000000, 1, 'Shahada', 'Main Station', '2022-02-18 17:24:04'),
(17, 15, 'Gandi Chowk', 'Saheba Nagar', 'Accident', 21.54550400000000000000, 74.47886600000000000000, 1, 'Shahada', 'Main Station', '2022-02-18 17:37:10'),
(18, 14, 'Chandrvel Colony', ' Wadibhokar', 'Accident', 20.92830800000000000000, 74.75706200000000000000, 1, 'Dhule', 'Shivaji Station', '2022-02-18 17:43:42'),
(19, 14, 'Shree Guru Colony', 'Near Nita Hospital', 'Crime', 20.93124400000000000000, 74.76550100000000000000, 2, 'Dhule', 'Shivaji Station', '2022-02-18 17:45:13'),
(20, 14, 'Chalisgaon Rd', ' Ansar Nagar', 'Accident', 20.89381300000000000000, 74.77538100000000000000, 1, 'Dhule', 'Shivaji Station', '2022-02-18 17:46:30'),
(21, 14, 'AH46', 'Vittal Mandir,Balapur', 'Crime', 20.89679300000000000000, 74.81431500000000000000, 2, 'Balapur', 'Shivaji Station', '2022-02-18 17:48:15'),
(22, 8, 'Nimzari Naka', '32B, Sonar nagar', 'Crime', 21.35781700000000000000, 74.87964800000000000000, 0, 'Shirpur', 'Shivaji Station', '2022-02-18 18:08:53'),
(23, 8, 'Karvand Naka', 'Hulesighnana Nagar', 'Accident', 21.35475800000000000000, 74.88927100000000000000, 1, 'Shirpur', 'Shivaji Station', '2022-02-18 18:11:02'),
(24, 8, 'Pach Kandil', '345 Shop no', 'Crime', 21.34806900000000000000, 74.88309000000000000000, 2, 'Shirpur', 'Shivaji Station', '2022-02-18 18:12:05'),
(25, 8, 'Main Road', 'Ganesh Colony', 'Accident', 21.35052400000000000000, 74.90120900000000000000, 0, 'Shirpur', 'Shivaji Station', '2022-02-18 18:13:13'),
(26, 8, 'Hulesighnana Nagar', '34 A', 'Crime', 21.35149700000000000000, 74.88995400000000000000, 1, 'Shirpur', 'Shivaji Station', '2022-02-18 18:14:22'),
(27, 8, 'asdf', 'asdf', 'Crime', 21.00000000000000000000, 70.00000000000000000000, 1, 'Shirpur', 'Shivaji Station', '2022-02-19 09:32:55'),
(28, 8, 'Near water park', 'Main road', 'Accident', 21.32564621162712000000, 74.85280854628988000000, 1, 'Shirpur', 'Shivaji Station', '2022-02-19 18:11:07'),
(29, 8, 'Nimazari Naka', 'Shirpur', 'Accident', 21.34106759185542000000, 74.87704805594818000000, 1, 'Shirpur', 'Shivaji Station', '2022-09-16 19:37:35');

-- --------------------------------------------------------

--
-- Table structure for table `police_station`
--

CREATE TABLE IF NOT EXISTS `police_station` (
`id` int(30) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `pass` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `contact` varchar(15) CHARACTER SET utf8mb4 NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `police_station`
--

INSERT INTO `police_station` (`id`, `name`, `email`, `pass`, `address`, `contact`, `added_on`) VALUES
(2, 'S', 'police@gmail.com', 'police', 'Shirpur', '1', '2022-11-17 19:14:33');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`uid` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` bigint(15) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `name`, `email`, `mobile`, `pass`, `city`, `added_on`) VALUES
(1, 'aa', 'sh@gmail.com', 7768854039, 'a', 'Nandurbar', '2022-11-17 18:50:24'),
(2, 'Tushar', 't@t.com', 1, 't', 'Shirpur', '2022-11-17 19:08:51');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `police_station`
--
ALTER TABLE `police_station`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `police_station`
--
ALTER TABLE `police_station`
MODIFY `id` int(30) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `uid` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
