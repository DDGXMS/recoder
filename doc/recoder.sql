/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50145
Source Host           : localhost:3306
Source Database       : recoder

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2015-10-02 10:36:35
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
  `recoderType` int(11) DEFAULT '1',
  `tags` varchar(100) DEFAULT NULL,
  `creator` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `lastModifyTime` datetime NOT NULL,
  `deleteFlag` int(1) DEFAULT '0',
    text TEXT,
    love TINYINT(4),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recoder
-- ----------------------------
INSERT INTO recoder VALUES ('82', '阿斯蒂芬', '<p>沙发撒的</p>', '0', null, '1', '2015-10-01 12:05:25', '2015-10-01 12:05:25', '0');
INSERT INTO recoder VALUES ('83', '阿斯蒂芬', '<h1>沙发<span style=\"color: rgb(165, 198, 206); background-color: yellow;\">撒</span>的阿萨德<span style=\"background-color: yellow;\">发</span>撒发达</h1>', '0', null, '1', '2015-10-01 12:05:52', '2015-10-01 12:05:52', '0');
INSERT INTO recoder VALUES ('84', '萌萌超级好', '<p><span style=\"font-weight: bold; color: rgb(255, 0, 255); font-size: 36px; background-color: rgb(255, 255, 255);\">萌萌</span></p><p>你怎么这么<span style=\"color: rgb(57, 132, 198); font-weight: bold; font-size: 18px;\">好</span></p>', '0', null, '1', '2015-10-01 12:37:34', '2015-10-01 12:37:34', '0');
INSERT INTO recoder VALUES ('85', '奇怪的测试', '<p><span style=\"font-weight: bold; font-style: italic; text-decoration: underline; font-family: Impact; font-size: 24px; color: rgb(255, 255, 0); background-color: rgb(165, 74, 123);\">奇怪的测试</span><br></p>', '0', null, '1', '2015-10-01 19:53:48', '2015-10-01 19:53:48', '0');

-- ----------------------------
-- Table structure for `recoder_tag`
-- ----------------------------
DROP TABLE IF EXISTS `recoder_tag`;
CREATE TABLE `recoder_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(50) NOT NULL,
  `className` varchar(40) NOT NULL,
  `creator` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `deleteFlag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recoder_tag
-- ----------------------------
INSERT INTO recoder_tag VALUES ('1', 'SQL', 'default', '1', '2015-09-22 00:59:28', '0');
INSERT INTO recoder_tag VALUES ('2', '碎念', 'danger', '1', '2015-09-22 00:59:38', '0');
INSERT INTO recoder_tag VALUES ('3', '萌萌', 'primary', '1', '2015-09-22 01:00:22', '0');
INSERT INTO recoder_tag VALUES ('4', 'MISS', 'success', '1', '2015-09-22 01:00:46', '0');
INSERT INTO recoder_tag VALUES ('5', 'YOU', 'warning', '1', '2015-09-22 01:00:55', '0');
INSERT INTO recoder_tag VALUES ('6', '东东', 'primary', '1', '2015-09-22 01:44:26', '0');

-- ----------------------------
-- Table structure for `recoder_type`
-- ----------------------------
DROP TABLE IF EXISTS `recoder_type`;
CREATE TABLE `recoder_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(100) NOT NULL,
  `className` varchar(40) NOT NULL,
  `creator` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `deleteFlag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recoder_type
-- ----------------------------
INSERT INTO recoder_type VALUES ('1', '程序', 'default', '1', '2015-09-22 00:56:56', '0');
INSERT INTO recoder_type VALUES ('2', '问题', 'danger', '1', '2015-09-22 00:57:18', '0');
INSERT INTO recoder_type VALUES ('3', '零碎', 'primary', '1', '2015-09-22 00:58:01', '0');
INSERT INTO recoder_type VALUES ('4', '账户', 'success', '1', '2015-09-22 00:58:39', '0');
INSERT INTO recoder_type VALUES ('5', '地址', 'warning', '1', '2015-09-22 00:58:55', '0');

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
INSERT INTO user VALUES ('1', 'syy', 'CE7F64B0D15B9B6A38420D22D81C15CE', '2015-09-20 10:53:11', '2015-10-01 21:28:06');
