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
-- Table structure for table `cuisines`
--

DROP TABLE IF EXISTS `cuisines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuisines` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `poster` longblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_10pbuhlugnhub3647ouvdoe13` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuisines`
--

LOCK TABLES `cuisines` WRITE;
/*!40000 ALTER TABLE `cuisines` DISABLE KEYS */;
INSERT INTO `cuisines` VALUES ('00d7443f-6b53-4ffd-8932-2ee50f287fd5','Thin and crispy South Indian crepe made from fermented rice and urad dal batter, often served with coconut chutney and sambar.','Dosa',NULL),('01d980fd-78e9-4668-84f2-aa171ac065c0','Indulge your sweet tooth with a delightful selection of desserts and traditional sweets, ranging from classic Indian sweets to international confections.','Sweets',NULL),('03e2c3d1-2083-4da3-ba68-2df040cc6007','Savor the smoky and grilled flavors of barbecue, featuring a variety of meats and vegetables cooked to perfection.','BBQ',NULL),('08250d36-ac39-44d9-a035-dc7e75a2afbf',' Delicious north indian rice plate with various flavours','Biryani',NULL),('0acae286-2f7d-4f49-87af-582f5b1bd0bd','Spicy and flavorful dishes from the Andhra Pradesh region, known for their bold use of spices and rich culinary heritage.','Andhra',NULL),('0bd3d23a-0e84-4a9a-9424-40ce0f6cbd7d','A diverse range of dishes inspired by the cuisines of East Asia, Southeast Asia, and other parts of the continent, featuring a balance of flavors and textures.','Asian',NULL),('0d2c4a96-687f-4a1c-94ff-b6fdb7fb0af9','An extensive selection of refreshing and satisfying beverages, including soft drinks, juices, and other thirst-quenching options.','Beverages',NULL),('1437946c-c1fa-49e0-a43e-dcd10822ef1c','Delicate and aromatic dishes from Lucknow, known for their refined flavors and rich culinary heritage, particularly in Awadhi cuisine.','Lucknowi',NULL),('14bc8ab2-8184-4c22-ae7f-7e26899661e6','Creamy and decadent frozen desserts in various flavors, perfect for satisfying your sweet tooth on any occasion.','Ice cream',NULL),('184df99b-57b7-4c3a-88b1-fd4e4eb62dd1','A wholesome and complete meal that includes a variety of dishes served on a single platter, providing a diverse culinary experience.','Thali',NULL),('23793341-1866-4570-b616-708858d9d6b5','Embark on a culinary journey with the vibrant and aromatic tastes of Thai cuisine, including curries, stir-fries, and noodle dishes.','Thai',NULL),('261f7c62-ae3a-417a-b746-ed1f67b58cbc',' Delicacies originating from the northern part of India.','North Indian',NULL),('2bc0b6ec-2492-4c50-a001-23c2e00373fa','Indulge in the vibrant and bold flavors of Mexican cuisine, featuring tacos, burritos, quesadillas, and other dishes made with fresh ingredients and traditional spices.','Mexican',NULL),('3589795a-ddab-4ea4-9118-f5b63ccf4bba','Flaky and stuffed flatbread, typically filled with spiced vegetables, paneer, or meat, and pan-fried to perfection.','Paratha',NULL),('3a8d1cec-320f-4714-bc2a-89c767d94b67','Convenient and flavorful wraps filled with a variety of ingredients, such as grilled chicken, veggies, and sauces, providing a portable and tasty meal option.','Wraps',NULL),('3b234b12-671a-402c-8bac-3f56dfaf5006','Long, thin strands of wheat or rice dough, stir-fried or boiled, and often mixed with vegetables, meat, or seafood, creating a delicious and satisfying dish.','Noodles',NULL),('4222654c-83a2-4f3e-a670-354d94fe584e','Delicious and steamed or fried dumplings, typically filled with a mixture of spiced meat or vegetables, popular in Tibetan and Nepali cuisines.','Momos',NULL),('45db3a6d-ed41-4de4-bd71-7ab952deb98c','Crispy and golden waffles, served with a variety of toppings such as fresh fruits, whipped cream, and syrup, creating a delightful and indulgent treat.','Waffle',NULL),('4b9dfa78-8f35-486d-a985-1eff728874ee','Flavorful fillings, such as grilled chicken, paneer, or vegetables, wrapped in a flatbread or tortilla, offering a convenient and tasty on-the-go meal.','Rolls',NULL),('4bd83404-03fb-44d1-9710-142bd3ac56fa','Tender and flavorful skewers of grilled or roasted meat, often marinated in a blend of spices, offering a delightful and aromatic experience.','Kebab',NULL),('5195ad47-bf4f-4a49-9b06-153b93aaa106','Experience a fusion of European flavors with our Continental cuisine, offering a variety of dishes from across the continent.','Continental',NULL),('51fdfe35-4680-448a-a8b0-27c9f4588bfd','A versatile and satisfying meal consisting of layers of bread with a variety of fillings, such as vegetables, cheese, or meats.','Sandwich',NULL),('5ab78faf-36a9-4b90-902a-6b07247ac885','Italian dish with toppings on round bread','Pizza',NULL),('65e1acea-3d1c-4b4d-9acb-6b36c2c819a1','An eclectic mix of dishes from various cuisines, providing a diverse and extensive menu to suit different tastes and preferences.','Multi Cuisine',NULL),('688f7b59-340e-456a-b135-17005256007f','Satisfy your cravings with classic American comfort food, including burgers, fries, hot dogs, and indulgent desserts.','American',NULL),('6ef66753-c517-40d4-a49a-eaeb1299d4a3','A delightful assortment of small bites and treats, perfect for satisfying your cravings between meals.','Snacks',NULL),('7216f1ae-06bd-4b02-b123-cc1c8e003f8f','Quick and convenient meals, often including burgers, fries, and other easily prepared dishes, perfect for those on the go.','Fast Food',NULL),('7355ebdd-ace9-42c1-9f2c-e9aae7aa2dec','Homestyle and comforting dishes prepared with love and care, offering a taste of home-cooked goodness.','Home made',NULL),('77c73ab6-4a9d-4bde-b19a-7eb7c41db8a1','Fresh and crisp salads featuring a variety of greens, vegetables, and dressings, creating a healthy and satisfying option.','Salad',NULL),('7933de16-118e-40d1-a419-bdbcbba907f5','Juicy and flavorful chicken, marinated and grilled to perfection, offering a delicious and protein-packed option.','Grilled Chicken',NULL),('7cecc493-a8c2-4eee-82a4-a16f680a7656','Delicious and comforting pasta dishes prepared with a variety of sauces, from classic marinara to creamy Alfredo, offering a satisfying and hearty meal.','Pastas',NULL),('8c0e722f-fb78-4241-a63a-6a361c5c79dc',' Delicacies originating from the southern part of India.','South Indian',NULL),('9b0b505d-e3c7-4144-9745-dd1911746a50','Fresh and delectable seafood dishes featuring a variety of fish, shrimp, and other marine delights, prepared with flavorful marinades and spices.','Seafood',NULL),('9f1237ff-3aec-4624-9fa9-c352c22d212f','Warm and comforting soups, available in a range of flavors and styles, perfect for a light and nourishing meal.','Soup',NULL),('a8490148-d890-43a0-8a1d-d2d32d767fad','Cuisine from the coastal state of Kerala, featuring a variety of seafood, coconut-based dishes, and a unique blend of spices.','Kerala',NULL),('afbbd147-563d-41b9-bd36-92b37e8c800d','Sweet dishes generally after heavy meal ','Dessert',NULL),('b12b4dae-ac05-46c8-8a22-8abf5df4152a','Indulge in the rich and aromatic flavors of coffee, prepared to your liking, whether it\'s a classic black coffee, espresso, or a creamy latte.','Coffee',NULL),('b1ad743c-1229-4cc0-953e-cb8f064d5f7b','Refreshing and nutritious fruit or vegetable juices, available in a variety of flavors to quench your thirst and boost your energy.','Juices',NULL),('bb044ff5-11a5-4c0f-b7d1-7804257c69e2','Delicious and vegetarian dishes from the state of Gujarat, known for their sweet and spicy flavors, often accompanied by flatbreads and rice.','Gujarati',NULL),('cc2c9699-8d67-4f1e-80d7-ec14fe0978fd',' Spicy dishes originating from the China','Chinese',NULL),('cc7a44c9-30d9-47bd-bf2e-0600b59a7eef','Celebrate special moments with our delectable cakes, available in a variety of flavors and designs, perfect for birthdays, anniversaries, and other joyous occasions.','Cake',NULL),('ce584e51-ba30-49b9-aed0-601c29f0319e','Savor a comforting cup of tea, available in various blends and styles, from traditional chai to herbal infusions.','Tea',NULL),('d032d1b8-0bef-4592-8b46-d56d3792e4d4',' Spicy dishes originating from the Tibet','Tibetian',NULL),('d29f2328-f261-4db9-8fcf-b248cc39d032','Savor the hearty and flavorful dishes from the Punjabi cuisine, known for its use of rich spices, ghee, and robust flavors in both vegetarian and non-vegetarian options.','Punjabi',NULL),('d9ae9baf-222a-429f-8188-d79375c328a4','Explore our bakery offerings for a delightful array of freshly baked goods, including bread, pastries, cookies, and other treats made with quality ingredients and expert craftsmanship.','Bakery',NULL),('db0bace3-200f-4e92-95dd-4c7d232aa9f9','Fast Food','Burger',NULL),('e250cdce-78b8-4ceb-841f-003e18cfdc1c','Rich and aromatic dishes from the city of Hyderabad, known for their use of spices, basmati rice, and slow-cooked meat.','Hyderabadi',NULL),('ea41324f-6be6-4980-a3ec-53e67b859ff5','Delicate and flaky baked treats, often filled with sweet or savory fillings, providing a delightful pastry experience.','Pastry',NULL),('ed7fd378-3cf5-47d0-9ac6-b0e0be844ccc','Start your day with a variety of delicious and nutritious breakfast options, ranging from traditional to continental dishes.','Breakfast',NULL),('eeec3be3-e47c-4f6f-94f5-ea084b3d15a3','Cuisine from the state of Maharashtra, featuring a mix of spicy and flavorful vegetarian and non-vegetarian dishes, including iconic street foods.','Maharashtrian',NULL),('fcb5e192-3e12-45f8-93f2-16eb05a89b1b',' Delicacies originating from the Italy.','Italian',NULL);
/*!40000 ALTER TABLE `cuisines` ENABLE KEYS */;
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
