-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: oubusmain
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenAdmin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'kiet','kiet','123'),(2,'huy','huy','123'),(3,'tai','tai','123'),(4,'bao','bao','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuyenxe`
--

DROP TABLE IF EXISTS `chuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuyenxe` (
  `maChuyenXe` int NOT NULL AUTO_INCREMENT,
  `maXe` int NOT NULL,
  `ngayXuatPhat` date DEFAULT NULL,
  `giaVe` decimal(10,0) DEFAULT NULL,
  `diemDi` varchar(45) NOT NULL,
  `diemDen` varchar(45) NOT NULL,
  PRIMARY KEY (`maChuyenXe`),
  KEY `maXe` (`maXe`),
  CONSTRAINT `chuyenxe_ibfk_2` FOREIGN KEY (`maXe`) REFERENCES `xe` (`maXe`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenxe`
--

LOCK TABLES `chuyenxe` WRITE;
/*!40000 ALTER TABLE `chuyenxe` DISABLE KEYS */;
INSERT INTO `chuyenxe` VALUES (1,1,'2019-03-04',20000,'BinhDinh','TPHCM'),(2,1,'2019-03-04',200000,'BD','DL'),(21,1,'2001-03-04',2000,'BD','DN'),(22,1,'2001-03-04',2000,'BD','DN');
/*!40000 ALTER TABLE `chuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ghe`
--

DROP TABLE IF EXISTS `ghe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ghe` (
  `maGhe` int NOT NULL AUTO_INCREMENT,
  `tenGhe` varchar(50) NOT NULL,
  `tinhTrangGhe` tinyint(1) DEFAULT '1',
  `maXe` int NOT NULL,
  PRIMARY KEY (`maGhe`),
  KEY `FK_ghe_xe` (`maXe`),
  CONSTRAINT `FK_ghe_xe` FOREIGN KEY (`maXe`) REFERENCES `xe` (`maXe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ghe`
--

LOCK TABLES `ghe` WRITE;
/*!40000 ALTER TABLE `ghe` DISABLE KEYS */;
INSERT INTO `ghe` VALUES (1,'A01',0,1),(2,'B01',1,1);
/*!40000 ALTER TABLE `ghe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNV` int NOT NULL AUTO_INCREMENT,
  `tenNV` varchar(50) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_role` enum('Admin','Nhanvien') DEFAULT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Peter','qhuy','123',NULL),(2,'Ken','tester','123',NULL);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vexe`
--

DROP TABLE IF EXISTS `vexe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vexe` (
  `maVe` int NOT NULL AUTO_INCREMENT,
  `tenVe` varchar(50) DEFAULT NULL,
  `maChuyenXe` int NOT NULL,
  `maGhe` int NOT NULL,
  `maNV` int NOT NULL,
  `tenKH` varchar(45) DEFAULT NULL,
  `sdtKH` varchar(45) DEFAULT NULL,
  `ngayDatVe` varchar(45) NOT NULL,
  `tinhTrangVe` varchar(45) DEFAULT 'đã đặt',
  PRIMARY KEY (`maVe`),
  KEY `maChuyenXe` (`maChuyenXe`),
  KEY `maGhe` (`maGhe`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `vexe_ibfk_2` FOREIGN KEY (`maGhe`) REFERENCES `ghe` (`maGhe`),
  CONSTRAINT `vexe_ibfk_3` FOREIGN KEY (`maChuyenXe`) REFERENCES `chuyenxe` (`maChuyenXe`),
  CONSTRAINT `vexe_ibfk_4` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vexe`
--

LOCK TABLES `vexe` WRITE;
/*!40000 ALTER TABLE `vexe` DISABLE KEYS */;
INSERT INTO `vexe` VALUES (2,'suavetest',1,2,1,'fdfs','054454','4/21/2022','đã đặt'),(5,'ve53',1,1,1,'nfkdns','54611613','3/29/2022','đã đặt'),(6,'ve241',1,1,1,'gfg','03594','3/30/2022','đã đặt'),(7,'ve5',1,1,1,'test','0548787','4/6/2022','đã bán'),(8,'ve542213',1,1,1,'fbdifjhfd','0151646','4/21/2022','đã đặt'),(10,'vetinhtrang',1,1,1,'fdsf','015478','4/6/2022','đã bán'),(11,'verewr',1,1,1,'fds','065962','4/7/2022','đã đặt'),(12,'vebla',1,1,1,'qhuy','0154984','3/30/2022','đã đặt'),(13,'vebla1',1,1,1,'Qhuy','065949','3/31/2022','đã đặt'),(14,'ve413nk5',1,1,1,'qhuy','04848','4/2/2022','đã đặt'),(15,'ewtwgw',1,2,1,'Qhuytest','0415649','4/8/2022','đã đặt'),(16,'ewtwgw',1,2,1,'Qhuytest','0415649','4/8/2022','đã đặt'),(17,'ve54252',1,2,1,'grs','0545','4/8/2022','đã đặt'),(18,'ventnrkwt',1,2,1,'rfsgrw','9526','4/7/2022','đã đặt'),(19,'fnweg',1,2,1,'fenj','06484','4/8/2022','đã đặt'),(20,'fewfwefw',1,1,1,'qhuy','184512','4/16/2022','đã đặt'),(21,'grwgrw',1,2,1,'2tsf','03148','4/15/2022','đã đặt'),(22,'vrwdqq',1,1,1,'frwg','064163','4/28/2022','đã đặt'),(23,'vrwdqq',1,1,1,'frwg','064163','4/28/2022','đã đặt'),(24,'fewf',1,1,1,'fafdf','23153251','4/15/2022','đã đặt'),(25,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(26,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(27,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(28,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(29,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(30,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(31,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(32,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt'),(33,'Tai',1,1,1,'Tai','123','3/31/2022','đã đặt'),(34,'VeTest',1,1,1,'Tai','123','12-3-2001','đã đặt');
/*!40000 ALTER TABLE `vexe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xe`
--

DROP TABLE IF EXISTS `xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xe` (
  `maXe` int NOT NULL AUTO_INCREMENT,
  `tenXe` varchar(50) NOT NULL,
  `bienSo` varchar(50) NOT NULL,
  `soGhe` int NOT NULL,
  PRIMARY KEY (`maXe`),
  UNIQUE KEY `bienSo` (`bienSo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xe`
--

LOCK TABLES `xe` WRITE;
/*!40000 ALTER TABLE `xe` DISABLE KEYS */;
INSERT INTO `xe` VALUES (1,'bus','B01',30);
/*!40000 ALTER TABLE `xe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26 17:01:52
