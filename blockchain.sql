-- MySQL dump 10.13  Distrib 8.0.19, for osx10.15 (x86_64)
--
-- Host: localhost    Database: blockchain
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `province` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `detailed_address` varchar(255) NOT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'上海市','上海','嘉定区','曹安公路4800号同济大学','100031'),(2,'上海市','上海','浦东新区','玉兰香苑2期c块','100032');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'纸巾',2.5,NULL);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logistics`
--

DROP TABLE IF EXISTS `logistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logistics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `station_id` int NOT NULL,
  `arriving_time` datetime DEFAULT NULL,
  `leaving_time` datetime DEFAULT NULL,
  `risk_level` int DEFAULT NULL,
  `submiter` int DEFAULT NULL,
  `status_` int DEFAULT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `logistics_order__id_fk` (`order_id`),
  KEY `logistics_transfer_station_id_fk` (`station_id`),
  KEY `logistics_user_id_fk` (`submiter`),
  CONSTRAINT `logistics_order__id_fk` FOREIGN KEY (`order_id`) REFERENCES `order_` (`id`),
  CONSTRAINT `logistics_transfer_station_id_fk` FOREIGN KEY (`station_id`) REFERENCES `transfer_station` (`id`),
  CONSTRAINT `logistics_user_id_fk` FOREIGN KEY (`submiter`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logistics`
--

LOCK TABLES `logistics` WRITE;
/*!40000 ALTER TABLE `logistics` DISABLE KEYS */;
INSERT INTO `logistics` VALUES (1,1,'2020-12-17 15:41:59','2020-12-20 15:42:03',1,7,2,1),(2,2,'2020-12-20 15:42:51',NULL,1,7,1,1),(3,1,'2020-12-27 10:03:55','2020-12-27 15:22:22',1,7,2,3),(7,2,'2020-12-27 10:07:55','2020-12-27 15:23:48',1,7,2,3),(8,2,'2020-12-27 15:23:48',NULL,1,7,1,3);
/*!40000 ALTER TABLE `logistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `uid` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `notification_user_id_fk` (`uid`),
  CONSTRAINT `notification_user_id_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'谈瑞你摊上事儿了！');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_`
--

DROP TABLE IF EXISTS `order_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_time` datetime NOT NULL,
  `arriving_time` datetime DEFAULT NULL,
  `addressor_id` int NOT NULL,
  `recipient_id` int NOT NULL,
  `commodity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order__related_person_id_fk` (`addressor_id`),
  KEY `order__related_person_id_fk_2` (`recipient_id`),
  CONSTRAINT `order__related_person_id_fk` FOREIGN KEY (`addressor_id`) REFERENCES `related_person` (`id`),
  CONSTRAINT `order__related_person_id_fk_2` FOREIGN KEY (`recipient_id`) REFERENCES `related_person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_`
--

LOCK TABLES `order_` WRITE;
/*!40000 ALTER TABLE `order_` DISABLE KEYS */;
INSERT INTO `order_` VALUES (1,'2020-12-12 20:13:44',NULL,1,2,NULL),(2,'2020-12-27 09:47:38',NULL,1,2,'圣诞树一棵'),(3,'2020-12-27 10:03:55',NULL,1,2,'圣诞树一棵');
/*!40000 ALTER TABLE `order_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_commodity`
--

DROP TABLE IF EXISTS `order_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_commodity` (
  `order_id` int NOT NULL,
  `commodity_id` int NOT NULL,
  KEY `order_commodity_commodity_id_fk` (`commodity_id`),
  KEY `order_commodity_order__id_fk` (`order_id`),
  CONSTRAINT `order_commodity_commodity_id_fk` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`),
  CONSTRAINT `order_commodity_order__id_fk` FOREIGN KEY (`order_id`) REFERENCES `order_` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_commodity`
--

LOCK TABLES `order_commodity` WRITE;
/*!40000 ALTER TABLE `order_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `related_person`
--

DROP TABLE IF EXISTS `related_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `related_person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_tel` varchar(11) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `risk_level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `related_person`
--

LOCK TABLES `related_person` WRITE;
/*!40000 ALTER TABLE `related_person` DISABLE KEYS */;
INSERT INTO `related_person` VALUES (1,'三把刀',1,'上海市杨浦区四平路1239号','13100000000','谈瑞',NULL,NULL,NULL),(2,'光',2,'上海市嘉定区曹安公路4800号','13100000001','韩芳',NULL,NULL,NULL),(7,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3),(8,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3),(9,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3),(10,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3),(11,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3),(12,'小谈',0,'M78星云第五星系','13122223332',NULL,231.23,23.54,3);
/*!40000 ALTER TABLE `related_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk`
--

DROP TABLE IF EXISTS `risk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `risk` (
  `id` int NOT NULL,
  `risk_code` varchar(12) DEFAULT NULL,
  `submitter` int DEFAULT NULL,
  `logistics_id` int DEFAULT NULL,
  `station_id` int DEFAULT NULL,
  `risk_description` varchar(255) DEFAULT NULL,
  `attaches` varchar(255) DEFAULT NULL,
  `cur_status` int DEFAULT NULL,
  `cur_addr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `risk_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk`
--

LOCK TABLES `risk` WRITE;
/*!40000 ALTER TABLE `risk` DISABLE KEYS */;
/*!40000 ALTER TABLE `risk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk_submit`
--

DROP TABLE IF EXISTS `risk_submit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `risk_submit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `risk_code` varchar(12) NOT NULL,
  `submitter` int NOT NULL,
  `logistics_id` int DEFAULT NULL,
  `submit_comment` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `status_` int DEFAULT NULL,
  `auditor` int DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `attached_files` varchar(255) DEFAULT NULL,
  `audit_comment` varchar(255) DEFAULT NULL,
  `station_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `risk_submit_transfer_station_id_fk` (`station_id`),
  KEY `risk_submit_user_id_fk` (`submitter`),
  KEY `risk_submit_user_id_fk_2` (`auditor`),
  KEY `risk_submit_logistics_id_fk` (`logistics_id`),
  CONSTRAINT `risk_submit_logistics_id_fk` FOREIGN KEY (`logistics_id`) REFERENCES `logistics` (`id`),
  CONSTRAINT `risk_submit_transfer_station_id_fk` FOREIGN KEY (`station_id`) REFERENCES `transfer_station` (`id`),
  CONSTRAINT `risk_submit_user_id_fk` FOREIGN KEY (`submitter`) REFERENCES `user` (`id`),
  CONSTRAINT `risk_submit_user_id_fk_2` FOREIGN KEY (`auditor`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk_submit`
--

LOCK TABLES `risk_submit` WRITE;
/*!40000 ALTER TABLE `risk_submit` DISABLE KEYS */;
INSERT INTO `risk_submit` VALUES (1,'2b2b1b2b2b3b',7,1,'发生甚么事了',1,1,8,'2020-12-24 13:46:19',NULL,'我说可以',1),(2,'123hjkkjh321',7,1,'原来是',2,0,8,'2020-12-02 14:29:32',NULL,'打我',1),(8,'2P0b71125508',7,1,'原来是昨天',1,1,8,'2020-12-27 08:51:52','url1',NULL,1),(9,'174654R401T5',7,1,'原来是昨天',2,1,8,'2020-12-27 08:52:37','url1',NULL,1),(10,'1774322n4O72',7,1,'这不好',1,-1,8,'2020-12-27 09:23:01','url1','行吧',1);
/*!40000 ALTER TABLE `risk_submit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer_station`
--

DROP TABLE IF EXISTS `transfer_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer_station` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_tel` varchar(11) DEFAULT NULL,
  `status_` int DEFAULT NULL,
  `risk` int DEFAULT NULL,
  `transportation_type` varchar(255) DEFAULT NULL,
  `transportation_code` varchar(255) DEFAULT NULL,
  `transportation_comment` varchar(255) DEFAULT NULL,
  `longitude` float DEFAULT '0',
  `latitude` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer_station`
--

LOCK TABLES `transfer_station` WRITE;
/*!40000 ALTER TABLE `transfer_station` DISABLE KEYS */;
INSERT INTO `transfer_station` VALUES (1,'四平仓库','上海市杨浦区四平路1239号','13100000000',1,1,'仓库','',NULL,123.43,132.45),(2,'嘉定仓库','上海市嘉定区曹安公路4800号','13100000001',1,1,'仓库',NULL,NULL,213.32,54.34),(3,'小谈仓库','上海市杨浦区四平路2399号','13155648176',1,1,'仓库',NULL,'全球最大仓库之一',123.74,24.53),(4,'小谈仓库','上海市杨浦区四平路2399号','13155648176',1,1,'仓库',NULL,'全球最大仓库之一',123.74,24.53),(5,'我的车',NULL,'13155648176',1,1,'货车','沪A88888','全球最大货车之一',NULL,NULL);
/*!40000 ALTER TABLE `transfer_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `telephone` varchar(11) NOT NULL,
  `type` int DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `identity_card` varchar(18) DEFAULT NULL,
  `status_` int DEFAULT NULL,
  `station_id` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_transfer_station_id_fk` (`station_id`),
  CONSTRAINT `user_transfer_station_id_fk` FOREIGN KEY (`station_id`) REFERENCES `transfer_station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'13155648176',1,'普通用户','21232f297a57a5a743894a0e4a801fc3','342425199606135218',211,NULL,'谈瑞','好人',''),(2,'15357198189',2,'供应商','21232f297a57a5a743894a0e4a801fc3',NULL,211,NULL,'怡家仁杂货店','怡家仁欢迎您！','老陈'),(6,'13155648177',3,'仓库管理员','21232f297a57a5a743894a0e4a801fc3',NULL,211,1,'小谈','在下太仓仓管员',''),(7,'13155648188',4,'工作人员','21232f297a57a5a743894a0e4a801fc3',NULL,211,1,'小韩','太仓仓库1号分拣员',NULL),(8,'13155648189',5,'审核管理员','21232f297a57a5a743894a0e4a801fc3',NULL,211,NULL,'陈管','涉及业务包含：审核风险申报和核销信息',NULL),(9,'13155648190',6,'系统管理员','21232f297a57a5a743894a0e4a801fc3',NULL,211,NULL,'一把手','涉及业务包含：新建仓库、审核仓库管理员和工作人员注册信息、审核供应商信息',NULL),(18,'13155648192',2,'普通用户','21232f297a57a5a743894a0e4a801fc3',NULL,212,1,'芳芳',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-29 17:09:16
