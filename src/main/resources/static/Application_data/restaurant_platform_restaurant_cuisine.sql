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
-- Table structure for table `restaurant_cuisine`
--

DROP TABLE IF EXISTS `restaurant_cuisine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_cuisine` (
  `restaurant_id` varchar(255) NOT NULL,
  `cuisine_id` varchar(255) NOT NULL,
  PRIMARY KEY (`restaurant_id`,`cuisine_id`),
  KEY `FKhw4vlfx00luibttwkmrybfhb2` (`cuisine_id`),
  CONSTRAINT `FK63iat48y97yuwl8p72ks3c9of` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  CONSTRAINT `FKhw4vlfx00luibttwkmrybfhb2` FOREIGN KEY (`cuisine_id`) REFERENCES `cuisines` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_cuisine`
--

LOCK TABLES `restaurant_cuisine` WRITE;
/*!40000 ALTER TABLE `restaurant_cuisine` DISABLE KEYS */;
INSERT INTO `restaurant_cuisine` VALUES ('164d7670-cf1e-45c8-8888-0532ceb01f1e','08250d36-ac39-44d9-a035-dc7e75a2afbf'),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712','08250d36-ac39-44d9-a035-dc7e75a2afbf'),('b77250a4-1485-4bd4-9147-22f1b0380484','08250d36-ac39-44d9-a035-dc7e75a2afbf'),('fd1f9591-dba6-4912-8121-16bc44341119','08250d36-ac39-44d9-a035-dc7e75a2afbf'),('b77250a4-1485-4bd4-9147-22f1b0380484','0acae286-2f7d-4f49-87af-582f5b1bd0bd'),('fd1f9591-dba6-4912-8121-16bc44341119','0acae286-2f7d-4f49-87af-582f5b1bd0bd'),('a6d3bf39-8051-48d1-9979-b8854c606204','0bd3d23a-0e84-4a9a-9424-40ce0f6cbd7d'),('1cbef271-471a-418e-90e3-865beba52181','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('2101e678-4c79-4466-b6e4-f47a096d1f8e','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('66bcaa3a-bc2f-4ceb-893c-5a2756af7d87','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('d08360b2-9648-4dde-a9af-5a07b97c0116','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('dd131a6b-f994-4c45-8600-a77f80d9cb8c','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('e20fd73f-730f-435d-9e9d-0071a38e9515','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('f4fcd221-bb92-4596-abaa-a6f28c1efa77','0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9'),('dd131a6b-f994-4c45-8600-a77f80d9cb8c','14bc8ab2-8184-4c22-ae7f-7e26899661e6'),('164d7670-cf1e-45c8-8888-0532ceb01f1e','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('96e51e54-ca1f-48c4-a697-dc984dfbedd2','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('b77250a4-1485-4bd4-9147-22f1b0380484','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('ccedf9c4-be46-483e-a559-00f91e2dcca7','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('fd1f9591-dba6-4912-8121-16bc44341119','261f7c62-ae3a-417a-b746-ed1f67b58cbc'),('a6d3bf39-8051-48d1-9979-b8854c606204','4222654c-83a2-4f3e-a670-354d94fe584e'),('96e51e54-ca1f-48c4-a697-dc984dfbedd2','4b9dfa78-8f35-486d-a985-1eff728874ee'),('ccedf9c4-be46-483e-a559-00f91e2dcca7','4bd83404-03fb-44d1-9710-142bd3ac56fa'),('71606d52-3488-4348-a69b-d12ee99b7461','5195ad47-bf4f-4a49-9b06-153b93aaa106'),('a396d93e-d1f3-4b23-a621-2e33d37382a6','5195ad47-bf4f-4a49-9b06-153b93aaa106'),('ccedf9c4-be46-483e-a559-00f91e2dcca7','5195ad47-bf4f-4a49-9b06-153b93aaa106'),('2101e678-4c79-4466-b6e4-f47a096d1f8e','51fdfe35-4680-448a-a8b0-27c9f4588bfd'),('d08360b2-9648-4dde-a9af-5a07b97c0116','51fdfe35-4680-448a-a8b0-27c9f4588bfd'),('71606d52-3488-4348-a69b-d12ee99b7461','5ab78faf-36a9-4b90-902a-6b07247ac885'),('c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','5ab78faf-36a9-4b90-902a-6b07247ac885'),('a396d93e-d1f3-4b23-a621-2e33d37382a6','688f7b59-340e-456a-b135-17005256007f'),('d08360b2-9648-4dde-a9af-5a07b97c0116','6ef66753-c517-40d4-a49a-eaeb1299d4a3'),('2101e678-4c79-4466-b6e4-f47a096d1f8e','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('96e51e54-ca1f-48c4-a697-dc984dfbedd2','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('d08360b2-9648-4dde-a9af-5a07b97c0116','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('f4fcd221-bb92-4596-abaa-a6f28c1efa77','7216f1ae-06bd-4b02-b123-cc1c8e003f8f'),('2101e678-4c79-4466-b6e4-f47a096d1f8e','77c73ab6-4a9d-4bde-b19a-7eb7c41db8a1'),('71606d52-3488-4348-a69b-d12ee99b7461','7cecc493-a8c2-4eee-82a4-a16f680a7656'),('66bcaa3a-bc2f-4ceb-893c-5a2756af7d87','8c0e722f-fb78-4241-a63a-6a361c5c79dc'),('96e51e54-ca1f-48c4-a697-dc984dfbedd2','8c0e722f-fb78-4241-a63a-6a361c5c79dc'),('71606d52-3488-4348-a69b-d12ee99b7461','9b0b505d-e3c7-4144-9745-dd1911746a50'),('b77250a4-1485-4bd4-9147-22f1b0380484','9b0b505d-e3c7-4144-9745-dd1911746a50'),('fd1f9591-dba6-4912-8121-16bc44341119','9b0b505d-e3c7-4144-9745-dd1911746a50'),('29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','afbbd147-563d-41b9-bd36-92b37e8c800d'),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712','afbbd147-563d-41b9-bd36-92b37e8c800d'),('71606d52-3488-4348-a69b-d12ee99b7461','afbbd147-563d-41b9-bd36-92b37e8c800d'),('96e51e54-ca1f-48c4-a697-dc984dfbedd2','afbbd147-563d-41b9-bd36-92b37e8c800d'),('a396d93e-d1f3-4b23-a621-2e33d37382a6','afbbd147-563d-41b9-bd36-92b37e8c800d'),('ccedf9c4-be46-483e-a559-00f91e2dcca7','afbbd147-563d-41b9-bd36-92b37e8c800d'),('d08360b2-9648-4dde-a9af-5a07b97c0116','afbbd147-563d-41b9-bd36-92b37e8c800d'),('dd131a6b-f994-4c45-8600-a77f80d9cb8c','afbbd147-563d-41b9-bd36-92b37e8c800d'),('f4fcd221-bb92-4596-abaa-a6f28c1efa77','afbbd147-563d-41b9-bd36-92b37e8c800d'),('d08360b2-9648-4dde-a9af-5a07b97c0116','b12b4dae-ac05-46c8-8a22-8abf5df4152a'),('dd131a6b-f994-4c45-8600-a77f80d9cb8c','b1ad743c-1229-4cc0-953e-cb8f064d5f7b'),('164d7670-cf1e-45c8-8888-0532ceb01f1e','cc2c9699-8d67-4f1e-80d7-ec14fe0978fd'),('a6d3bf39-8051-48d1-9979-b8854c606204','cc2c9699-8d67-4f1e-80d7-ec14fe0978fd'),('e20fd73f-730f-435d-9e9d-0071a38e9515','cc7a44c9-30d9-47bd-bf2e-0600b59a7eef'),('f4fcd221-bb92-4596-abaa-a6f28c1efa77','cc7a44c9-30d9-47bd-bf2e-0600b59a7eef'),('d08360b2-9648-4dde-a9af-5a07b97c0116','ce584e51-ba30-49b9-aed0-601c29f0319e'),('a6d3bf39-8051-48d1-9979-b8854c606204','d032d1b8-0bef-4592-8b46-d56d3792e4d4'),('e20fd73f-730f-435d-9e9d-0071a38e9515','d9ae9baf-222a-429f-8188-d79375c328a4'),('f4fcd221-bb92-4596-abaa-a6f28c1efa77','d9ae9baf-222a-429f-8188-d79375c328a4'),('51bb55c4-a1cb-4513-ad79-f3aeae3a4712','db0bace3-200f-4e92-95dd-4c7d232aa9f9'),('b77250a4-1485-4bd4-9147-22f1b0380484','e250cdce-78b8-4ceb-841f-003e18cfdc1c'),('e20fd73f-730f-435d-9e9d-0071a38e9515','ea41324f-6be6-4980-a3ec-53e67b859ff5'),('1cbef271-471a-418e-90e3-865beba52181','eeec3be3-e47c-4f6f-94f5-ea084b3d15a3'),('71606d52-3488-4348-a69b-d12ee99b7461','fcb5e192-3e12-45f8-93f2-16eb05a89b1b'),('a396d93e-d1f3-4b23-a621-2e33d37382a6','fcb5e192-3e12-45f8-93f2-16eb05a89b1b'),('c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','fcb5e192-3e12-45f8-93f2-16eb05a89b1b');
/*!40000 ALTER TABLE `restaurant_cuisine` ENABLE KEYS */;
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
