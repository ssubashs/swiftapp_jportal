CREATE DATABASE  IF NOT EXISTS `jportal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jportal`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: jportal
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyid` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `company_url` varchar(100) DEFAULT NULL,
  `addressline1` varchar(45) DEFAULT NULL,
  `addressline2` varchar(45) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `website` varchar(200) DEFAULT NULL,
  `employertype` varchar(45) DEFAULT NULL,
  `company_contact_name` varchar(100) DEFAULT NULL,
  `company_phone` varchar(45) DEFAULT NULL,
  `company_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`companyid`),
  KEY `company_contact_idx` (`company_contact_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `docs`
--

DROP TABLE IF EXISTS `docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docs` (
  `docid` int(11) NOT NULL AUTO_INCREMENT,
  `content` longblob,
  `description` varchar(255) DEFAULT NULL,
  `docname` varchar(255) DEFAULT NULL,
  `docsize` bigint(20) DEFAULT NULL,
  `doctype` varchar(255) DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`docid`),
  KEY `FK_ipwlkcgq4x0bud9abe0t7f6o5` (`profileid`),
  CONSTRAINT `FK_ipwlkcgq4x0bud9abe0t7f6o5` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `gradend` date DEFAULT NULL,
  `gradstart` date DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK_ae0wp0jlkjjxsj7orws3jt10g` (`profileid`),
  CONSTRAINT `FK_ae0wp0jlkjjxsj7orws3jt10g` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `expid` int(11) NOT NULL AUTO_INCREMENT,
  `cancontact` varchar(255) DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `iscurrent` varchar(255) DEFAULT NULL,
  `jobdescription` varchar(255) DEFAULT NULL,
  `jobtitle` varchar(255) DEFAULT NULL,
  `orgaddress` varchar(255) DEFAULT NULL,
  `orgcategory` varchar(255) DEFAULT NULL,
  `orgcountry` varchar(255) DEFAULT NULL,
  `orgname` varchar(255) DEFAULT NULL,
  `orgstate` varchar(255) DEFAULT NULL,
  `orgzip` varchar(255) DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `startdate` date DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`expid`),
  KEY `FK_27avvwpkrv6jhetmkrj804cgn` (`profileid`),
  CONSTRAINT `FK_27avvwpkrv6jhetmkrj804cgn` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `employment_type` varchar(45) DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  `job_description` varchar(500) DEFAULT NULL,
  `job_expiry` date DEFAULT NULL,
  `req_experience` varchar(45) DEFAULT NULL,
  `req_education` varchar(45) DEFAULT NULL,
  `openings` varchar(100) DEFAULT NULL,
  `benefit_pay_package` varchar(100) DEFAULT NULL,
  `benefit_relocation` varchar(100) DEFAULT NULL,
  `job_status` varchar(45) DEFAULT NULL,
  `job_contact_name` varchar(100) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `job_manager_phone` varchar(45) DEFAULT NULL,
  `job_manager_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `job_contact_idx` (`job_contact_name`),
  KEY `job_company_idx` (`company_id`),
  CONSTRAINT `job_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`companyid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobapplication`
--

DROP TABLE IF EXISTS `jobapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobapplication` (
  `jobid` int(11) NOT NULL,
  `profileid` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `applieddate` date DEFAULT NULL,
  PRIMARY KEY (`jobid`,`profileid`),
  KEY `profileref_idx` (`profileid`),
  CONSTRAINT `jobref` FOREIGN KEY (`jobid`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `profileref` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobskills`
--

DROP TABLE IF EXISTS `jobskills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobskills` (
  `jobid` int(11) NOT NULL,
  `skill` varchar(45) NOT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`jobid`,`skill`),
  CONSTRAINT `jobskill` FOREIGN KEY (`jobid`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `profileid` int(11) NOT NULL AUTO_INCREMENT,
  `addline1` varchar(255) DEFAULT NULL,
  `addline2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hphone` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `mphone` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profileskill`
--

DROP TABLE IF EXISTS `profileskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profileskill` (
  `profileid` int(11) NOT NULL,
  `skills` varchar(45) NOT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`profileid`,`skills`),
  CONSTRAINT `profileskill` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `technology` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `selfrating` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `techdescription` varchar(255) DEFAULT NULL,
  `techskill` varchar(255) DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `FK_gn0opnwc4u5jsp1motbbga7ww` (`profileid`),
  CONSTRAINT `FK_gn0opnwc4u5jsp1motbbga7ww` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `useraccess`
--

DROP TABLE IF EXISTS `useraccess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccess` (
  `profileid` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`profileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolecd` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`),
  KEY `FK_ajjuhf7vn9hr2f0rektn8js22` (`profileid`),
  CONSTRAINT `FK_ajjuhf7vn9hr2f0rektn8js22` FOREIGN KEY (`profileid`) REFERENCES `profile` (`profileid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-11 21:53:35
