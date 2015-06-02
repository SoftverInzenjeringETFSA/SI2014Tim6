-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 02, 2015 at 09:53 PM
-- Server version: 5.6.24-0ubuntu2
-- PHP Version: 5.6.4-4ubuntu6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim6`
--

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE IF NOT EXISTS `gost` (
`ID` bigint(20) NOT NULL,
  `IME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `PREZIME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `BROJTELEFONA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `VIP` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
`ID` bigint(20) NOT NULL,
  `IDRADNIKA` bigint(20) DEFAULT NULL,
  `KORISNICKOIME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `HASHSIFRE` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `STEPENPRISTUPA` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`ID`, `IDRADNIKA`, `KORISNICKOIME`, `HASHSIFRE`, `STEPENPRISTUPA`) VALUES
(1, 1, 'sefic', 'cnsjKC3fY1fmt0ObspDsc1vTav8TxbLHTLQANU7ymC4=$Tz2BAB6c44V1RZ7P1LjheLMHJmqDby2TX9CG4rmqNzI=\r\n', 1),
(4, 2, 'radnik', 'i5qicQwA4Rp/kCZ07GVyagNFyj8HxJvYlgv+6mViVDc=\r\n$3oM3GSnEw7o4TuaV7EIwODqZVuiSYfzxCS6guIA+HR0=\r\n', 2);

-- --------------------------------------------------------

--
-- Table structure for table `logkorisnik`
--

CREATE TABLE IF NOT EXISTS `logkorisnik` (
`ID` bigint(20) NOT NULL,
  `IDRADNIKA` bigint(20) DEFAULT NULL,
  `PRISTUP` date DEFAULT NULL,
  `ODJAVA` date DEFAULT NULL,
  `OTVORENEREZERVACIJE` int(11) DEFAULT NULL,
  `ZATVORENEREZERVACIJE` int(11) DEFAULT NULL,
  `EVIDENTIRANIHGOSTIJU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE IF NOT EXISTS `radnik` (
`ID` bigint(20) NOT NULL,
  `IME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `PREZIME` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `DATUMZAPOSLENJA` date DEFAULT NULL,
  `JMBG` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `NAZIVPOSLA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `OPISPOSLA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `NADREDJENI` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`ID`, `IME`, `PREZIME`, `DATUMZAPOSLENJA`, `JMBG`, `NAZIVPOSLA`, `OPISPOSLA`, `NADREDJENI`) VALUES
(2, 'Radnik', 'Radisa', '2015-05-25', '1901994172184', 'Rezervacije', 'Vrsenje rezervacija', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE IF NOT EXISTS `rezervacija` (
`ID` bigint(20) NOT NULL,
  `IDGOSTA` bigint(20) DEFAULT NULL,
  `IDRADNIKA` bigint(20) DEFAULT NULL,
  `IDSTOLA` bigint(20) DEFAULT NULL,
  `BROJGOSTIJU` int(11) DEFAULT NULL,
  `STATUSREZERVACIJE` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `DATUMREZERVACIJE` date DEFAULT NULL,
  `VRIJEMEREZERVACIJE` time DEFAULT NULL,
  `TRAJANJEREZERVACIJEMINUTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sto`
--

CREATE TABLE IF NOT EXISTS `sto` (
`ID` bigint(20) NOT NULL,
  `OZNAKASTOLA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `KAPACITET` int(11) DEFAULT NULL,
  `OPISMJESTA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `ZAPUSACE` bit(1) DEFAULT NULL,
  `VIP` bit(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `sto`
--

INSERT INTO `sto` (`ID`, `OZNAKASTOLA`, `KAPACITET`, `OPISMJESTA`, `ZAPUSACE`, `VIP`) VALUES
(1, 'Anesa', 2, 'Do vrata', b'0', b'0'),
(2, 'Aida', 2, 'Do vrata', b'0', b'0'),
(3, 'Elmir', 2, 'Do vrata', b'0', b'0'),
(4, 'Adna', 2, 'Do vrata', b'0', b'0'),
(5, 'Almin', 2, 'Do vrata', b'0', b'0'),
(6, 'Emir', 2, 'Do prozora', b'0', b'0'),
(7, 'Tarik', 2, 'Do prozora', b'0', b'0'),
(8, 'Irma', 2, 'Do prozora', b'0', b'0'),
(9, 'Anesaa', 2, 'Do prozora', b'1', b'0'),
(10, 'Aidaa', 2, 'Do prozora', b'1', b'0'),
(11, 'Elmirr', 2, 'Do vrata', b'0', b'0'),
(12, 'Adnaa', 2, 'Do vrata', b'0', b'0'),
(13, 'Alminn', 2, 'Do vrata', b'0', b'0'),
(14, 'Emirr', 2, 'Do vrata', b'0', b'0'),
(15, 'Tarikk', 2, 'Do vrata', b'0', b'0'),
(16, 'Aidaa', 2, 'Do prozora', b'0', b'0'),
(17, 'Elmirr', 2, 'Do vrata', b'0', b'0'),
(18, 'Adnaa', 2, 'Do vrata', b'0', b'0'),
(19, 'Alminn', 2, 'Do vrata', b'1', b'0'),
(20, 'Emirr', 2, 'Do vrata', b'1', b'0'),
(21, 'Jjjj', 4, 'Do vrata', b'0', b'0'),
(22, 'Kkkk', 4, 'Do vrata', b'0', b'0'),
(23, 'Llll', 4, 'Do vrata', b'0', b'0'),
(24, 'Mmmm', 4, 'Do vrata', b'0', b'0'),
(25, 'Nnnn', 4, 'Do vrata', b'0', b'0'),
(26, 'Oooo', 4, 'Do vrata', b'0', b'0'),
(27, 'Pppp', 4, 'Do vrata', b'0', b'0'),
(28, 'Rrrr', 4, 'Do vrata', b'0', b'0'),
(29, 'Ssss', 4, 'Do vrata', b'1', b'0'),
(30, 'Tttt', 4, 'Do vrata', b'1', b'0'),
(31, 'Uuuu', 4, 'Do vrata', b'0', b'0'),
(32, 'Vvvv', 4, 'Do vrata', b'0', b'0'),
(33, 'Zzzz', 4, 'Do vrata', b'0', b'0'),
(34, 'Aeee', 4, 'Do vrata', b'0', b'0'),
(35, 'Eaaa', 4, 'Do vrata', b'0', b'0'),
(36, 'Ieee', 4, 'Do vrata', b'0', b'0'),
(37, 'Oaaa', 4, 'Do vrata', b'0', b'0'),
(38, 'Baaa', 4, 'Do vrata', b'0', b'0'),
(39, 'Caaa', 4, 'Do vrata', b'1', b'0'),
(40, 'Daaa', 4, 'Do vrata', b'0', b'0'),
(41, 'Irmaa', 6, 'Do prozora', b'0', b'0'),
(42, 'Nesto', 6, 'Do prozora', b'0', b'0'),
(43, 'Naziv', 6, 'Do prozora', b'0', b'0'),
(44, 'Imee', 6, 'Do prozora', b'0', b'0'),
(45, 'Somm', 6, 'Do prozora', b'0', b'0'),
(46, 'Name', 6, 'Do prozora', b'0', b'0'),
(47, 'Aaaa', 6, 'Do prozora', b'0', b'0'),
(48, 'Bbbb', 6, 'Do prozora', b'0', b'0'),
(49, 'Cccc', 6, 'Do prozora', b'1', b'0'),
(50, 'Dddd', 6, 'Do prozora', b'1', b'0'),
(51, 'Daaa', 2, 'Do vrata', b'1', b'1'),
(52, 'Irmaa', 2, 'Do prozora', b'1', b'1'),
(53, 'Nesto', 2, 'Do prozora', b'1', b'1'),
(54, 'Naziv', 4, 'Do prozora', b'1', b'1'),
(55, 'Imee', 4, 'Do prozora', b'1', b'1'),
(56, 'Somm', 4, 'Do prozora', b'1', b'1'),
(57, 'Name', 4, 'Do prozora', b'1', b'1'),
(58, 'Aaaa', 6, 'Do prozora', b'1', b'1'),
(59, 'Bbbb', 6, 'Do prozora', b'1', b'1'),
(60, 'Cccc', 6, 'Do prozora', b'1', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `zauzetisto`
--

CREATE TABLE IF NOT EXISTS `zauzetisto` (
`ID` bigint(20) NOT NULL,
  `IDREZERVACIJE` bigint(20) DEFAULT NULL,
  `IDSTOLA` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gost`
--
ALTER TABLE `gost`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `logkorisnik`
--
ALTER TABLE `logkorisnik`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sto`
--
ALTER TABLE `sto`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `zauzetisto`
--
ALTER TABLE `zauzetisto`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gost`
--
ALTER TABLE `gost`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `logkorisnik`
--
ALTER TABLE `logkorisnik`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `radnik`
--
ALTER TABLE `radnik`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sto`
--
ALTER TABLE `sto`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `zauzetisto`
--
ALTER TABLE `zauzetisto`
MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
