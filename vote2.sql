/*
Navicat MySQL Data Transfer

Source Server         : mysql5
Source Server Version : 50646
Source Host           : 8.129.166.53:3307
Source Database       : vote2

Target Server Type    : MYSQL
Target Server Version : 50646
File Encoding         : 65001

Date: 2020-09-29 11:46:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `typ` int(11) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '谁是中国首富', '1', '2020-09-28 09:16:08');
INSERT INTO `article` VALUES ('2', '你觉得自己帅吗', '1', '2020-09-28 09:17:02');
INSERT INTO `article` VALUES ('3', '下面哪几个是熊', '2', '2020-09-28 09:28:50');
INSERT INTO `article` VALUES ('5', '中国在东半球还是西半球', '1', '2020-09-29 03:26:16');

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `optionvalue` varchar(255) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of options
-- ----------------------------
INSERT INTO `options` VALUES ('1', '马云', '1');
INSERT INTO `options` VALUES ('2', '马化腾', '1');
INSERT INTO `options` VALUES ('3', '王健林', '1');
INSERT INTO `options` VALUES ('4', '钟睒睒', '1');
INSERT INTO `options` VALUES ('5', '帅', '2');
INSERT INTO `options` VALUES ('6', '不帅', '2');
INSERT INTO `options` VALUES ('7', '白熊', '3');
INSERT INTO `options` VALUES ('8', '熊掌', '3');
INSERT INTO `options` VALUES ('9', '熊猫', '3');
INSERT INTO `options` VALUES ('10', '北极熊', '3');
INSERT INTO `options` VALUES ('13', '东半球', '5');
INSERT INTO `options` VALUES ('14', '西半球', '5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'qwe123', '0', '0');
INSERT INTO `user` VALUES ('2', 'wjm', 'qwe123', '0', '0');
INSERT INTO `user` VALUES ('3', 'ljf', 'qwe123', '0', '0');
INSERT INTO `user` VALUES ('4', 'jlq', 'qwe123', '0', '0');
INSERT INTO `user` VALUES ('5', 'pzl', 'qwe123', '0', '0');

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleid` int(11) NOT NULL,
  `optionid` int(11) NOT NULL,
  `voterid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '1', '4', '1');
INSERT INTO `vote` VALUES ('2', '2', '5', '1');
INSERT INTO `vote` VALUES ('3', '3', '7', '1');
INSERT INTO `vote` VALUES ('4', '3', '8', '1');
INSERT INTO `vote` VALUES ('5', '3', '9', '1');
INSERT INTO `vote` VALUES ('6', '3', '10', '1');
INSERT INTO `vote` VALUES ('7', '1', '1', '2');
INSERT INTO `vote` VALUES ('8', '1', '4', '3');
INSERT INTO `vote` VALUES ('9', '2', '5', '2');
INSERT INTO `vote` VALUES ('10', '1', '1', '4');
INSERT INTO `vote` VALUES ('13', '1', '4', '5');
INSERT INTO `vote` VALUES ('14', '5', '13', '5');
