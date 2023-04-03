-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `last_update` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `provider` varchar(255) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '',NULL,'2023-01-11 09:56:32.987000','tu94pth@gmail.com',NULL,'2023-01-11 09:56:32.987000',NULL,'$2a$10$GwgRsXi3XxswOOYC4U6gQeZ.zzjSfH4wIuZrvu9bFuklqWZ.ktqJK',NULL,'LOCAL','nguyen tu',NULL),(2,_binary '',NULL,'2023-01-14 12:47:01.183000','tuan94pth@gmail.com',NULL,'2023-01-14 12:47:01.183000',NULL,'$2a$10$5zHoc5xE8.jbrwAJewsT3uKxCrkhuhkof9Uy6NGaUGi52wdPp/P/G',NULL,'LOCAL','nguyen tuan',NULL),(3,_binary '',NULL,'2023-02-02 08:51:34.689000','phucthanh04@gmail.com',NULL,'2023-02-02 08:51:34.689000',NULL,'$2a$10$zXu4hWwj4Tet.ToNs2Qk5.dkkqMiHbFZz8IpMNiZjMzc40PQCLaZ.',NULL,'LOCAL','nguyen phuc thanh',NULL),(4,_binary '',NULL,'2023-02-02 17:26:49.170000','anhtho@gmail.com',NULL,'2023-02-02 17:26:49.170000',NULL,'$2a$10$hpysvL6Tif.ZYau8p2oaP.CDXBr/aVnN8rmNqCtzRsCTBScY2RGnG',NULL,'LOCAL','anh',NULL),(6,_binary '',NULL,'2023-02-02 17:48:38.610000','anhtho12345@gmail.com',NULL,'2023-02-02 17:48:38.610000',NULL,'$2a$10$E3.45RQlUpgycIjV6gtdkOSnUvgPgROAi8IzeOIHtx7gpqqpPv1OG',NULL,'LOCAL','phuong',NULL),(7,_binary '',NULL,'2023-02-02 17:54:31.389000','rindeptrai123@gamil.com',NULL,'2023-02-02 17:54:31.389000',NULL,'$2a$10$NFJM9wlTU1t07VaQ5PgoIuPU3tEzg8LGbbrzheGbv2Td5QF3nhjBa',NULL,'LOCAL','rindeptrai',NULL),(8,_binary '',NULL,'2023-02-02 17:59:13.512000','baga123@gmail.com',NULL,'2023-02-02 17:59:13.512000',NULL,'$2a$10$EUTFJBvlOh4iACLmwVKLE.yqhZwQFLlB1NdKrpZcdCJMHTdT9Cjx6',NULL,'LOCAL','babanga',NULL),(9,_binary '',NULL,'2023-02-13 11:41:45.715000','babodoi123@gmail.com',NULL,'2023-02-13 11:41:45.715000',NULL,'$2a$10$3iFQpjKC26BYPcrtax/v1OXoK4oUGrDOf2H0HA.Fong0esjga7vaO',NULL,'LOCAL','babodoi',NULL),(10,_binary '',NULL,'2023-04-01 20:33:22.406000','bedieu123@gmail.com',NULL,'2023-04-01 20:33:22.406000',NULL,'$2a$10$VAAqgP.abQ.B9IpSlFjSCu9M14dJaVcd56eb916rClFG8Zaiak55O',NULL,'LOCAL','bedieu',NULL);
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

-- Dump completed on 2023-04-03 22:30:55
