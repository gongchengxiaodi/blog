/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.29 : Database - blog
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` longtext,
  `imgurl` varchar(200) DEFAULT NULL,
  `flag` varchar(200) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `share` tinyint(1) DEFAULT NULL,
  `pay` tinyint(1) DEFAULT NULL,
  `comment` tinyint(1) DEFAULT NULL,
  `copyright` tinyint(1) DEFAULT NULL,
  `describes` varchar(2000) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `typoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `typoid` (`typoid`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_blog_ibfk_2` FOREIGN KEY (`typoid`) REFERENCES `t_typo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Table structure for table `t_blog_tages` */

DROP TABLE IF EXISTS `t_blog_tages`;

CREATE TABLE `t_blog_tages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogid` int(11) DEFAULT NULL,
  `tagesid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tagesid` (`tagesid`),
  KEY `blogid` (`blogid`),
  CONSTRAINT `t_blog_tages_ibfk_1` FOREIGN KEY (`tagesid`) REFERENCES `t_tages` (`id`),
  CONSTRAINT `t_blog_tages_ibfk_2` FOREIGN KEY (`blogid`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `imgurl` varchar(200) DEFAULT NULL,
  `blogid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blogid` (`blogid`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blogid`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_tages` */

DROP TABLE IF EXISTS `t_tages`;

CREATE TABLE `t_tages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Table structure for table `t_typo` */

DROP TABLE IF EXISTS `t_typo`;

CREATE TABLE `t_typo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `nickname` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `imgurl` varchar(200) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
