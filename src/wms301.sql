/*
Navicat MySQL Data Transfer

Source Server         : new 1
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : wms301

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-11-28 20:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_companyinfo301
-- ----------------------------
DROP TABLE IF EXISTS `t_companyinfo301`;
CREATE TABLE `t_companyinfo301` (
  `ciId301` int NOT NULL AUTO_INCREMENT,
  `ciTitle301` varchar(255) DEFAULT NULL,
  `ciImage301` varchar(255) DEFAULT NULL,
  `ciContent301` text,
  `ciEditDate301` varchar(255) DEFAULT NULL,
  `ciNo301` int DEFAULT NULL,
  PRIMARY KEY (`ciId301`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menuName` varchar(255) DEFAULT NULL,
  `menuURL` varchar(255) DEFAULT NULL,
  `menuNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
