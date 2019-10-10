-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2019 at 04:16 AM
-- Server version: 5.6.43-log
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `UserName` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Sec_Q` varchar(45) NOT NULL,
  `Answer` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `edition` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `pages` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookid`, `Name`, `edition`, `publisher`, `pages`, `price`) VALUES
(1, 'science', 1, 'john', 200, 50);

-- --------------------------------------------------------

--
-- Table structure for table `breturn`
--

CREATE TABLE `breturn` (
  `stu_id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `semister` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `bname` varchar(45) NOT NULL,
  `edition` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `pages` int(11) NOT NULL,
  `issue_date` varchar(45) NOT NULL,
  `return_date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `breturn`
--

INSERT INTO `breturn` (`stu_id`, `Name`, `fname`, `course`, `branch`, `year`, `semister`, `book_id`, `bname`, `edition`, `publisher`, `price`, `pages`, `issue_date`, `return_date`) VALUES
(100, 'Ajiharan', 'baskaran', 'IT', 'malabe', 1, 1, 1, 'science', 1, 'john', 50, 200, 'Jul 3, 2019', 'Jul 18, 2019');

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `book_id` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `edition` int(11) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `pages` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `sname` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `semister` int(11) NOT NULL,
  `date_issue` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`book_id`, `Name`, `edition`, `publisher`, `price`, `pages`, `student_id`, `sname`, `fname`, `course`, `branch`, `year`, `semister`, `date_issue`) VALUES
(1, 'science', 1, 'john', 50, 200, 100, 'Ajiharan', 'baskaran', 'IT', 'malabe', 1, 1, 'Jul 3, 2019');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `stu_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `father_name` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `semister` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`stu_id`, `name`, `father_name`, `course`, `branch`, `year`, `semister`) VALUES
(100, 'Ajiharan', 'baskaran', 'IT', 'malabe', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`UserName`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`stu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
