-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 31, 2022 at 06:49 PM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project7`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `username` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `sec_q` varchar(40) DEFAULT NULL,
  `sec_ans` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `name`, `password`, `sec_q`, `sec_ans`) VALUES
('asmi', 'asmi', 'asmi', 'Your NickName?', 'asmi'),
('shivangi', 'shivangi', 'shivangi', 'Your NickName?', 'shivangi'),
('ayush', 'ayush', 'ayush', 'Your NickName?', 'ayush'),
('ankit', 'ankit', 'ankit', 'Your NickName?', 'ankit');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `book_id` varchar(10) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `edition` varchar(10) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `pages` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `name`, `isbn`, `publisher`, `edition`, `price`, `pages`) VALUES
('1', 'Let Us C', '111', 'Paperback', '1', '250', '300'),
('2', 'OOPs with C++', '112', 'Paperback', '1', '300', '200'),
('3', 'Java', '113', 'Paperback', '1', '350', '300'),
('4', 'RDBMS', '114', 'Paperback', '1', '350', '300'),
('5', 'Data Structure', '115', 'Paperback', '1', '250', '200');

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE IF NOT EXISTS `issuebook` (
  `book_id` varchar(40) DEFAULT NULL,
  `student_id` varchar(40) DEFAULT NULL,
  `bname` varchar(40) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `course` varchar(40) DEFAULT NULL,
  `branch` varchar(40) DEFAULT NULL,
  `dateOfIssue` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`book_id`, `student_id`, `bname`, `sname`, `course`, `branch`, `dateOfIssue`) VALUES
('2', '2003', 'OOPs with C++', 'Ayush', 'B.E', 'Civil', 'Dec 24, 2021'),
('3', '2002', 'Java', 'Lalita', 'B.Tech', 'Mechanical', 'Dec 24, 2021'),
('4', '2005', 'RDBMS', 'Asmita', 'B.Tech', 'CSE', 'Dec 24, 2021');

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE IF NOT EXISTS `returnbook` (
  `book_id` varchar(10) DEFAULT NULL,
  `student_id` varchar(10) DEFAULT NULL,
  `bname` varchar(40) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `dateOfIssue` varchar(30) DEFAULT NULL,
  `dateOfReturn` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`book_id`, `student_id`, `bname`, `sname`, `course`, `branch`, `dateOfIssue`, `dateOfReturn`) VALUES
('1', '2001', 'Let Us C', 'Shivangi', 'B.Tech', 'CSE', 'Dec 24, 2021', 'Dec 24, 2021');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` varchar(10) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `father` varchar(25) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `year` varchar(10) DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `father`, `course`, `branch`, `year`, `semester`) VALUES
('2001', 'Shivangi', 'Deepankar', 'B.Tech', 'CSE', 'Third', '5th'),
('2002', 'Lalita', 'Suraj', 'B.Tech', 'Mechanical', 'Second', '3rd'),
('2003', 'Ayush', 'Ankit', 'B.E', 'Civil', 'First', '1st'),
('2004', 'Sachin', 'Rahul', 'MBA', 'IT', 'First', '1st'),
('2005', 'Asmita', 'Harinandan', 'B.Tech', 'CSE', 'Third', '5th');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
