/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.49-community : Database - hospital
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hospital` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `hospital`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `Department_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Department_Subject` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Department_People` int(20) DEFAULT NULL,
  `Field` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Department_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `department` */

insert  into `department`(`Department_ID`,`Department_Subject`,`Department_People`,`Field`) values (1,'辦公室',5,'管理'),(2,'勞動人事處',20,'人事調動'),(3,'醫務處',30,'醫務工作'),(4,'護理部',20,'看護'),(5,'總務處',10,'工作規劃'),(6,'財務處',15,'經營統計'),(7,'器械設備科',15,'完善器械'),(8,'藥劑科',30,'配藥調試'),(9,'門診部',20,'確診'),(10,'保安部',11,'維持治安');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `Doctor_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Doctor_Name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Doctor_Age` int(20) DEFAULT NULL,
  `Doctor_Specialty` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employee` */

insert  into `employee`(`Doctor_ID`,`Doctor_Name`,`Doctor_Age`,`Doctor_Specialty`) values (1,'Lisa',25,'管理'),(2,'Tina',27,'醫務工作'),(3,'Linda',33,'看護'),(4,'Micheal',31,'醫務工作'),(5,'John',30,'確診'),(6,'Sina',29,'看護'),(7,'Tim',29,'醫務工作'),(8,'Kevin',25,'配藥調試'),(9,'Jone',27,'確診'),(10,'Bob',34,'醫務工作'),(11,'Lili',28,'確診'),(12,'Frank',29,'醫務工作'),(13,'Aimi',26,'聊天');

/*Table structure for table `hospital` */

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `Hospital_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Hospital_Address` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Hospital_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Hospital_Scale` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Hospital_ID`),
  KEY `ID` (`Hospital_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `hospital` */

insert  into `hospital`(`Hospital_ID`,`Hospital_Address`,`Hospital_Name`,`Hospital_Scale`) values (1,'台北','台北市立醫院','big'),(2,'桃園','桃園市立醫院','big'),(3,'高雄','高雄市立醫院','big'),(4,'台南','台南市立醫院','middle'),(5,'基隆','基隆市立醫院','middle'),(6,'墾丁','墾丁市立醫院','small'),(7,'新北','新北市立醫院','middle'),(8,'花蓮','花蓮市立醫院','middle'),(9,'彰化','彰化市立醫院','small'),(10,'宜蘭','宜蘭市立醫院','small');

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `Patient_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Patient_Disease` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Patient_Name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Patient_Age` int(20) DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `patient` */

insert  into `patient`(`Patient_ID`,`Patient_Disease`,`Patient_Name`,`Patient_Age`) values (1,'measles','Chen',55),(2,'cold','Lin',17),(3,'hpertension','Liu',29),(4,'migraine','Gao',44),(5,'fracture','Cai',21),(7,'typhoid','Yang',37),(8,'parkinson','Guo',70),(9,'fever','Ye',27),(10,'cold','Li',41),(11,'stomach','Xu',46),(12,'fracture','Wei',14),(13,'burn','Huang',31);

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `Report_ID` int(20) NOT NULL AUTO_INCREMENT,
  `Report_Disease` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Report_Medicine` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Report_PatientName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Report_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `report` */

insert  into `report`(`Report_ID`,`Report_Disease`,`Report_Medicine`,`Report_PatientName`) values (1,'measles','氯雷他定片','Chen'),(2,'cold','感冒膠囊','Lin'),(3,'hpertension','降壓藥','Gao'),(4,'migraine','紅龍鎮痛片','Xu'),(5,'fracture','止痛藥','Li'),(6,'fever','退燒藥','Huang'),(7,'migraine','紅龍鎮痛片','Cai'),(8,'measles','氯雷他定片','Lin'),(9,'stomach','胃藥','Huang'),(10,'hpertension','降壓藥','Yang'),(11,'cold','感冒膠囊','Xu'),(12,'fracture','止痛藥','Li');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
