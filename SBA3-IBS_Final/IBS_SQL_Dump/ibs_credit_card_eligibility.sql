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
-- Table structure for table `credit_card_eligibility`
--

DROP TABLE IF EXISTS `credit_card_eligibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_card_eligibility` (
  `referenceid` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `cc_type` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_income` varchar(255) DEFAULT NULL,
  `type_of_employment` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`referenceid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card_eligibility`
--

LOCK TABLES `credit_card_eligibility` WRITE;
/*!40000 ALTER TABLE `credit_card_eligibility` DISABLE KEYS */;
INSERT INTO `credit_card_eligibility` VALUES (4,'1996-05-05','Classic','smithst@email.com','smith','vid',8945125623,'Approved','500000','Salaried',1111111111111112),(5,'1990-05-05','Classic','smithst@email.com','asfa','vid',9598561256,'Approved','1000000','Salaried',1111111111111112),(6,'1990-05-05','Platinum','david.smith@gmail.com','david','smith',5612562345,'Approved','450000','Salaried',1111111111111112),(7,'1986-05-05','Classic','John@mail.com','shane','john',5828529635,'Approved','600000','Salaried',1111111111111112),(8,'1990-05-05','Gold','little@email.com','stuart','little',4512895623,'Approved','56000','Self Employed',1111111111111112),(9,'1990-12-12','Classic','david.smith@gmail.com','david','smith',4512562356,'Approved','600000','Salaried',1111111111111112),(10,'1990-05-05','Classic','davind@email.com','asfa','smith',9598561256,'Pending','500000','Salaried',1111111111111112);
/*!40000 ALTER TABLE `credit_card_eligibility` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-08 23:30:03
