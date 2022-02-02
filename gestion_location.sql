-- MySQL dump 10.19  Distrib 10.3.31-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: gestion_location
-- ------------------------------------------------------
-- Server version	10.3.31-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bailleur`
--

DROP TABLE IF EXISTS `bailleur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bailleur` (
  `id_bailleur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_bailleur` varchar(50) DEFAULT NULL,
  `telephone_bailleur` varchar(50) NOT NULL,
  `email_bailleur` varchar(100) DEFAULT NULL,
  `prenom1` varchar(50) DEFAULT NULL,
  `prenom2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_bailleur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bailleur`
--

LOCK TABLES `bailleur` WRITE;
/*!40000 ALTER TABLE `bailleur` DISABLE KEYS */;
INSERT INTO `bailleur` VALUES (1,'abdoul','7252524','a@b.c','kader','rabiou'),(2,'abdoul','7252524','a@b.c','kader','rabiou'),(3,'a','a','abdoulrazakmahamadou151@gmail.com','Abdoul Razak Mahamadou Moussa','Abdoul Razak Mahamadou Moussa'),(4,'Abdoul Razak Mahamadou Moussa','90448747','abdoulrazakmahamadou151@gmail.com','Abdoul Razak Mahamadou Moussa','Abdoul Razak Mahamadou Moussa'),(5,'Abdoul Razak Mahamadou Moussa','90448747','abdoulrazakmahamadou151@gmail.com','Abdoul Razak Mahamadou Moussa','Abdoul Razak Mahamadou Moussa');
/*!40000 ALTER TABLE `bailleur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bien`
--

DROP TABLE IF EXISTS `bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bien` (
  `id_bien` int(11) NOT NULL AUTO_INCREMENT,
  `addresse` varchar(100) NOT NULL,
  `surface` int(11) NOT NULL,
  PRIMARY KEY (`id_bien`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
INSERT INTO `bien` VALUES (1,'maradi',400),(3,'ab',300),(4,'maisom',400),(5,'boutique',50),(7,'a',400),(8,'lavabo',200);
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `charge`
--

DROP TABLE IF EXISTS `charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `charge` (
  `id_charge` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) NOT NULL,
  `id_location` int(11) NOT NULL,
  PRIMARY KEY (`id_charge`),
  KEY `pk_charge` (`id_location`),
  CONSTRAINT `pk_charge` FOREIGN KEY (`id_location`) REFERENCES `location` (`id_location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charge`
--

LOCK TABLES `charge` WRITE;
/*!40000 ALTER TABLE `charge` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipement`
--

DROP TABLE IF EXISTS `equipement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipement` (
  `id_equipement` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  `id_bien` int(11) NOT NULL,
  PRIMARY KEY (`id_equipement`),
  KEY `pk_bien` (`id_bien`),
  CONSTRAINT `pk_bien` FOREIGN KEY (`id_bien`) REFERENCES `bien` (`id_bien`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipement`
--

LOCK TABLES `equipement` WRITE;
/*!40000 ALTER TABLE `equipement` DISABLE KEYS */;
INSERT INTO `equipement` VALUES (1,'aw',3),(2,'qwmf',3),(3,'rt',3),(4,'salon',4),(5,' chambre',4),(6,' fenetre',4),(7,' porte',4),(8,'porte',5),(9,' ventilo',5),(10,' ampoule',5),(11,'porte',5),(12,' ventilo',5),(13,' ampoule',5),(14,'douche',7),(15,'ampoule',7),(16,'am',8),(17,'a',8),(18,'ajhw',8),(19,'jsgfu',8),(20,'ahvdjsa',8);
/*!40000 ALTER TABLE `equipement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garant`
--

DROP TABLE IF EXISTS `garant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garant` (
  `id_garant` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  `valeur` varchar(50) DEFAULT NULL,
  `id_locataire` int(11) NOT NULL,
  PRIMARY KEY (`id_garant`),
  KEY `pk_garant` (`id_locataire`),
  CONSTRAINT `pk_garant` FOREIGN KEY (`id_locataire`) REFERENCES `locataire` (`id_locataire`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garant`
--

LOCK TABLES `garant` WRITE;
/*!40000 ALTER TABLE `garant` DISABLE KEYS */;
INSERT INTO `garant` VALUES (4,'abdou',NULL,2),(5,' banque',NULL,2),(6,'ali',NULL,1),(7,' sani',NULL,1),(8,' tairou',NULL,1),(9,'abdou',NULL,1),(10,'abdou',NULL,1),(11,' banque',NULL,1),(12,' banque',NULL,1);
/*!40000 ALTER TABLE `garant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locataire`
--

DROP TABLE IF EXISTS `locataire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locataire` (
  `id_locataire` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom1` varchar(50) NOT NULL,
  `prenom2` varchar(50) DEFAULT NULL,
  `addresse` varchar(50) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_locataire`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locataire`
--

LOCK TABLES `locataire` WRITE;
/*!40000 ALTER TABLE `locataire` DISABLE KEYS */;
INSERT INTO `locataire` VALUES (1,'Mahamadou Moussa','Abdoul Razak','a','niamey','80474297','abdoulrazakmahamadou151@gmail.com'),(2,'a','a','Abdoul Razak Mahamadou Moussa','niamey','80474297','abdoulrazakmahamadou151@gmail.com'),(3,'Mahamadou Moussa','Abdoul Razak','Abdoul Razak Mahamadou Moussa','niamey','80474297','abdoulrazakmahamadou151@gmail.com'),(5,'Mahamadou Moussa','Abdoul Razak','a','niamey','80474297','abdoulrazakmahamadou151@gmail.com');
/*!40000 ALTER TABLE `locataire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id_location` int(11) NOT NULL AUTO_INCREMENT,
  `duree` varchar(20) NOT NULL,
  `montant` int(11) NOT NULL,
  `id_bien` int(11) NOT NULL,
  `id_locataire` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `created_at` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_location`),
  KEY `pk_bienl` (`id_bien`),
  KEY `pk_locatairel` (`id_locataire`),
  KEY `pk_user` (`id_user`),
  CONSTRAINT `pk_bienl` FOREIGN KEY (`id_bien`) REFERENCES `bien` (`id_bien`),
  CONSTRAINT `pk_locatairel` FOREIGN KEY (`id_locataire`) REFERENCES `locataire` (`id_locataire`),
  CONSTRAINT `pk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'2',400,1,1,1,'2021-10-29'),(2,'2',400,1,1,1,'2021-10-29'),(3,'20',1200,1,1,1,'2020-10-20'),(4,'12',200000,1,1,1,'20201'),(5,'12',12,1,1,1,'20201'),(6,'12',200000,1,1,1,'2022-01-09T20:26'),(7,'12',200000,1,1,1,'2022-01-27T21:19'),(8,'12',20000,1,1,1,'2022-01-12T21:21'),(9,'12',20000,1,1,1,'2022-01-12T21:21'),(10,'12',1200,1,2,1,'2021-12-28T21:32'),(11,'12',1200,1,2,1,'2022-01-28T00:15'),(12,'123',200000000,1,3,1,'2022-01-06T21:17'),(13,'12',1200,1,2,1,'2022-01-06T22:29'),(14,'12',1234,1,2,1,'2022-01-28T04:35');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paiement` (
  `id_paiement` int(11) NOT NULL AUTO_INCREMENT,
  `montant_paye` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  `date_paye` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_paiement`),
  KEY `pk_paye` (`id_location`),
  CONSTRAINT `pk_paye` FOREIGN KEY (`id_location`) REFERENCES `location` (`id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paiement`
--

LOCK TABLES `paiement` WRITE;
/*!40000 ALTER TABLE `paiement` DISABLE KEYS */;
INSERT INTO `paiement` VALUES (2,1200,2,'2022-01-30T22:15');
/*!40000 ALTER TABLE `paiement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'abdoulrazak','abdoulrazak'),(2,'abdoulrazakmahamadou151@gmail.com','a'),(3,'abdoulrazakmahamadou151@gmail.ne','a'),(4,'a','a'),(5,'Abdoul Razak Mahamadou Moussa','a'),(6,'abdoulrazakmahamadou151@gmail.com','a');
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

-- Dump completed on 2022-02-02 17:07:45
