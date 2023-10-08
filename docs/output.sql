DROP DATABASE IF EXISTS exam_pro;
CREATE DATABASE exam_pro;
use exam_pro;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: exam_pro
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `bankquestion`
--

DROP TABLE IF EXISTS `bankquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankquestion` (
  `LinkID` int NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `BankID` int NOT NULL COMMENT '题库ID',
  `QuestionID` int NOT NULL COMMENT '题目ID',
  PRIMARY KEY (`LinkID`),
  KEY `BankID` (`BankID`),
  KEY `QuestionID` (`QuestionID`),
  CONSTRAINT `bankquestion_ibfk_1` FOREIGN KEY (`BankID`) REFERENCES `questionbank` (`BankID`),
  CONSTRAINT `bankquestion_ibfk_2` FOREIGN KEY (`QuestionID`) REFERENCES `questionpool` (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题库题目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankquestion`
--

LOCK TABLES `bankquestion` WRITE;
/*!40000 ALTER TABLE `bankquestion` DISABLE KEYS */;
INSERT INTO `bankquestion` VALUES (1,1,1),(3,1,31),(4,1,32),(5,1,33),(6,1,34),(7,1,35);
/*!40000 ALTER TABLE `bankquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `ExamID` int NOT NULL AUTO_INCREMENT COMMENT '考试ID',
  `ExamName` varchar(255) NOT NULL COMMENT '考试名称',
  `ExamDescription` varchar(255) NOT NULL COMMENT '考试描述',
  `PaperID` int NOT NULL COMMENT '试卷ID',
  `StartTime` datetime NOT NULL COMMENT '考试开始时间',
  `EndTime` datetime NOT NULL COMMENT '考试结束时间',
  `ExamDuration` int NOT NULL COMMENT '考试时长（分钟）',
  PRIMARY KEY (`ExamID`),
  KEY `PaperID` (`PaperID`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`PaperID`) REFERENCES `papermanagement` (`PaperID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='考试表';
/*!40101 SET character_set_client = @saved_cs_client */;

ALTER TABLE exam
    ADD NumberOfExaminees INT NOT NULL DEFAULT 0 COMMENT '考试人数';

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;

/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;



--
-- Table structure for table `examrecord`
--

DROP TABLE IF EXISTS `examrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examrecord` (
  `RecordID` int NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `ExamID` int NOT NULL COMMENT '考试ID',
  `UserID` int NOT NULL COMMENT '用户ID',
  `ExamDescription` varchar(255) NOT NULL COMMENT '考试描述',
  `StartTime` datetime NOT NULL COMMENT '开始时间',
  `EndTime` datetime NOT NULL COMMENT '结束时间',
  `ObjectiveScore` int NOT NULL COMMENT '客观分',
  `SubjectiveScore` int NOT NULL COMMENT '主观分',
  `TotalScore` int NOT NULL COMMENT '总分',
  `Status` int NOT NULL COMMENT '状态',
  PRIMARY KEY (`RecordID`),
  KEY `ExamID` (`ExamID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `examrecord_ibfk_1` FOREIGN KEY (`ExamID`) REFERENCES `exam` (`ExamID`),
  CONSTRAINT `examrecord_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='在线考试记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examrecord`
--

LOCK TABLES `examrecord` WRITE;
/*!40000 ALTER TABLE `examrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `examrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examregistration`
--

DROP TABLE IF EXISTS `examregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examregistration` (
  `RegistrationID` int NOT NULL AUTO_INCREMENT COMMENT '报名ID',
  `ExamID` int NOT NULL COMMENT '考试ID',
  `UserID` int NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`RegistrationID`),
  KEY `ExamID` (`ExamID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `examregistration_ibfk_1` FOREIGN KEY (`ExamID`) REFERENCES `exam` (`ExamID`),
  CONSTRAINT `examregistration_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='考试报名表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examregistration`
--

LOCK TABLES `examregistration` WRITE;
/*!40000 ALTER TABLE `examregistration` DISABLE KEYS */;
/*!40000 ALTER TABLE `examregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradingmanagement`
--

DROP TABLE IF EXISTS `gradingmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradingmanagement` (
  `GradingID` int NOT NULL AUTO_INCREMENT COMMENT '评卷ID',
  `PaperID` int NOT NULL COMMENT '试卷ID',
  `ExamineeID` int NOT NULL COMMENT '考生ID',
  `GraderID` int NOT NULL COMMENT '创建人ID',
  `StartTime` datetime NOT NULL COMMENT '开始评卷时间',
  `EndTime` datetime NOT NULL COMMENT '结束评卷时间',
  `ObjectiveScore` int NOT NULL COMMENT '客观题分数',
  `SubjectiveScore` int NOT NULL COMMENT '主观题分数',
  `TotalScore` int NOT NULL COMMENT '总分',
  PRIMARY KEY (`GradingID`),
  KEY `PaperID` (`PaperID`),
  KEY `ExamineeID` (`ExamineeID`),
  KEY `GraderID` (`GraderID`),
  CONSTRAINT `gradingmanagement_ibfk_1` FOREIGN KEY (`PaperID`) REFERENCES `papermanagement` (`PaperID`),
  CONSTRAINT `gradingmanagement_ibfk_2` FOREIGN KEY (`ExamineeID`) REFERENCES `user` (`UserID`),
  CONSTRAINT `gradingmanagement_ibfk_3` FOREIGN KEY (`GraderID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评卷管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradingmanagement`
--

LOCK TABLES `gradingmanagement` WRITE;
/*!40000 ALTER TABLE `gradingmanagement` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradingmanagement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papermanagement`
--

DROP TABLE IF EXISTS `papermanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `papermanagement` (
  `PaperID` int NOT NULL AUTO_INCREMENT COMMENT '试卷ID',
  `PaperName` varchar(255) NOT NULL COMMENT '试卷名称',
  `ObjectiveScore` int NOT NULL COMMENT '客观题分数',
  `TotalScore` int NOT NULL COMMENT '总分',
  `SubjectiveScore` int NOT NULL COMMENT '主观题分数',
  `UserID` int NOT NULL COMMENT '创建人ID',
  PRIMARY KEY (`PaperID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `papermanagement_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papermanagement`
--


/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CalculateTotalScore` BEFORE INSERT ON `papermanagement` FOR EACH ROW BEGIN
    SET NEW.TotalScore = NEW.ObjectiveScore + NEW.SubjectiveScore;
END */;;
DELIMITER ;

LOCK TABLES `papermanagement` WRITE;
/*!40000 ALTER TABLE `papermanagement` DISABLE KEYS */;
INSERT INTO `papermanagement` VALUES (1,'小升初卷子',0,0,0,1),(2,'英语四六级试卷',0,0,0,1),(3,'教资科一考试试卷',0,0,0,1),(4,'蓝桥杯考试',0,0,0,1),(5,'佛系考试',0,0,0,2);
/*!40000 ALTER TABLE `papermanagement` ENABLE KEYS */;
UNLOCK TABLES;

/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;

/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `paperquestion`
--

DROP TABLE IF EXISTS `paperquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paperquestion` (
  `LinkID` int NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `PaperID` int NOT NULL COMMENT '试卷ID',
  `QuestionID` int NOT NULL COMMENT '题目ID',
  `QuestionType` varchar(255) NOT NULL COMMENT '题目类型',
  `Score` int NOT NULL COMMENT '题目分数',
  `Order` int NOT NULL UNIQUE COMMENT '题目顺序',
  PRIMARY KEY (`LinkID`),
  KEY `PaperID` (`PaperID`),
  CONSTRAINT `paperquestion_ibfk_1` FOREIGN KEY (`PaperID`) REFERENCES `papermanagement` (`PaperID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷题目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paperquestion`
--

LOCK TABLES `paperquestion` WRITE;
/*!40000 ALTER TABLE `paperquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `paperquestion` ENABLE KEYS */;
UNLOCK TABLES;

# 控制总分触发器
# DELIMITER //
#
# CREATE TRIGGER UpdateTotalScore
#     BEFORE INSERT ON paperquestion FOR EACH ROW
# BEGIN
#     DECLARE paperObjectiveScore INT;
#     DECLARE paperSubjectiveScore INT;
#
#     -- 获取试卷的当前客观分数和主观分数
#     SELECT ObjectiveScore, SubjectiveScore INTO paperObjectiveScore, paperSubjectiveScore
#     FROM papermanagement
#     WHERE PaperID = NEW.PaperID;
#
#     -- 更新总分为客观分数和主观分数的总和
#     SET NEW.Score = paperObjectiveScore + paperSubjectiveScore;
# END;
# //

# DELIMITER ;

--
-- Table structure for table `questionbank`
--

DROP TABLE IF EXISTS `questionbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionbank` (
  `BankID` int NOT NULL AUTO_INCREMENT COMMENT '题库ID',
  `BankName` varchar(255) NOT NULL COMMENT '题库名称',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UserID` int NOT NULL COMMENT '题库所属用户ID',
  PRIMARY KEY (`BankID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `questionbank_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题库管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionbank`
--

LOCK TABLES `questionbank` WRITE;
/*!40000 ALTER TABLE `questionbank` DISABLE KEYS */;
INSERT INTO `questionbank` VALUES (1,'英语题库','2023-09-25 01:23:21',1),(2,'数学题库','2023-09-25 01:23:21',1),(3,'我的题库','2023-09-25 02:56:33',1),(4,'12','2023-10-03 09:16:06',1),(5,'我的题库','2023-10-03 09:16:38',1),(6,'英语题库2','2023-10-04 05:16:29',1),(7,'wo','2023-10-07 09:01:17',1);
/*!40000 ALTER TABLE `questionbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionpool`
--

DROP TABLE IF EXISTS `questionpool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionpool` (
  `QuestionID` int NOT NULL AUTO_INCREMENT COMMENT '题目ID',
  `QuestionType` varchar(255) NOT NULL COMMENT '题目类型',
  `QuestionDescription` text COMMENT '题目描述',
  `UserID` int NOT NULL COMMENT '所属用户ID',
  `QuestionAnswer` text COMMENT '题目答案',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`QuestionID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `questionpool_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题目池表';
/*!40101 SET character_set_client = @saved_cs_client */;

ALTER TABLE `questionpool` ADD COLUMN `questionScore` int NOT NULL COMMENT '题目分数';
--
-- Dumping data for table `questionpool`
--

LOCK TABLES `questionpool` WRITE;
/*!40000 ALTER TABLE `questionpool` DISABLE KEYS */;
INSERT INTO `questionpool` VALUES
(1, '0', 'What is 2 + 2?', 1, '4', '2023-09-25 01:23:21', 10),
(2, '0', 'What is the capital of France?', 1, 'Paris', '2023-09-25 01:23:21', 10),
(3, '0', 'What is 3 x 3?', 1, '9', '2023-09-25 01:23:21', 10),
(16, '0', '主观题', 1, '答案', '2023-10-01 05:15:37', 10),
(17, '1', '我是单钻(exampro)A=下拉&B=将大量时间&C=大数据&D=爱上了的话', 1, 'B', '2023-10-01 05:17:13', 3),
(18, '2', 'ashldk(exampro)A=爱死了&B=阿达，&C=dasjl&D=打死了很久', 1, 'B,C', '2023-10-01 05:22:09', 5),
(19, '0', 'asdas', 1, 'sdad', '2023-10-01 05:29:36', 10),
(20, '0', 'weqewe', 1, 'qeweqw', '2023-10-01 05:32:00', 10),
(21, '0', 'psmtimuzhi今天吃什么吗', 3, '吃玉米吃烧烤', '2023-10-03 03:38:42', 10),
(22, '1', '1+1?(exampro)A=3&B=2&C=4&D=5', 3, 'B', '2023-10-03 03:38:58', 3),
(23, '2', '4+4=? 7-2=?(exampro)A=1&B=2&C=5&D=8', 3, 'C,D', '2023-10-03 03:39:37', 5),
(24, '1', '“神舟十号”飞船的速度约是每秒7.8km，而人步行的速度是每秒0.0012km。“神舟十号”飞船的速度是人步行速度的( 　)倍。(exampro)A=65&B=650&C=6500&D=65000', 3, 'C', '2023-10-03 03:45:14', 3),
(25, '1', '12(exampro)A=12&B=2&C=21&D=21', 3, 'A', '2023-10-03 03:45:50', 3),
(26, '1', '大苏打撒(exampro)A=阿斯顿&B=打算&C=打算&D=vdf', 1, 'D', '2023-10-03 05:40:57', 3),
(27, '0', '111', 1, '1111', '2023-10-08 00:57:32', 10),
(28, '0', '3333', 1, '333', '2023-10-08 00:58:30', 10),
(29, '0', '55', 1, '55', '2023-10-08 01:00:22', 10),
(30, '0', '99', 1, '99', '2023-10-08 01:42:00', 10),
(31, '0', '44', 1, '44', '2023-10-08 01:43:03', 10),
(32, '0', '88', 1, '88', '2023-10-08 01:45:02', 10),
(33, '0', '77', 1, '77', '2023-10-08 01:47:27', 10),
(34, '0', '11', 1, '11', '2023-10-08 01:48:09', 10),
(35, '0', '33', 1, '33', '2023-10-08 01:48:27', 10),
(36, '2', '我是多选题(exampro)A=534&B=534&C=534&D=534', 1, 'C', '2023-10-08 02:46:51', 5),
(37, '0', '3242', 1, '32434', '2023-10-08 02:55:00', 10);

# INSERT INTO `questionpool` VALUES (1,'0','What is 2 + 2?',1,'4','2023-09-25 01:23:21'),(2,'0','What is the capital of France?',1,'Paris','2023-09-25 01:23:21'),(3,'0','What is 3 x 3?',1,'9','2023-09-25 01:23:21'),(16,'0','主观题',1,'答案','2023-10-01 05:15:37'),(17,'1','我是单钻(exampro)A=下拉&B=将大量时间&C=大数据&D=爱上了的话',1,'B','2023-10-01 05:17:13'),(18,'2','ashldk(exampro)A=爱死了&B=阿达，&C=dasjl&D=打死了很久',1,'B,C','2023-10-01 05:22:09'),(19,'0','asdas',1,'sdad','2023-10-01 05:29:36'),(20,'0','weqewe',1,'qeweqw','2023-10-01 05:32:00'),(21,'0','psmtimuzhi今天吃什么吗',3,'吃玉米吃烧烤','2023-10-03 03:38:42'),(22,'1','1+1?(exampro)A=3&B=2&C=4&D=5',3,'B','2023-10-03 03:38:58'),(23,'2','4+4=? 7-2=?(exampro)A=1&B=2&C=5&D=8',3,'C,D','2023-10-03 03:39:37'),(24,'1','“神舟十号”飞船的速度约是每秒7.8km，而人步行的速度是每秒0.0012km。“神舟十号”飞船的速度是人步行速度的( 　)倍。(exampro)A=65&B=650&C=6500&D=65000',3,'C','2023-10-03 03:45:14'),(25,'1','12(exampro)A=12&B=2&C=21&D=21',3,'A','2023-10-03 03:45:50'),(26,'1','大苏打撒(exampro)A=阿斯顿&B=打算&C=打算&D=vdf',1,'D','2023-10-03 05:40:57'),(27,'0','111',1,'1111','2023-10-08 00:57:32'),(28,'0','3333',1,'333','2023-10-08 00:58:30'),(29,'0','55',1,'55','2023-10-08 01:00:22'),(30,'0','99',1,'99','2023-10-08 01:42:00'),(31,'0','44',1,'44','2023-10-08 01:43:03'),(32,'0','88',1,'88','2023-10-08 01:45:02'),(33,'0','77',1,'77','2023-10-08 01:47:27'),(34,'0','11',1,'11','2023-10-08 01:48:09'),(35,'0','33',1,'33','2023-10-08 01:48:27'),(36,'2','我是多选题(exampro)A=534&B=534&C=534&D=534',1,'C','2023-10-08 02:46:51'),(37,'0','3242',1,'32434','2023-10-08 02:55:00');
/*!40000 ALTER TABLE `questionpool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `Username` varchar(255) NOT NULL COMMENT '用户名',
  `Password` varchar(255) NOT NULL COMMENT '密码',
  `Role` int NOT NULL COMMENT '身份',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zhhh','e1ee0203ab28bb206f7b557722882de1',1),(2,'psn','e1ee0203ab28bb206f7b557722882de1',1),(3,'psm','e1ee0203ab28bb206f7b557722882de1',1);
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

-- 插入考试数据
INSERT INTO exam (ExamName, ExamDescription, StartTime,EndTime,PaperID, ExamDuration)
VALUES
('考试1', '第一个考试描述','2023-06-05 07:12:00','2023-06-05 08:12:00', 1, 90),
('考试2', '第二个考试描述','2023-06-05 07:12:00','2023-06-05 08:12:00', 2, 90),
('考试3', '第三个考试描述','2023-06-05 07:12:00','2023-06-05 08:12:00', 3, 90);
-- Dump completed on 2023-10-08 12:31:44

# 添加触发器 在试卷表中添加题目，需要添加一个触发器，判断添加的题目类型，
# 0表示主观题，1和2都表示客观题，在对应的试卷表的客观分数和主观分数的列中添加对应的分数


# # DROP TRIGGER IF EXISTS UpdatePaperScores;
# DELIMITER //
#
# CREATE TRIGGER UpdatePaperScores
#     AFTER INSERT ON paperquestion FOR EACH ROW
# BEGIN
#     DECLARE paperObjectiveScore INT;
#     DECLARE paperSubjectiveScore INT;
#
#     -- 获取题目类型
#     SET @questionType = NEW.QuestionType;
#
#     -- 获取试卷的当前客观分数和主观分数
#     SELECT ObjectiveScore, SubjectiveScore INTO paperObjectiveScore, paperSubjectiveScore
#     FROM papermanagement
#     WHERE PaperID = NEW.PaperID;
#
#     -- 根据题目类型更新分数
#     IF @questionType IN ('1', '2') THEN
#         -- 客观题，根据实际情况进行分数累加
#         SET paperObjectiveScore = paperObjectiveScore + NEW.Score;
#     ELSE
#         -- 主观题，根据实际情况进行分数累加
#         SET paperSubjectiveScore = paperSubjectiveScore + NEW.Score;
#     END IF;
#
#     -- 更新试卷的客观分数和主观分数
#     UPDATE papermanagement
#     SET ObjectiveScore = paperObjectiveScore, SubjectiveScore = paperSubjectiveScore
#     WHERE PaperID = NEW.PaperID;
# END;
# //
#
# DELIMITER ;

DELIMITER //

CREATE TRIGGER UpdatePaperScores
    AFTER INSERT ON paperquestion FOR EACH ROW
BEGIN
    DECLARE paperObjectiveScore INT;
    DECLARE paperSubjectiveScore INT;
    DECLARE scoreToAdd INT;

    -- 获取题目类型
    SET @questionType = NEW.QuestionType;

    -- 获取试卷的当前客观分数和主观分数
    SELECT ObjectiveScore, SubjectiveScore INTO paperObjectiveScore, paperSubjectiveScore
    FROM papermanagement
    WHERE PaperID = NEW.PaperID;

    -- 根据题目类型确定分数增加值
    IF @questionType IN ('1', '2') THEN
        -- 客观题，分数增加逻辑
        SET scoreToAdd = NEW.Score; -- 或者你需要的客观题分数增加值
        SET paperObjectiveScore = paperObjectiveScore + scoreToAdd;
    ELSE
        -- 主观题，分数增加逻辑
        SET scoreToAdd = NEW.Score; -- 或者你需要的主观题分数增加值
        SET paperSubjectiveScore = paperSubjectiveScore + scoreToAdd;
    END IF;

    -- 更新试卷的客观分数和主观分数
    UPDATE papermanagement
    SET ObjectiveScore = paperObjectiveScore, SubjectiveScore = paperSubjectiveScore ,TotalScore = paperObjectiveScore+paperSubjectiveScore
    WHERE PaperID = NEW.PaperID;


END;
//

DELIMITER ;

INSERT INTO paperquestion (PaperID, QuestionID, QuestionType, `Order`,Score)
VALUES
(1, 1, 0, 1,10);
INSERT INTO paperquestion (PaperID, QuestionID, QuestionType, `Order`,Score)
VALUES
(1, 2, 0, 2,20);
INSERT INTO paperquestion (PaperID, QuestionID, QuestionType, `Order`,Score)
VALUES
(1, 3, 0, 3,30);

-- 创建一个在插入 examregistration 表时更新 NumberOfExaminees 的触发器
DELIMITER //
CREATE TRIGGER updateNumberOfExaminees
    AFTER INSERT ON examregistration
    FOR EACH ROW
BEGIN
    -- 在 exam 表中更新 NumberOfExaminees 列
    UPDATE exam
    SET NumberOfExaminees = NumberOfExaminees + 1
    WHERE ExamID = NEW.ExamID;
END;
//
DELIMITER ;

insert into examregistration (ExamID,UserID)
values (1,1);

insert into examregistration (ExamID,UserID)
values (1,2);