-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: tutorwork
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `ActivityId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Place` varchar(45) DEFAULT NULL,
  `Start` date DEFAULT NULL,
  `End` date DEFAULT NULL,
  `Deadline` date DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  PRIMARY KEY (`ActivityId`),
  KEY `idx_activity_Title` (`Title`),
  KEY `idx_activity_Type` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `AuthorId` int(11) NOT NULL AUTO_INCREMENT,
  `ShortName` varchar(45) DEFAULT NULL,
  `isHead` tinyint(1) NOT NULL DEFAULT '1',
  `EmployeeId` int(11) DEFAULT NULL,
  `StudentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`AuthorId`),
  KEY `fk_Author_Employee1_idx` (`EmployeeId`),
  KEY `fk_Author_Student1_idx` (`StudentId`),
  KEY `idx_author_ShortName` (`ShortName`),
  CONSTRAINT `fk_Author_Employee1` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Author_Student1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Type` int(11) DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`CategoryId`),
  UNIQUE KEY `Title_UNIQUE` (`Title`),
  KEY `fk_Category_Category1_idx` (`ParentId`),
  CONSTRAINT `fk_Category_Category1` FOREIGN KEY (`ParentId`) REFERENCES `category` (`CategoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doc`
--

DROP TABLE IF EXISTS `doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doc` (
  `DocId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `Type` varchar(10) DEFAULT NULL,
  `Data` blob,
  `work_WorkId` int(11) NOT NULL,
  PRIMARY KEY (`DocId`),
  KEY `fk_doc_work1_idx` (`work_WorkId`),
  CONSTRAINT `fk_doc_work1` FOREIGN KEY (`work_WorkId`) REFERENCES `work` (`WorkId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Patronymic` varchar(32) NOT NULL,
  `Surname` varchar(32) NOT NULL,
  `JobTitle` varchar(45) NOT NULL,
  `Degree` varchar(45) DEFAULT NULL,
  `AcademicTitle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`),
  KEY `idx_employee_FName` (`Patronymic`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(20) NOT NULL,
  PRIMARY KEY (`RoleId`),
  UNIQUE KEY `Title_UNIQUE` (`Title`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sgroup`
--

DROP TABLE IF EXISTS `sgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sgroup` (
  `GroupId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GroupId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `StudentId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) DEFAULT NULL,
  `Patronymic` varchar(32) DEFAULT NULL,
  `Surname` varchar(32) DEFAULT NULL,
  `Studentcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StudentId`),
  KEY `idx_student_Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `studentgroup`
--

DROP TABLE IF EXISTS `studentgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentgroup` (
  `StudentId` int(11) NOT NULL,
  `GroupId` int(11) NOT NULL,
  PRIMARY KEY (`StudentId`,`GroupId`),
  KEY `FK_qbaqh5co5dqrr9mryaj1ktpq` (`GroupId`),
  CONSTRAINT `FK_7li0rfad5y86e3s2e6cjbkrb7` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`),
  CONSTRAINT `FK_qbaqh5co5dqrr9mryaj1ktpq` FOREIGN KEY (`GroupId`) REFERENCES `sgroup` (`GroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(16) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Password` varchar(32) NOT NULL,
  `RoleId` int(11) NOT NULL,
  `EmployeeId` int(11) NOT NULL,
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `Username_UNIQUE` (`Login`),
  KEY `fk_User_Role_idx` (`RoleId`),
  KEY `fk_User_Employee1_idx` (`EmployeeId`),
  CONSTRAINT `fk_User_Employee1` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Role` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `WorkId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Place` varchar(255) DEFAULT NULL,
  `Course` varchar(255) DEFAULT NULL,
  `Year` smallint(5) unsigned NOT NULL,
  `Month` smallint(5) unsigned NOT NULL,
  `CategoryId` int(11) NOT NULL,
  `ActivityId` int(11) DEFAULT NULL,
  `Winner` smallint(5) unsigned DEFAULT NULL,
  `EmployeeId` int(11) NOT NULL,
  `TimeCount` smallint(5) DEFAULT NULL,
  PRIMARY KEY (`WorkId`),
  KEY `fk_Work_Category1_idx` (`CategoryId`),
  KEY `fk_Work_Activity1_idx` (`ActivityId`),
  KEY `idx_work_Title` (`Title`),
  KEY `idx_work_Course` (`Course`),
  KEY `idx_work_Year` (`Year`),
  KEY `idx_work_Month` (`Month`),
  KEY `idx_work_Winner` (`Winner`),
  KEY `fk_work_employee1_idx` (`EmployeeId`),
  CONSTRAINT `fk_Work_Activity1` FOREIGN KEY (`ActivityId`) REFERENCES `activity` (`ActivityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Work_Category1` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`CategoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_work_employee1` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Represent each work of employee, that should be considered';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `workauthor`
--

DROP TABLE IF EXISTS `workauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workauthor` (
  `WorkId` int(11) NOT NULL,
  `AuthorId` int(11) NOT NULL,
  PRIMARY KEY (`WorkId`,`AuthorId`),
  KEY `fk_Work_has_Author_Author1_idx` (`AuthorId`),
  KEY `fk_Work_has_Author_Work1_idx` (`WorkId`),
  CONSTRAINT `fk_Work_has_Author_Author1` FOREIGN KEY (`AuthorId`) REFERENCES `author` (`AuthorId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Work_has_Author_Work1` FOREIGN KEY (`WorkId`) REFERENCES `work` (`WorkId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-17 22:38:14
