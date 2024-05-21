-- MariaDB dump 10.19-11.3.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: PhoneSourcingService
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `PhoneID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalPrice` decimal(10,2) NOT NULL,
  `PostingDate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `UserID` (`UserID`),
  KEY `PhoneID` (`PhoneID`),
  CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `Users` (`ID`),
  CONSTRAINT `Orders_ibfk_2` FOREIGN KEY (`PhoneID`) REFERENCES `Phones` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES
(1,1,1,1,999.99,'2023-04-01'),
(2,2,2,2,1699.98,'2023-04-02'),
(4,4,4,1,799.99,'2023-04-04'),
(5,5,5,3,2099.97,'2023-04-05'),
(6,6,6,1,1199.99,'2023-04-06'),
(8,8,8,1,499.99,'2023-04-08'),
(9,9,9,3,599.97,'2023-04-09'),
(10,10,10,2,999.98,'2023-04-10');
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Phones`
--

DROP TABLE IF EXISTS `Phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Phones` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Brand` varchar(50) NOT NULL,
  `Model` varchar(100) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Description` text DEFAULT NULL,
  `Availability` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Phones`
--

LOCK TABLES `Phones` WRITE;
/*!40000 ALTER TABLE `Phones` DISABLE KEYS */;
INSERT INTO `Phones` VALUES
(1,'Apple','iPhone 13',999.99,'The latest iPhone model',1),
(2,'Samsung','Galaxy S22',849.99,'Samsung flagship phone',1),
(3,'Google','Pixel 6',599.99,'Google Pixel 6 smartphone',0),
(4,'OnePlus','OnePlus 9 Pro',799.99,'OnePlus flagship phone',1),
(5,'Xiaomi','Mi 11',699.99,'Xiaomi flagship phone',1),
(6,'Sony','Xperia 1 III',1199.99,'Sony flagship phone',1),
(7,'Motorola','Edge+',699.99,'Motorola flagship phone',0),
(8,'LG','Velvet',499.99,'LG mid-range phone',1),
(9,'Nokia','G20',199.99,'Nokia budget phone',1),
(10,'Realme','GT Neo 2',499.99,'Realme mid-range phone',1);
/*!40000 ALTER TABLE `Phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `ContactInformation` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES
(1,'John Doe','john.doe@email.com'),
(2,'Jane Smith','jane.smith@email.com'),
(3,'Michael Johnson','michael.johnson@email.com'),
(4,'Emily Davis','emily.davis@email.com'),
(5,'David Wilson','david.wilson@email.com'),
(6,'Sarah Thompson','sarah.thompson@email.com'),
(7,'Robert Anderson','robert.anderson@email.com'),
(8,'Jessica Taylor','jessica.taylor@email.com'),
(9,'Christopher Brown','christopher.brown@email.com'),
(10,'Amanda Miller','amanda.miller@email.com');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20  9:26:21
