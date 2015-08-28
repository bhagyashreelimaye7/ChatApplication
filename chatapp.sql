-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2015 at 06:11 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `chatapp`
--
CREATE DATABASE IF NOT EXISTS `chatapp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `chatapp`;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `messageid` int(100) NOT NULL AUTO_INCREMENT,
  `fromUser` varchar(50) NOT NULL,
  `toUser` varchar(50) NOT NULL,
  `msg` text NOT NULL,
  `messageTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `firstName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`messageid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`messageid`, `fromUser`, `toUser`, `msg`, `messageTime`, `firstName`) VALUES
(1, 'sonu@gmail.com', 'sonu1@gmail.com', 'hiiiiii', '2015-03-09 03:46:54', 'sonu'),
(2, 'sonu1@gmail.com', 'sonu@gmail.com', 'hello', '2015-03-09 03:47:08', 'bhagu'),
(3, 'sonu@gmail.com', 's@gmail.com', 'hwwwwwwwwwwww', '2015-03-09 04:18:21', 'sonu'),
(4, 'sonu@gmail.com', 'sonu1@gmail.com', 'how r u?', '2015-03-10 05:27:46', 'sonu'),
(5, 'sonu@gmail.com', 'sonu1@gmail.com', 'fineee', '2015-03-10 06:16:44', 'sonu'),
(6, 'sonu@gmail.com', 'sonu1@gmail.com', 'yaah ok', '2015-03-10 06:20:39', 'sonu'),
(7, 'sonu@gmail.com', 'sonu1@gmail.com', 'asdf', '2015-03-10 06:20:54', 'sonu'),
(8, 'sonu1@gmail.com', 'sonu@gmail.com', 'hhiiii', '2015-03-10 06:21:23', 'bhagu'),
(9, 'sonu@gmail.com', 'sonu1@gmail.com', 'hello', '2015-03-10 06:21:37', 'sonu'),
(10, 'sonu1@gmail.com', 'sonu@gmail.com', 'hwwww', '2015-03-10 06:21:44', 'bhagu'),
(11, 'sonu1@gmail.com', 's@gmail.com', 'hellooo', '2015-03-10 06:43:38', 'bhagu'),
(12, 's@gmail.com', 'sonu1@gmail.com', 'hiiiii', '2015-03-10 06:44:09', 'bhagyashree'),
(13, 'sonu1@gmail.com', 's@gmail.com', '', '2015-03-10 06:44:18', 'bhagu'),
(14, 's@gmail.com', 'sonu1@gmail.com', '', '2015-03-10 06:44:21', 'bhagyashree'),
(15, 'sonu1@gmail.com', 'sonu@gmail.com', 'hellloooo', '2015-03-10 12:27:56', 'bhagu'),
(16, 'sonu@gmail.com', 'sonu1@gmail.com', 'hiiii', '2015-03-10 12:28:01', 'sonu'),
(17, 'sonu@gmail.com', 'sonu1@gmail.com', 'pagal', '2015-03-10 12:29:37', 'sonu'),
(18, 'sonu1@gmail.com', 'sonu@gmail.com', 'chachundariii', '2015-03-10 12:29:43', 'bhagu'),
(19, 'sonu@gmail.com', 'sonu1@gmail.com', 'kya re?', '2015-03-10 13:01:26', 'sonu'),
(20, 'sonu1@gmail.com', 'sonu@gmail.com', 'kuch naaiiiii', '2015-03-10 13:01:34', 'bhagu'),
(21, 'sonu@gmail.com', 'sonu1@gmail.com', 'dsfgsdfg', '2015-03-10 13:05:23', 'sonu'),
(22, 'sonu@gmail.com', 'sonu1@gmail.com', 'sdfgsdfg', '2015-03-10 13:05:28', 'sonu'),
(23, 'sonu@gmail.com', 'sonu1@gmail.com', '', '2015-03-10 13:05:35', 'sonu'),
(24, 'sonu@gmail.com', 'sonu1@gmail.com', 'abe oyeeee', '2015-03-10 13:23:50', 'sonu'),
(25, 'sonu@gmail.com', 'sonu1@gmail.com', 'hey', '2015-03-10 13:58:36', 'sonu'),
(26, 'sonu1@gmail.com', 'sonu@gmail.com', 'kya hai', '2015-03-10 13:58:50', 'bhagu'),
(27, 'sonu@gmail.com', 'sonu1@gmail.com', 'arreyyyy', '2015-03-11 04:53:46', 'sonu'),
(28, 'sonu1@gmail.com', 's@gmail.com', 'huhuhuh', '2015-03-11 04:54:00', 'bhagu'),
(29, 's@gmail.com', 'sonu@gmail.com', 'fasdfasdfasdf', '2015-03-11 04:54:07', 'bhagyashree'),
(30, 's@gmail.com', 'sonu@gmail.com', '', '2015-03-11 04:54:11', 'bhagyashree');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(4) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(40) NOT NULL,
  `lastName` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(40) NOT NULL,
  `isOnline` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `firstName`, `lastName`, `email`, `password`, `isOnline`) VALUES
(1, 'sonu', 'limaye', 'sonu@gmail.com', '42629f3a15f88aa9be34816910b322543898aa72', 0),
(2, 'bhagu', 'limaye', 'sonu1@gmail.com', '42629f3a15f88aa9be34816910b322543898aa72', 1),
(3, 'bhagyashree', 'sonu', 's@gmail.com', '42629f3a15f88aa9be34816910b322543898aa72', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
