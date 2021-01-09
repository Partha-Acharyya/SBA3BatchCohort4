-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ibs
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cc_eligibility`
--

DROP TABLE IF EXISTS `cc_eligibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cc_eligibility` (
  `ReferenceID` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `MobileNumber` mediumtext NOT NULL,
  `TypeOfEmployment` varchar(255) NOT NULL,
  `TotalIncome` mediumtext NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Createdt` datetime DEFAULT (now()),
  `status` varchar(255) DEFAULT 'PENDING',
  PRIMARY KEY (`ReferenceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cc_eligibility`
--

LOCK TABLES `cc_eligibility` WRITE;
/*!40000 ALTER TABLE `cc_eligibility` DISABLE KEYS */;
INSERT INTO `cc_eligibility` VALUES ('1b67d7fc-5ff5-4683-9694-2e7c05bd1862','robin','s','1990-12-05','9596963265','Salaried','212440','robins@gmail.com','2020-10-30 23:24:15','PENDING'),('6b8e3b85-d3b8-4a74-a2b8-f479ef925f24','bob','m','1995-05-07','9856235694','Salaried','512440','bobm@gmail.com','2020-10-30 23:44:59','PENDING'),('6c04e24b-72bf-471c-a3d5-4e87e93d50b1','dasf','s','1995-05-05','9596963265','Salaried','512440','dansj@mail.com','2020-11-03 16:09:22','PENDING');
/*!40000 ALTER TABLE `cc_eligibility` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-08 23:30:09
