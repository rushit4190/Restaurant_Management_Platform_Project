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
-- Table structure for table `customization_categories`
--

DROP TABLE IF EXISTS `customization_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization_categories` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `food_item_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6tfvodyxqmvo3gmuyixs28xo1` (`food_item_id`),
  CONSTRAINT `FK6tfvodyxqmvo3gmuyixs28xo1` FOREIGN KEY (`food_item_id`) REFERENCES `food_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization_categories`
--

LOCK TABLES `customization_categories` WRITE;
/*!40000 ALTER TABLE `customization_categories` DISABLE KEYS */;
INSERT INTO `customization_categories` VALUES ('2d827bc7-b411-4259-81a5-6afc68bc3c80','Choose Classic Toppings','28a2a3a8-853e-4956-a597-2ca8ec51e6b7'),('6c555ffa-adf4-4935-8d8a-8e1638443bc5','Choose classic toppings','44273b55-8b11-40a0-8a90-1c13d0aab27c'),('8c634696-3778-46cb-846a-2e0657b65082','Choose your crust','28a2a3a8-853e-4956-a597-2ca8ec51e6b7'),('acb0576e-2cd0-4e7b-9a73-26e15b6deb27','Choose grill','858fd49d-a999-4e26-8af9-d7ee3397f8a8'),('b6b4b915-45e1-49d9-912e-24b9745e6e91','Choose Condiments','858fd49d-a999-4e26-8af9-d7ee3397f8a8'),('e3247b99-bfdf-46eb-b116-abd0beaffe6b','Choose length','858fd49d-a999-4e26-8af9-d7ee3397f8a8'),('e44da268-74dc-4ac1-96c2-fa9d7818c82d','Choose Special Topping','28a2a3a8-853e-4956-a597-2ca8ec51e6b7'),('ee7b3c0c-a891-45c4-bbad-9fb0efd5d7df','Choose special toppings','44273b55-8b11-40a0-8a90-1c13d0aab27c'),('ee9f5090-df13-471b-b205-5113d2778de1','Choose your crust','44273b55-8b11-40a0-8a90-1c13d0aab27c'),('fb1f2f3f-5349-4209-b964-83f3387fe604','Choose Ingredients','858fd49d-a999-4e26-8af9-d7ee3397f8a8');
/*!40000 ALTER TABLE `customization_categories` ENABLE KEYS */;
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
