-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: 192.168.100.228    Database: bodenor
-- ------------------------------------------------------
-- Server version	8.0.20-0ubuntu0.19.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `circutorcvmC10`
--

DROP TABLE IF EXISTS `circutorcvmC10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `circutorcvmC10` (
  `TIMESTAMP` datetime DEFAULT NULL,
  `EQUIPO_ID` int DEFAULT NULL,
  `ITEM1` varchar(30) DEFAULT NULL,
  `ITEM2` varchar(30) DEFAULT NULL,
  `ITEM3` varchar(30) DEFAULT NULL,
  `ITEM4` varchar(30) DEFAULT NULL,
  `ITEM5` varchar(30) DEFAULT NULL,
  `ITEM6` varchar(30) DEFAULT NULL,
  `ITEM7` varchar(30) DEFAULT NULL,
  `ITEM8` varchar(30) DEFAULT NULL,
  `ITEM9` varchar(30) DEFAULT NULL,
  `ITEM10` varchar(30) DEFAULT NULL,
  `ITEM11` varchar(30) DEFAULT NULL,
  `ITEM12` varchar(30) DEFAULT NULL,
  `ITEM13` varchar(30) DEFAULT NULL,
  `ITEM14` varchar(30) DEFAULT NULL,
  `ITEM15` varchar(30) DEFAULT NULL,
  `ITEM16` varchar(30) DEFAULT NULL,
  `ITEM17` varchar(30) DEFAULT NULL,
  `ITEM18` varchar(30) DEFAULT NULL,
  `ITEM19` varchar(30) DEFAULT NULL,
  `ITEM20` varchar(30) DEFAULT NULL,
  `ITEM21` varchar(30) DEFAULT NULL,
  `ITEM22` varchar(30) DEFAULT NULL,
  `ITEM23` varchar(30) DEFAULT NULL,
  `ITEM24` varchar(30) DEFAULT NULL,
  `ITEM25` varchar(30) DEFAULT NULL,
  `ITEM26` varchar(30) DEFAULT NULL,
  `ITEM27` varchar(30) DEFAULT NULL,
  `ITEM28` varchar(30) DEFAULT NULL,
  `ITEM29` varchar(30) DEFAULT NULL,
  `ITEM30` varchar(30) DEFAULT NULL,
  `ITEM31` varchar(30) DEFAULT NULL,
  `ITEM32` varchar(30) DEFAULT NULL,
  `ITEM33` varchar(30) DEFAULT NULL,
  `ITEM34` varchar(30) DEFAULT NULL,
  `ITEM35` varchar(30) DEFAULT NULL,
  `ITEM36` varchar(30) DEFAULT NULL,
  `ITEM37` varchar(30) DEFAULT NULL,
  `ITEM38` varchar(30) DEFAULT NULL,
  `ITEM39` varchar(30) DEFAULT NULL,
  `ITEM40` varchar(30) DEFAULT NULL,
  `ITEM41` varchar(30) DEFAULT NULL,
  `ITEM42` varchar(30) DEFAULT NULL,
  `ITEM43` varchar(30) DEFAULT NULL,
  `ITEM44` varchar(30) DEFAULT NULL,
  `ITEM45` varchar(30) DEFAULT NULL,
  `ITEM46` varchar(30) DEFAULT NULL,
  `ITEM47` varchar(30) DEFAULT NULL,
  `ITEM48` varchar(30) DEFAULT NULL,
  `ITEM49` varchar(30) DEFAULT NULL,
  `ITEM50` varchar(30) DEFAULT NULL,
  `ITEM51` varchar(30) DEFAULT NULL,
  `ITEM52` varchar(30) DEFAULT NULL,
  `ITEM53` varchar(30) DEFAULT NULL,
  `ITEM54` varchar(30) DEFAULT NULL,
  `ITEM55` varchar(30) DEFAULT NULL,
  `ITEM56` varchar(30) DEFAULT NULL,
  `ITEM57` varchar(30) DEFAULT NULL,
  `ITEM58` varchar(30) DEFAULT NULL,
  `ITEM59` varchar(30) DEFAULT NULL,
  `ITEM60` varchar(30) DEFAULT NULL,
  `ITEM61` varchar(30) DEFAULT NULL,
  `ITEM62` varchar(30) DEFAULT NULL,
  `ITEM63` varchar(30) DEFAULT NULL,
  `ITEM64` varchar(30) DEFAULT NULL,
  `ITEM65` varchar(30) DEFAULT NULL,
  `ITEM66` varchar(30) DEFAULT NULL,
  `ITEM67` varchar(30) DEFAULT NULL,
  `ITEM68` varchar(30) DEFAULT NULL,
  `ITEM69` varchar(30) DEFAULT NULL,
  `ITEM70` varchar(30) DEFAULT NULL,
  `ITEM71` varchar(30) DEFAULT NULL,
  `ITEM72` varchar(30) DEFAULT NULL,
  `ITEM73` varchar(30) DEFAULT NULL,
  `ITEM74` varchar(30) DEFAULT NULL,
  `ITEM75` varchar(30) DEFAULT NULL,
  `ITEM76` varchar(30) DEFAULT NULL,
  `ITEM77` varchar(30) DEFAULT NULL,
  `ITEM78` varchar(30) DEFAULT NULL,
  `ITEM79` varchar(30) DEFAULT NULL,
  `ITEM80` varchar(30) DEFAULT NULL,
  `ITEM81` varchar(30) DEFAULT NULL,
  `ITEM82` varchar(30) DEFAULT NULL,
  `ITEM83` varchar(30) DEFAULT NULL,
  `ITEM84` varchar(30) DEFAULT NULL,
  `ITEM85` varchar(30) DEFAULT NULL,
  `ITEM86` varchar(30) DEFAULT NULL,
  `ITEM87` varchar(30) DEFAULT NULL,
  `ITEM88` varchar(30) DEFAULT NULL,
  `ITEM89` varchar(30) DEFAULT NULL,
  `ITEM90` varchar(30) DEFAULT NULL,
  `ITEM91` varchar(30) DEFAULT NULL,
  `ITEM92` varchar(30) DEFAULT NULL,
  `ITEM93` varchar(30) DEFAULT NULL,
  `ITEM94` varchar(30) DEFAULT NULL,
  `ITEM95` varchar(30) DEFAULT NULL,
  `ITEM96` varchar(30) DEFAULT NULL,
  `ITEM97` varchar(30) DEFAULT NULL,
  `ITEM98` varchar(30) DEFAULT NULL,
  `ITEM99` varchar(30) DEFAULT NULL,
  `ITEM100` varchar(30) DEFAULT NULL,
  `ITEM101` varchar(30) DEFAULT NULL,
  `ITEM102` varchar(30) DEFAULT NULL,
  `ITEM103` varchar(30) DEFAULT NULL,
  `ITEM104` varchar(30) DEFAULT NULL,
  `ITEM105` varchar(30) DEFAULT NULL,
  `ITEM106` varchar(30) DEFAULT NULL,
  `ITEM107` varchar(30) DEFAULT NULL,
  `ITEM108` varchar(30) DEFAULT NULL,
  `ITEM109` varchar(30) DEFAULT NULL,
  `ITEM110` varchar(30) DEFAULT NULL,
  `ITEM111` varchar(30) DEFAULT NULL,
  `ITEM112` varchar(30) DEFAULT NULL,
  `ITEM113` varchar(30) DEFAULT NULL,
  `ITEM114` varchar(30) DEFAULT NULL,
  `ITEM115` varchar(30) DEFAULT NULL,
  `ITEM116` varchar(30) DEFAULT NULL,
  `ITEM117` varchar(30) DEFAULT NULL,
  `ITEM118` varchar(30) DEFAULT NULL,
  `ITEM119` varchar(30) DEFAULT NULL,
  `ITEM120` varchar(30) DEFAULT NULL,
  `ITEM121` varchar(30) DEFAULT NULL,
  `ITEM122` varchar(30) DEFAULT NULL,
  `ITEM123` varchar(30) DEFAULT NULL,
  `ITEM124` varchar(30) DEFAULT NULL,
  `ITEM125` varchar(30) DEFAULT NULL,
  `ITEM126` varchar(30) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `ANIO` int DEFAULT NULL,
  `MES` int DEFAULT NULL,
  `DIA` int DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `HH` int DEFAULT NULL,
  `MM` int DEFAULT NULL,
  `SS` int DEFAULT NULL,
  KEY `IDX_EQUIPO_ID` (`EQUIPO_ID`),
  KEY `IDX_FECHA` (`FECHA`),
  KEY `IDX_ANIO` (`ANIO`),
  KEY `IDX_MES` (`MES`),
  KEY `IDX_DIA` (`DIA`),
  KEY `IDX_HORA` (`HORA`),
  KEY `IDX_HH` (`HH`),
  KEY `IDX_MM` (`MM`),
  KEY `IDX_SS` (`SS`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-28 11:20:53
