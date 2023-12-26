-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: restaurant_platform
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('CUSTOMER','ADMIN') DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('21800786-2eeb-4ab2-99a7-9cd0129ab588','rushit4197@gmail.com','Rushit','Admin','$2a$10$zBCVhk6Een35uX1sQiugnOE0RGPPNrVRYC3uiNBHDh833LaOLn2Gq','ADMIN'),('4e4f70ca-a570-4538-bac0-5d1573a82319','rushitjav@gmail.com','Rushit','Javia','$2a$10$mJ.IALPnW.gP0yGMEDAjKeLIAzhSK28XdyYc0Cl.k3mgp4dSW8sHK','CUSTOMER'),('520d2d29-1a17-46a6-a407-7a3cc83274c2','rushit214@gmail.com','Rushit','Admin','$2a$10$gdx3AxKRAbXO5qDLnECjHurBjTLXbT/IIEscQi0W.V0YIpsyo5TYK','ADMIN'),('5a2ee397-34e8-452c-9b82-7534e0b4d711','rushitjavia@gmail.com','Rushit','Javia','$2a$10$2Rc05Y6GhLd4asrTnhkmYOgnmkPEtbQwwdkK.cVx8cnz2DnKMvT7.','CUSTOMER'),('64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d','trj214@gmail.com','T','J','$2a$10$IubQQH0Fzxf6VsqBML75WOQFdCvTvBLG9XkSs2j0jtR4Y3R5ZKg2.','CUSTOMER'),('6965cae0-1f78-4a82-b421-bb2ee606fe3a','dummyCustomer@gmail.com','Dummy','Customer','$2a$10$EpMSYnrU/.j2jmcF0V3isuigJvqTDJijqmM9DZIk3evtbthjrEpTW','CUSTOMER'),('9706adc2-52e2-41b3-b7c6-c819869d2f96','dummyAdmin@gmail.com','Dummy','Admin','$2a$10$z4Zi7nVj4E5N4GSq225CEeXPnorVP/Dj8A/lf5RcyWBuY9434l9hq','ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-26 18:59:09
