-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: huan-sheng-ppp
-- ------------------------------------------------------
-- Server version	5.6.37

DROP TABLE IF EXISTS `STUDENT`;

CREATE TABLE `STUDENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(45) NOT NULL,
  `student_name` varchar(45) NOT NULL,
  `gender` int(11) NOT NULL COMMENT '0 男 1 女',
  `age` int(11) NOT NULL,
  `address` varchar(150) NOT NULL,
  `major` varchar(45) NOT NULL,
  `deleted` int(11) DEFAULT '0' COMMENT '1 表示删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_num_UNIQUE` (`student_num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `STUDENT` WRITE;

INSERT INTO `STUDENT` VALUES (1,'174117','Pan pingping',1,24,'China','Information',0),(3,'174118','Pan pingping',1,24,'China','Information',0);

UNLOCK TABLES;

-- Dump completed on 2018-05-06 17:25:28
