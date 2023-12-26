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
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` varchar(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsu8ow2q842enesfbqphjrfi5g` (`restaurant_id`),
  KEY `FKcgy7qjc1r99dp117y9en6lxye` (`user_id`),
  CONSTRAINT `FKcgy7qjc1r99dp117y9en6lxye` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKsu8ow2q842enesfbqphjrfi5g` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES ('036fe1ee-7756-4394-b857-db7a4f7892fe','Quick delivery',5,'b77250a4-1485-4bd4-9147-22f1b0380484','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('03f6312b-e001-4f21-bc19-9c328bf2454d','Recieved wrong order',1,'d08360b2-9648-4dde-a9af-5a07b97c0116','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('064ef511-7480-4135-9d0e-c5ea302ce9b1','Misal is great',4,'1cbef271-471a-418e-90e3-865beba52181','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('072ea79a-b392-487e-abe5-a85cbce780d3','Starter quanity was very less',3,'b77250a4-1485-4bd4-9147-22f1b0380484','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('07dcf1e4-a1e0-4bab-a29e-0eeef209688f','Biryani is a must try',5,'b77250a4-1485-4bd4-9147-22f1b0380484','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('08fec71f-9fa6-443b-9f74-ede09fdfda48','BBQ chicken pizza was amazing',5,'c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('0c37e3b7-1d1a-470c-ba0c-26cd7702ea8c','Food is little over hyped',3,'66bcaa3a-bc2f-4ceb-893c-5a2756af7d87','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('0d08d2a4-25b7-4b9b-81cc-562275645c15','Packing was loose',1,'1cbef271-471a-418e-90e3-865beba52181','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('0d2c44ab-1a14-4932-9f9a-a33553e93b8c','Must try Andhra meal',5,'fd1f9591-dba6-4912-8121-16bc44341119','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('0eab4fcb-2b13-439e-8748-18defac25ea7','Not worthy the amount which we paid',2,'164d7670-cf1e-45c8-8888-0532ceb01f1e','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('1091e6b8-5134-4c15-ab12-7a53c0252b88','very expensive',1,'d08360b2-9648-4dde-a9af-5a07b97c0116','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('16f60602-34b1-4fde-91af-8ca81b6cc023','Packaging was improper',2,'dd131a6b-f994-4c45-8600-a77f80d9cb8c','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('1ad5caad-2132-49cd-b660-14a19a60eb70','Must have thukpa',5,'a6d3bf39-8051-48d1-9979-b8854c606204','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('1d2ad14c-4870-44a1-bfc1-56808931d4d1','Cold Coffee was great',5,'d08360b2-9648-4dde-a9af-5a07b97c0116','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('1e3508d1-58dc-48e4-a53d-7ab82979b4d7','Packaging and quantity was very good',5,'a6d3bf39-8051-48d1-9979-b8854c606204','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('2141c536-d3cd-48a0-88b8-749f50fe6716','Sambar was sour',2,'66bcaa3a-bc2f-4ceb-893c-5a2756af7d87','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('35fb2600-23cc-4791-93da-946f5db92fd0','kebabs are a must try',5,'ccedf9c4-be46-483e-a559-00f91e2dcca7','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('4a096585-cf8d-4768-b967-10e959c81cd9','great food worth the money',4,'51bb55c4-a1cb-4513-ad79-f3aeae3a4712','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('4b06c1fe-c7b9-4b2d-89d4-1572a71c70ab','Pizza was smaller than expected with no sides',2,'c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('555e7467-2509-4784-8cce-cf4e572dfd7b','great food little pricey though',5,'a396d93e-d1f3-4b23-a621-2e33d37382a6','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('5f67d4bd-0624-4af9-b193-0e689d6ce4b2','Amazing samosa and jalebis',5,'96e51e54-ca1f-48c4-a697-dc984dfbedd2','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('5fed2313-0f7e-4a80-8613-80d9bd9d084a','Must try paneer bowls',5,'29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('65d353f7-8d3d-4167-9f7a-0cdc5df46b08','Quantity and taste is great',4,'b77250a4-1485-4bd4-9147-22f1b0380484','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('65f4b047-59ef-4ff2-899d-20d9c5647c1c','Quanitity is very generous',5,'dd131a6b-f994-4c45-8600-a77f80d9cb8c','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('6875a7dd-0deb-4dac-8a1d-c8e061ac8420','Chicken chilli was too spicy',3,'fd1f9591-dba6-4912-8121-16bc44341119','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('6e52ee4b-94cf-4427-920e-5833ff7cdf24','Pastry was delicious',4,'e20fd73f-730f-435d-9e9d-0071a38e9515','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('6f18b3b8-bbd6-4cf6-a8d7-56a45e75c5d8','Good food good quality',5,'2101e678-4c79-4466-b6e4-f47a096d1f8e','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('70a88961-2983-4689-8c8b-aded5fb31987','Dessert packaging can be improved',1,'c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('90cdadfc-c732-4eb5-b689-870bf6747102','Quiche is must try',5,'f4fcd221-bb92-4596-abaa-a6f28c1efa77','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('94e390fe-d114-433d-b95e-ee176b000eeb','Pizza was cold but tasted okay',2,'71606d52-3488-4348-a69b-d12ee99b7461','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('9a248da7-210f-4154-8045-5a2264ac3666','Usal pav is great option for spicy brunch',4,'1cbef271-471a-418e-90e3-865beba52181','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('a0184eea-9cef-46dd-a923-cbebd92cb6c7','Vada pav was the best i ever had',5,'96e51e54-ca1f-48c4-a697-dc984dfbedd2','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('a21ba816-51d0-4897-848c-4d7a153d803d','The chicken burger is not worth the hype',3,'51bb55c4-a1cb-4513-ad79-f3aeae3a4712','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('a48b32d2-2023-42ca-8b1d-ffe43d540ec1','Cheesecake was tasty',5,'f4fcd221-bb92-4596-abaa-a6f28c1efa77','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('a4f6a9c3-bcdb-4f77-84cb-ef0a0a33baa2','Fish was kinda raw',1,'71606d52-3488-4348-a69b-d12ee99b7461','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('ad433748-2e6f-4bd1-badb-537a0967e999','Ice creams are a must try',5,'dd131a6b-f994-4c45-8600-a77f80d9cb8c','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('b40a18ea-e00b-4bf0-ab76-f94261b27fe2','quanitity was very less',1,'29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('b76996c9-c245-4638-9ed5-88218e8fba3f','Chicken teriyaki salad was awesome',5,'2101e678-4c79-4466-b6e4-f47a096d1f8e','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('be13f8bc-0cff-4fe9-8a17-9e4f2dee24f2','hot and delicious, must try rajma bowl',5,'29b5ac6c-8ec0-4ce0-b562-538a4db4cca2','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('c08dbc4b-37a3-4810-95b2-40e9603f7a51','Chicken popcorn bucket is value for money',5,'51bb55c4-a1cb-4513-ad79-f3aeae3a4712','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('c5c25f34-b7a4-41db-8fde-ffb4dbcc9318','Sandwiches got cold by the time it was delivered',1,'f4fcd221-bb92-4596-abaa-a6f28c1efa77','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('caa9e5d1-abac-49cb-96e5-788e4935afe8','food seem stale',1,'51bb55c4-a1cb-4513-ad79-f3aeae3a4712','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('d0616e82-4be9-4799-aac3-f7c6eab218ec','Food was great',5,'164d7670-cf1e-45c8-8888-0532ceb01f1e','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('d1be3de2-a38f-46df-8114-5d75d27435c2','Masala dosa is a must try',5,'66bcaa3a-bc2f-4ceb-893c-5a2756af7d87','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('d6876002-27d9-4f23-abe8-c322ebe25fc9','Humus was amazing',5,'71606d52-3488-4348-a69b-d12ee99b7461','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('d8bf1901-79de-47c9-b349-632c2e5015ff','Food was lipsmacking',5,'ccedf9c4-be46-483e-a559-00f91e2dcca7','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('da74b2f2-d597-4a0f-b9cf-9917002ebcf4','Garlic bread is worth the price',5,'c6371ca3-f51c-4f1e-96d5-2e42ece2e1e9','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('debda0a1-159e-4ce1-8e15-b5f4fe0a3d75','Sourdough is worth the price, must try',5,'e20fd73f-730f-435d-9e9d-0071a38e9515','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('e2e2099e-5f38-47f4-9b13-4bf9f69848f3','Would not recommend rolls, found insect in it',1,'96e51e54-ca1f-48c4-a697-dc984dfbedd2','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('e3e0378a-69c8-4edc-b220-bd1dc360f3fa','Food tastes bad',2,'164d7670-cf1e-45c8-8888-0532ceb01f1e','21800786-2eeb-4ab2-99a7-9cd0129ab588'),('e5ed041f-4706-4104-a12c-2769126504f6','Chicken Thukpa is out of the world',5,'a6d3bf39-8051-48d1-9979-b8854c606204','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('e8ebe9cc-5e58-46a4-9727-a41cd2138907','Chicken steak was cold and dry',2,'a396d93e-d1f3-4b23-a621-2e33d37382a6','64e395f8-88e2-4bb5-85f2-34dcc5a8ce8d'),('eea79e05-a998-4df9-b4c5-e9bdd48d0e41','very horrible taste, wont recommend',2,'2101e678-4c79-4466-b6e4-f47a096d1f8e','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('f671b4b8-9da4-43ae-9aeb-34d280e384b6','Food tastes very bad',3,'164d7670-cf1e-45c8-8888-0532ceb01f1e','21800786-2eeb-4ab2-99a7-9cd0129ab588'),('fb36626c-ab35-4ee2-b5f4-77a4ccabd185','Chicken biryani needs to hyped up, must try',5,'fd1f9591-dba6-4912-8121-16bc44341119','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('ff613c4e-d841-4265-a364-799c19c84ab4','Pckaging can be better',3,'ccedf9c4-be46-483e-a559-00f91e2dcca7','5a2ee397-34e8-452c-9b82-7534e0b4d711'),('ff86e4e3-0e42-4c94-9791-18ab3b9ea48e','Paneer chilli cant be without garlic, seriously!',1,'fd1f9591-dba6-4912-8121-16bc44341119','5a2ee397-34e8-452c-9b82-7534e0b4d711');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
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
