/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50145
Source Host           : localhost:3306
Source Database       : recoder

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2015-09-22 07:56:34
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recoder
-- ----------------------------
INSERT INTO recoder VALUES ('1', '查看交易管家短信发送情况', 'SELECT \r\n                                  COUNT(1) total, \r\n                                  SUM(CASE WHEN commitStatus=1 THEN 1 ELSE 0 END) succ, \r\n                                  COUNT(DISTINCT phone) sp FROM dbo.SMS_SendReport\r\n                                 WHERE msg LIKE \'%【交易管家】恭喜%\' AND sendTime BETWEEN \'2015-08-24\' AND \'2015-08-31\'', '1', '1', '1', '2015-09-21 00:19:54', '2015-09-21 00:19:58', '0');
INSERT INTO recoder VALUES ('2', '一些问题', '如何让任意错误链接跳转到指定页面，比如登陆界面？\r\n                                可不可以做一个项目末班的工具，可以快速搭建web项目？', '2', '3,4,5', '1', '2015-09-22 01:35:51', '2015-09-22 01:35:53', '0');
INSERT INTO recoder VALUES ('3', 'windows下缩短time_wait的时间', '最近线上遇到windows机器访问其他机器的时候失败的情况。实际就是本地的端口不够用造成的。\r\n\r\n\r\nD:\\>netsh interface ipv4 show dynamicportrange protocol=tcp\r\n\r\n\r\nProtocol tcp Dynamic Port Range\r\n---------------------------------\r\nStart Port : 49152\r\nNumber of Ports : 16384\r\n\r\n\r\nD:\\>netsh interface ipv4 show tcpstats', '3', '2', '1', '2015-09-22 01:36:28', '2015-09-22 01:36:31', '0');
INSERT INTO recoder VALUES ('4', 'Linux 常用命令', ' * mv\r\n  * \r\n    * 重命名   mv a.txt b.txt\r\n    * 移动目录 mv a.txt ../test\r\n\r\n  * vim中查找\r\n  * \r\n    * /word 这个是查找文件中“word”这个单词，是从文件上面到下面查找\r\n    * ?word 这个是查找文件中“word”这个单词，是从文件下上面到面查找\r\n\r\n  * 压缩与解压缩', '3', '2', '1', '2015-09-22 01:37:02', '2015-09-22 01:37:06', '0');
INSERT INTO recoder VALUES ('5', 'RSA加密算法', ' RSA加密算法是最常用的非对称加密算法。RSA是第一个比较完善的公开密钥算法，它既能用于加密，也能用于数字签名。RSA以它的三个发明者Ron Rivest, Adi Shamir, Leonard Adleman的名字首字母命名，这个算法经受住了多年深入的密码分析，虽然密码分析者既不能证明也不能否定RSA的安全性，但这恰恰说明该算法有一定的可信性，目前它已经成为最流行的公开密钥算法；', '5', '4,5', '1', '2015-09-22 01:42:29', '2015-09-22 01:42:31', '0');
INSERT INTO recoder VALUES ('6', '样本库', '【数据库】\r\n名称：样本库\r\n地址：192.168.3.66\r\n账号：wangdongshuo\r\n密码：dooioo1433\r\n', '4', '6,4,3', '1', '2015-09-22 01:44:51', '2015-09-22 01:44:55', '0');
INSERT INTO recoder VALUES ('7', 'c() ', '以向量形式输入数据，可将参数组合成一个向量或列表；\r\nage <- c(1,2,3,4,5)\r\n', '2', '3,4,6', '1', '2015-09-22 01:45:29', '2015-09-22 01:45:32', '0');

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
INSERT INTO recoder_tag VALUES ('1', 'SQL', 'label-default', '1', '2015-09-22 00:59:28', '0');
INSERT INTO recoder_tag VALUES ('2', '碎念', 'label-danger', '1', '2015-09-22 00:59:38', '0');
INSERT INTO recoder_tag VALUES ('3', '萌萌', 'label-primary', '1', '2015-09-22 01:00:22', '0');
INSERT INTO recoder_tag VALUES ('4', 'MISS', 'label-success', '1', '2015-09-22 01:00:46', '0');
INSERT INTO recoder_tag VALUES ('5', 'YOU', 'label-warning', '1', '2015-09-22 01:00:55', '0');
INSERT INTO recoder_tag VALUES ('6', '东东', 'label-primary', '1', '2015-09-22 01:44:26', '0');

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
INSERT INTO recoder_type VALUES ('1', '程序', 'panel-default', '1', '2015-09-22 00:56:56', '0');
INSERT INTO recoder_type VALUES ('2', '问题', 'panel-danger', '1', '2015-09-22 00:57:18', '0');
INSERT INTO recoder_type VALUES ('3', '零碎', 'panel-primary', '1', '2015-09-22 00:58:01', '0');
INSERT INTO recoder_type VALUES ('4', '账户', 'panel-success', '1', '2015-09-22 00:58:39', '0');
INSERT INTO recoder_type VALUES ('5', '地址', 'panel-warning', '1', '2015-09-22 00:58:55', '0');

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
INSERT INTO user VALUES ('1', 'syy', 'CE7F64B0D15B9B6A38420D22D81C15CE', '2015-09-20 10:53:11', '2015-09-22 01:49:45');
