/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : hadoopdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-05 07:05:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depts
-- ----------------------------
DROP TABLE IF EXISTS `depts`;
CREATE TABLE `depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depts
-- ----------------------------
INSERT INTO `depts` VALUES ('1', 'HR');
INSERT INTO `depts` VALUES ('2', 'SALE');

-- ----------------------------
-- Table structure for statsinfos
-- ----------------------------
DROP TABLE IF EXISTS `statsinfos`;
CREATE TABLE `statsinfos` (
  `id` int(11) DEFAULT NULL,
  `countInfo` varchar(255) DEFAULT NULL,
  `countNum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statsinfos
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhangsan', 'M', '10', '1');
INSERT INTO `users` VALUES ('2', 'lisi', 'F', '20', '1');
INSERT INTO `users` VALUES ('3', 'wangwu', 'M', '30', '1');
INSERT INTO `users` VALUES ('4', 'zhaoliu', 'F', '40', '2');
INSERT INTO `users` VALUES ('5', 'maqi', 'M', '50', '2');
