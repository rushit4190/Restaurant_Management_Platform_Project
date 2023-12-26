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
-- Table structure for table `customization`
--

DROP TABLE IF EXISTS `customization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization` (
  `id` varchar(255) NOT NULL,
  `available` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price_modifier` double DEFAULT NULL,
  `customization_category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9bt2xmclhhjfusr8v6aslw1yu` (`customization_category`),
  CONSTRAINT `FK9bt2xmclhhjfusr8v6aslw1yu` FOREIGN KEY (`customization_category`) REFERENCES `customization_categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization`
--

LOCK TABLES `customization` WRITE;
/*!40000 ALTER TABLE `customization` DISABLE KEYS */;
INSERT INTO `customization` VALUES ('09012be7-96cd-4bc5-9d4d-2c9eb2fbe51d',_binary '','Spicy Jalapeno',15,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('0cb1716d-a931-4260-8f7b-4393d2682598',_binary '','Onion',0,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('11eadebb-75cf-4b1e-8720-605d8e70a37f',_binary '','Cheese Burst',49,'ee9f5090-df13-471b-b205-5113d2778de1'),('159b206c-9d61-44e9-8279-b4b0eb228b14',_binary '','Pan tossed',0,'8c634696-3778-46cb-846a-2e0657b65082'),('16825ca7-1cea-4bf9-a1ec-4a87d0053e30',_binary '','Grilled',20,'acb0576e-2cd0-4e7b-9a73-26e15b6deb27'),('2867ccad-fb0f-4a08-98cf-a4f608909976',_binary '','Herb grilled Chicken',25,'ee7b3c0c-a891-45c4-bbad-9fb0efd5d7df'),('34fb942c-88eb-4227-996c-919d1da64cf6',_binary '','Tomato',0,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('3c71b942-f083-466f-8a46-396b6d049095',_binary '','Black Olives',20,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('403afe45-aa61-4adb-b44b-6b57d0641134',_binary '','Capsicum',15,'fb1f2f3f-5349-4209-b964-83f3387fe604'),('4249ef8b-1d35-4033-a868-6b28283267c8',_binary '','Tomato',0,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('4338b1bd-2ec1-44a1-9f77-985bad12845f',_binary '','Mayo',10,'b6b4b915-45e1-49d9-912e-24b9745e6e91'),('4704f2c4-15b7-4b8e-a301-ed6215f76293',_binary '','Lettuce',10,'fb1f2f3f-5349-4209-b964-83f3387fe604'),('4c13af22-53d9-49c2-9fec-b89b142ba1aa',_binary '','Golden corn',15,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('5025ca7a-47ad-48e8-8b4e-6d7199c00d3c',_binary '','Red paprika',15,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('514f0140-4bce-499c-b640-f472bcb1e27a',_binary '','6 inch',0,'e3247b99-bfdf-46eb-b116-abd0beaffe6b'),('53055ea1-119b-48a3-9939-6fa4a6d1117a',_binary '','Peri Peri Paneer',25,'fb1f2f3f-5349-4209-b964-83f3387fe604'),('5677cc46-6e47-433e-af11-5a85b73c2c81',_binary '','Golden corn',15,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('57d9b88f-0df5-4c7b-ab13-27702f56bf9e',_binary '','Spicy Jalapeno',15,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('5fb9c675-4950-422d-97af-52ed1de48672',_binary '','Capsicum',0,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('6a785d15-b35b-470a-8723-82d61ca809bd',_binary '','Pan Tossed',0,'ee9f5090-df13-471b-b205-5113d2778de1'),('7d2ff6f6-99ab-485b-b07a-072dc75007f7',_binary '','Peri Peri Paneer',10,'e44da268-74dc-4ac1-96c2-fa9d7818c82d'),('860a2a2e-32e4-4230-8111-e5b719177972',_binary '','Thin Crust',29,'8c634696-3778-46cb-846a-2e0657b65082'),('925e30d7-9f9e-4596-b5ab-dc72090aa75f',_binary '','Black Olives',20,'6c555ffa-adf4-4935-8d8a-8e1638443bc5'),('a979efa3-e4bb-4775-974e-f33e195055eb',_binary '','Capsicum',0,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('af8d81c5-6342-448e-ab4a-779bf155578f',_binary '','Not grilled',0,'acb0576e-2cd0-4e7b-9a73-26e15b6deb27'),('b731870d-a88b-4c24-9e51-df54b1a0dd3c',_binary '','Mustard',15,'b6b4b915-45e1-49d9-912e-24b9745e6e91'),('baff8908-eef9-4359-872f-19dffa9c1a1b',_binary '','Thin crust',29,'ee9f5090-df13-471b-b205-5113d2778de1'),('c257224e-8dd4-4451-b873-8ffdce248dfc',_binary '','Cheese Burst',49,'8c634696-3778-46cb-846a-2e0657b65082'),('c31e4d24-e9d4-465b-a1f2-8a8f2acc666e',_binary '','Smokey BBQ chicken',25,'ee7b3c0c-a891-45c4-bbad-9fb0efd5d7df'),('c99f4c44-6730-4539-a34c-4ff4da5be960',_binary '','Footlong',269,'e3247b99-bfdf-46eb-b116-abd0beaffe6b'),('d38414cc-2ae6-4620-9d12-4cd76a633c63',_binary '','Onion',0,'2d827bc7-b411-4259-81a5-6afc68bc3c80'),('d99cab07-78de-4284-b41c-02c2ca0e4e4b',_binary '','Grilled Mushroom',10,'e44da268-74dc-4ac1-96c2-fa9d7818c82d'),('e90a00e5-52f3-47fd-abdb-30b0d25ff82e',_binary '','Onion and Tomato',12,'fb1f2f3f-5349-4209-b964-83f3387fe604'),('fd7bdba8-959a-4988-b916-08f5e93b1cec',_binary '','Red paprika',15,'2d827bc7-b411-4259-81a5-6afc68bc3c80');
/*!40000 ALTER TABLE `customization` ENABLE KEYS */;
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
