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
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurants` (
  `id` varchar(255) NOT NULL,
  `average_cost` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `poster` longblob,
  `rating` double DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `building_no` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `house_no` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `location` varbinary(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `total_rating` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hs57n29k4u6jfc5t978bq7wg9` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES ('164d7670-cf1e-45c8-8888-0532ceb01f1e',150,'Known for north indian delicacies','Khan Regency','123456',NULL,3.2,'Banaswadi','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\0\0\0\0\0\0@]`\0\0\0\0\0','560051','',50),('1cbef271-471a-418e-90e3-865beba52181',150,'Known for authentic misals','Mamledar Misal','123456',NULL,4.1,'Chembur','','Mumbai','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@L™™™™š@]fffff','400082','',11000),('2101e678-4c79-4466-b6e4-f47a096d1f8e',250,'Known for inhouse bread fastfood','Subway','123456',NULL,3.8,'Shivajinagara','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M™™™™š@]S33333','560052','',587),('29b5ac6c-8ec0-4ce0-b562-538a4db4cca2',150,'Known for delicious rice bowls, portion size, good quality and packaging','NH1 Bowls - Highway To North','123456',NULL,4.6,'Shantinagar','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M333333@]S33333','560057','',917),('49b2b622-8bae-4465-aba6-90af1f800fbb',250,'Known for tasty gujarati food','test','123456',NULL,4.1,'Tilaknagar','','Mumbai','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@L&fffff@]fffff','400089','',11000),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712',400,'Famous for chicken fast food','KFC','12345',NULL,4,'Shantinagar','','Benagaluru','','near bus station',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@L€\0\0\0\0\0@]`\0\0\0\0\0','560055','',2741),('66bcaa3a-bc2f-4ceb-893c-5a2756af7d87',100,'Known for south indian food, clean packaging','The Rameshwaram Cafe','123456',NULL,4.3,'Indiranagar','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@ML\Ì\Ì\Ì\Ì\Í@]Ffffff','560058','',276),('71606d52-3488-4348-a69b-d12ee99b7461',1600,'Known for Italian delicacies and varieties of wine','Toscano','123456',NULL,4.3,'Kormanagala','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M™™™™š@]Y™™™™š','560054','7th Block',1065),('96e51e54-ca1f-48c4-a697-dc984dfbedd2',150,'Known for delicious samosas and snacks','Guru Kripa (Sion West)','123456',NULL,4.6,'Sion West','','Mumbai','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@L\Ì\Ì\Ì\Ì\Í@]\Ì\Ì\Ì\Ì\Í','400067','',10000),('a396d93e-d1f3-4b23-a621-2e33d37382a6',1200,'Known for Crowded Ambience, Live Band Performance, Excellent Decor, Wooden Interiors, Best Pub, Classy Ambience','Toit','123456',NULL,4.4,'Indiranagar','','Benagaluru','','near bus station',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M333333@]S33333','560054','',1017),('a6d3bf39-8051-48d1-9979-b8854c606204',300,'Known for authentic tibetan food, reasonable prices','Tenzin Kitchen','123456',NULL,4.2,'Koramangala','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\Ì\Ì\Ì\Ì\Í@]L\Ì\Ì\Ì\Ì\Í','560056','',11200),('b77250a4-1485-4bd4-9147-22f1b0380484',500,'Famous for delicious biryanis','Meghna Foods','123456',NULL,4.5,'Residency Road','','Benagaluru','','near bus station',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\0\0\0\0\0\0@]Ffffff','560059','',28900),('c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9',400,'Known for tasty italian food','MoJo Pizzas','123456',NULL,4.2,'Bilekahalli','','Bengaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@L¦fffff@]Ffffff','560076','',1100),('ccedf9c4-be46-483e-a559-00f91e2dcca7',1500,'Known for Live Jazz, Sophisticated Ambience, Live Performances, Comfortable Couches, Classy Decor, Wooden Interiors','Windmill Craftsworks','123456',NULL,4.7,'Whitefield','','Benagaluru','','near bus station',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M™™™™š@]`\0\0\0\0\0','560055','',6974),('d08360b2-9648-4dde-a9af-5a07b97c0116',250,'Known for affordable coffees and snacks, student crowd','Third Wave Coffee','123456',NULL,4,'Malleshwaram','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\Ì\Ì\Ì\Ì\Í@]L\Ì\Ì\Ì\Ì\Í','560053','',765),('dd131a6b-f994-4c45-8600-a77f80d9cb8c',100,'Known For Good Service and Good Food, Fair Prices, Nice Taste, Contactless Delivery, Spill Proof Packaging, Good Quality','Empire Juices and desserts','123456',NULL,4.4,'Majestic','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\0\0\0\0\0\0@]Y™™™™š','560053','',216),('e20fd73f-730f-435d-9e9d-0071a38e9515',100,'Newly opened bakery with range of options','Suchali\'s Artisan Bakehouse','123456',NULL,2.5,'Shivajinagar','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\Ì\Ì\Ì\Ì\Í@]L\Ì\Ì\Ì\Ì\Í','560053','',2),('f4fcd221-bb92-4596-abaa-a6f28c1efa77',250,'Known for clean packaged cakes, sandwiches','Theobroma','123456',NULL,3.9,'Shanthala Nagar','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M\Ì\Ì\Ì\Ì\Í@]L\Ì\Ì\Ì\Ì\Í','560055','',2474),('fd1f9591-dba6-4912-8121-16bc44341119',450,'Known for Andhra meals and biryanis, authenticity','Nagarjuna','123456',NULL,4.2,'Kormanagala','','Benagaluru','','',_binary '¬\í\0sr\0\"org.springframework.data.geo.Point1¹\éñ\Z@\0D\0xD\0yxp@M™™™™š@]Ffffff','560054','5th Block',4303);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
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
