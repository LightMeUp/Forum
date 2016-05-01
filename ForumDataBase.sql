-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: ForumDataBase
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_apirq8ka64iidc18f3k6x5tc5` (`post_id`),
  CONSTRAINT `FK_apirq8ka64iidc18f3k6x5tc5` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adminauthority` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `colleage` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `downloadauthority` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastlogindate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `publishauthority` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `uploadauthority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h1cb61txpteamwjuhnioj2nor` (`cellphone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_User`
--

DROP TABLE IF EXISTS `User_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_User` (
  `User_id` int(11) NOT NULL,
  `friends_id` int(11) NOT NULL,
  UNIQUE KEY `UK_kukojr3rgw9vjhxl8jtipwhp2` (`friends_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_User`
--

LOCK TABLES `User_User` WRITE;
/*!40000 ALTER TABLE `User_User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_data`
--

DROP TABLE IF EXISTS `User_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_data` (
  `User_id` int(11) NOT NULL,
  `datas_id` int(11) NOT NULL,
  UNIQUE KEY `UK_3dodc83q5cv192joojc6pnxau` (`datas_id`),
  KEY `FK_3dodc83q5cv192joojc6pnxau` (`datas_id`),
  CONSTRAINT `FK_3dodc83q5cv192joojc6pnxau` FOREIGN KEY (`datas_id`) REFERENCES `data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_data`
--

LOCK TABLES `User_data` WRITE;
/*!40000 ALTER TABLE `User_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `uploadingdate` date DEFAULT NULL,
  `validatedate` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `downloadrecord`
--

DROP TABLE IF EXISTS `downloadrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `downloadrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `downloadDate` date DEFAULT NULL,
  `data_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rhvq9y6v6iaany68u6q3bcwg4` (`data_id`),
  CONSTRAINT `FK_rhvq9y6v6iaany68u6q3bcwg4` FOREIGN KEY (`data_id`) REFERENCES `data` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `downloadrecord`
--

LOCK TABLES `downloadrecord` WRITE;
/*!40000 ALTER TABLE `downloadrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `downloadrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdDate` date DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  `score` float NOT NULL,
  `assignment_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p5bsvqy4rx7p92fjsbikk1lsw` (`assignment_id`),
  KEY `FK_2d037orv4w1m4oyy1ghjva7ju` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Content` varchar(255) DEFAULT NULL,
  `Theme` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_Comment`
--

DROP TABLE IF EXISTS `post_Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_Comment` (
  `post_id` int(11) NOT NULL,
  `commenties_id` int(11) NOT NULL,
  UNIQUE KEY `UK_7gdmjsaj0qesujg3n2aarjdd2` (`commenties_id`),
  KEY `FK_k1p9t6sddb2k7q520wspkcctv` (`post_id`),
  CONSTRAINT `FK_k1p9t6sddb2k7q520wspkcctv` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_Comment`
--

LOCK TABLES `post_Comment` WRITE;
/*!40000 ALTER TABLE `post_Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolAssignment`
--

DROP TABLE IF EXISTS `schoolAssignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolAssignment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assignmentNumbers` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `deadLine` date DEFAULT NULL,
  `publishDate` date DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l2yr5clboeqt7nrd3r3umxagm` (`teacher_id`),
  CONSTRAINT `FK_l2yr5clboeqt7nrd3r3umxagm` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolAssignment`
--

LOCK TABLES `schoolAssignment` WRITE;
/*!40000 ALTER TABLE `schoolAssignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `schoolAssignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adminauthority` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `colleage` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `downloadauthority` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastlogindate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `publishauthority` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `uploadauthority` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g9njl8b77b6p5q3u9ssskod8n` (`cellphone`),
  KEY `FK_20r1untn0jxde1okphj3wauof` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_evaluation`
--

DROP TABLE IF EXISTS `student_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_evaluation` (
  `student_id` int(11) NOT NULL,
  `evaluations_id` int(11) NOT NULL,
  UNIQUE KEY `UK_faafux6xlevymat4v3so8kvl0` (`evaluations_id`),
  KEY `FK_faafux6xlevymat4v3so8kvl0` (`evaluations_id`),
  KEY `FK_6lfs8vs4forr5ibrtbliyjs2j` (`student_id`),
  CONSTRAINT `FK_6lfs8vs4forr5ibrtbliyjs2j` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_faafux6xlevymat4v3so8kvl0` FOREIGN KEY (`evaluations_id`) REFERENCES `evaluation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_evaluation`
--

LOCK TABLES `student_evaluation` WRITE;
/*!40000 ALTER TABLE `student_evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adminauthority` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `colleage` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `downloadauthority` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastlogindate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `publishauthority` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `uploadauthority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9celgbno7r0wlqii4nc3f414w` (`cellphone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (22010001,'福建省福州市闽侯县上街镇福州大学软件学院',0,NULL,'12345678910',NULL,'2016-04-30',1,NULL,NULL,'单红',NULL,1,'男',1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uploadingRecord`
--

DROP TABLE IF EXISTS `uploadingRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uploadingRecord` (
  `id` int(11) NOT NULL,
  `uploadDate` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uploadingRecord`
--

LOCK TABLES `uploadingRecord` WRITE;
/*!40000 ALTER TABLE `uploadingRecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploadingRecord` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-01  9:25:38
