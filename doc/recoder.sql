/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50145
Source Host           : localhost:3306
Source Database       : recoder

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2015-09-20 20:31:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `recoder`
-- ----------------------------
DROP TABLE IF EXISTS `recoder`;
CREATE TABLE `recoder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text NOT NULL,
  `createTime` datetime NOT NULL,
  `creator` int(11) NOT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `recoderType` int(11) DEFAULT NULL,
  `flagDelete` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recoder
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `registerTime` datetime NOT NULL,
  `loginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'syy', 'CE7F64B0D15B9B6A38420D22D81C15CE', '2015-09-20 10:53:11', '2015-09-20 14:35:25');
