/*
SQLyog Community v8.6 GA
MySQL - 5.6.10-log : Database - multilanguage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`multilanguage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `multilanguage`;

/*Table structure for table `labelkey` */

CREATE TABLE `labelkey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `labelkey` */

insert  into `labelkey`(`id`,`key`) values (1,'es'),(2,'en');

/*Table structure for table `properties` */

CREATE TABLE `properties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `properties` */

insert  into `properties`(`id`,`key`,`value`,`language`) values (1,'user','Usuario 1','es'),(2,'name','Nombre','es'),(3,'lastname','Apellido','es'),(4,'age','Edad','es'),(5,'user','User','en'),(6,'name','Name','en'),(7,'lastname','Last Name','en'),(8,'age','Age','en'),(9,'language','Language','en'),(10,'language','Idioma','es'),(11,'date','Date','en'),(12,'time','Time','en'),(13,'date','Fecha','es'),(14,'time','Hora','es'),(15,'currency','Currency','en'),(16,'currency','Moneda','es');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
