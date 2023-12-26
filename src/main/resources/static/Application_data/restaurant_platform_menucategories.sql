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
-- Table structure for table `menucategories`
--

DROP TABLE IF EXISTS `menucategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menucategories` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhifrk0chymlmn6rkqoka6xiii` (`restaurant_id`),
  CONSTRAINT `FKhifrk0chymlmn6rkqoka6xiii` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menucategories`
--

LOCK TABLES `menucategories` WRITE;
/*!40000 ALTER TABLE `menucategories` DISABLE KEYS */;
INSERT INTO `menucategories` VALUES ('03266d63-3dd8-4099-9700-e5c90ab49bf3','Starters','ccedf9c4-be46-483e-a559-00f91e2dcca7'),('0331a829-b88c-48be-880d-98f5bb7d2976','Extras','1cbef271-471a-418e-90e3-865beba52181'),('05186928-2004-4587-9e6e-d008065c79c5','Rice Bowlz','51bb55c4-a1cb-4513-ad79-f3aeae3a4712'),('06afc74f-0aa8-4768-ab42-c50dd8a7231e','Desserts','96e51e54-ca1f-48c4-a697-dc984dfbedd2'),('0aca850e-dac3-4944-bc77-44d9aa215607','Food','e20fd73f-730f-435d-9e9d-0071a38e9515'),('0f00f0ca-1596-41fb-b270-fc9bc3db4663','Starters','71606d52-3488-4348-a69b-d12ee99b7461'),('10acabd1-2746-4c0d-89b6-9dfc00ca90bc','Soup and Thukpa','a6d3bf39-8051-48d1-9979-b8854c606204'),('10ff5e8b-73cd-46b5-8c02-ce9f8fe0dd29','Salad and Soups','71606d52-3488-4348-a69b-d12ee99b7461'),('113300ab-926e-4c3f-ad12-cf31aa754cea','Dessert Studio','d08360b2-9648-4dde-a9af-5a07b97c0116'),('174a90ec-20ad-42b3-8a2b-e8f30120922e','Beverages','e20fd73f-730f-435d-9e9d-0071a38e9515'),('1789c52d-880e-40c2-bc7e-f3cbf4021f8d','Breads','164d7670-cf1e-45c8-8888-0532ceb01f1e'),('1e6ee9cd-2155-4afa-bddb-5194f40de84e','Beverages and Desserts','51bb55c4-a1cb-4513-ad79-f3aeae3a4712'),('223c1878-e740-4a46-9f65-092bdda5f972','Misals','1cbef271-471a-418e-90e3-865beba52181'),('2294e25a-deea-496c-a2cb-dfb3ac91e680','Quick Bites','a396d93e-d1f3-4b23-a621-2e33d37382a6'),('23580d10-98d0-44d3-ba2b-ddb2ac990323','Food','d08360b2-9648-4dde-a9af-5a07b97c0116'),('271089cc-182f-41db-8ef7-522dad206fc0','Beverages','2101e678-4c79-4466-b6e4-f47a096d1f8e'),('3782e9fa-e017-4971-91ac-c7e8c7fd6424','Cold Beverages','d08360b2-9648-4dde-a9af-5a07b97c0116'),('38592f64-5a1b-4a0e-aa3f-fb2bffff2973','Snacks','f4fcd221-bb92-4596-abaa-a6f28c1efa77'),('3e32c215-bef2-4573-9ea3-349d1c06d1bb','Kebab','ccedf9c4-be46-483e-a559-00f91e2dcca7'),('3e4a66ca-19b2-4d08-b75a-05826257815a','Meals','fd1f9591-dba6-4912-8121-16bc44341119'),('3fa0409b-f5a5-4168-b149-5ae5114c588e','10 inch Pizzas','c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9'),('41c2c24b-b463-4b71-bb2f-f214a7b4eeeb','Rice','66bcaa3a-bc2f-4ceb-893c-5a2756af7d87'),('472c456e-2f19-48ef-8d5f-08cc61382784','Customize your own pizza','c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9'),('4a485011-294c-4616-9ac4-ea9e129e4471','Biryanis','b77250a4-1485-4bd4-9147-22f1b0380484'),('4cf3f5fb-0a55-4b87-bbfb-25690b4f627b','Desserts','dd131a6b-f994-4c45-8600-a77f80d9cb8c'),('540e5f0a-a5ec-4645-b581-850a4cfa45a9','Combo','164d7670-cf1e-45c8-8888-0532ceb01f1e'),('57d101d3-c3a0-49c7-9e6c-c9af291cc38b','Curries','b77250a4-1485-4bd4-9147-22f1b0380484'),('5ad850f7-ea89-4cb5-ac4e-d66dc702c042','Dosa','66bcaa3a-bc2f-4ceb-893c-5a2756af7d87'),('5f44db45-37e7-4905-9016-dd2814732c70','Bowls','29b5ac6c-8ec0-4ce0-b562-538a4db4cca2'),('65bdb72b-5cd1-4393-803b-b372f5267134','Desserts','29b5ac6c-8ec0-4ce0-b562-538a4db4cca2'),('66b752fa-886e-4cbd-a538-cd4fd0a8b562','Large Plates','a396d93e-d1f3-4b23-a621-2e33d37382a6'),('69e422f1-1254-435a-b0a2-8f80217a20cf','Dessert','ccedf9c4-be46-483e-a559-00f91e2dcca7'),('722b59e7-2624-4652-a0a2-9755ba8e124d','South Indian','96e51e54-ca1f-48c4-a697-dc984dfbedd2'),('7cf3155a-fc50-4064-8ac3-a207baec8dd2','Appetizers','a396d93e-d1f3-4b23-a621-2e33d37382a6'),('8b7eeb25-dffa-4591-927e-7e6aacc66bc2','Beverages','66bcaa3a-bc2f-4ceb-893c-5a2756af7d87'),('8b948f88-3fc0-4650-a6ff-ef4f73bcb0fa','Cake','f4fcd221-bb92-4596-abaa-a6f28c1efa77'),('8b9c2cb2-4c27-46ba-9cf6-b30b53abb173','Idli and Vada','66bcaa3a-bc2f-4ceb-893c-5a2756af7d87'),('8eb89992-5b81-46c0-b1c0-64dc0d42b15f','Noodles','a6d3bf39-8051-48d1-9979-b8854c606204'),('8fe0f4db-8115-4b2c-98a5-ea0f497682bd','Desserts','e20fd73f-730f-435d-9e9d-0071a38e9515'),('90687a4a-79aa-45d9-8c2b-af86c84ec8c0','Juices','dd131a6b-f994-4c45-8600-a77f80d9cb8c'),('995ded8b-aa7b-45a2-a476-26adc02184cb','Rice and Bread','b77250a4-1485-4bd4-9147-22f1b0380484'),('9c0894f6-0df2-4f39-917a-449760083b50','Desserts','71606d52-3488-4348-a69b-d12ee99b7461'),('a5d37c70-fb61-46a0-be3e-f58ec7b552a3','Starters','fd1f9591-dba6-4912-8121-16bc44341119'),('ab520dc6-2e69-46c8-b4a7-d3dd17fe0531','Rice','a6d3bf39-8051-48d1-9979-b8854c606204'),('b1357508-c887-4942-bb3d-671114274087','Make Your own sub','2101e678-4c79-4466-b6e4-f47a096d1f8e'),('b3bedda6-aa86-4ce5-821f-0f056e30da5d','Beverages','f4fcd221-bb92-4596-abaa-a6f28c1efa77'),('bbb604af-82aa-48d0-9f33-b67973a2a28b','Desserts','a396d93e-d1f3-4b23-a621-2e33d37382a6'),('c2425567-eabf-4875-adac-8465226e1697','7 inch Pizzas','c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9'),('c50bbcf4-561f-452d-8708-02d458e9c62a','Beverages','29b5ac6c-8ec0-4ce0-b562-538a4db4cca2'),('ca3b98b7-c439-48c0-9757-0891f967980a','Starters','29b5ac6c-8ec0-4ce0-b562-538a4db4cca2'),('cd3a321c-aa5a-4c4d-aefe-d2ed0da169b2','Biryanis','fd1f9591-dba6-4912-8121-16bc44341119'),('d02c8c30-d77d-447e-9839-9ba0bbcd6468','Curry','164d7670-cf1e-45c8-8888-0532ceb01f1e'),('d5ca19cc-a1ac-47ae-93f2-9f9fa7674a64','Beverages','1cbef271-471a-418e-90e3-865beba52181'),('d6414de4-a1c7-476a-9ec7-594890b87f79','Pasta and Risotto','71606d52-3488-4348-a69b-d12ee99b7461'),('d9007ef2-d167-432e-9a69-8e1d0d3d31df','Pizzas','71606d52-3488-4348-a69b-d12ee99b7461'),('d965b6b9-06c8-462d-be17-71ad5a2cd572','Burgers','51bb55c4-a1cb-4513-ad79-f3aeae3a4712'),('d97a379d-4845-4738-89b7-c0587fa7da93','Starter','51bb55c4-a1cb-4513-ad79-f3aeae3a4712'),('d9e1cc4a-d426-4d01-b8fa-19bb34c3dac4','Noodles','164d7670-cf1e-45c8-8888-0532ceb01f1e'),('da436877-a982-4e8b-bb7d-0cacdda7c37c','Sandwiches','2101e678-4c79-4466-b6e4-f47a096d1f8e'),('e87ddbad-9d70-4a4c-8c59-7d719445ba2c','Starters','b77250a4-1485-4bd4-9147-22f1b0380484'),('eaf77598-9071-4e6a-9ccb-a8d2593c6874','Snacks','96e51e54-ca1f-48c4-a697-dc984dfbedd2'),('eb0d658b-fcf7-45b3-ba99-2abb3aa3f2c7','Starters','164d7670-cf1e-45c8-8888-0532ceb01f1e'),('eb6c81ff-d034-4edd-821c-7880dc8fce9f','Rolls','96e51e54-ca1f-48c4-a697-dc984dfbedd2'),('f2bec34b-0a5f-43bb-9345-a45896b206b2','Freshly Baked','e20fd73f-730f-435d-9e9d-0071a38e9515'),('f46e8ffc-3d63-4ea1-aabf-6f5c78c452ac','Main Course','ccedf9c4-be46-483e-a559-00f91e2dcca7'),('f710b1d4-b140-4cc6-8d86-b451172c46e4','Salad','2101e678-4c79-4466-b6e4-f47a096d1f8e'),('f79b662c-8cca-460d-a2e5-0567520ea1c4','Hot Beverages','d08360b2-9648-4dde-a9af-5a07b97c0116'),('fad93e7d-f277-45f9-971b-38519a2edf7c','Momos','a6d3bf39-8051-48d1-9979-b8854c606204');
/*!40000 ALTER TABLE `menucategories` ENABLE KEYS */;
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
