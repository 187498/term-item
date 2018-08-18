/*
Navicat MySQL Data Transfer

Source Server         : ldl
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : zijinbao

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-03 11:26:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_account` varchar(255) NOT NULL,
  `manager_password` varchar(255) NOT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '1234', '周三');
INSERT INTO `manager` VALUES ('2', '233', '历史');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` varchar(255) DEFAULT NULL,
  `news_title` varchar(255) NOT NULL,
  `news_time` date NOT NULL,
  `news_message` varchar(255) NOT NULL,
  PRIMARY KEY (`news_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (null, '下午好', '2018-07-31', '小');
INSERT INTO `news` VALUES (null, '早上好', '2018-07-31', '小');
INSERT INTO `news` VALUES (null, '晚上好', '2018-07-31', '实现一个');
INSERT INTO `news` VALUES (null, '震惊', '2018-07-31', 'dfdsfsda');
INSERT INTO `news` VALUES ('15', '震惊！中国某些银行竟然存在这种漏洞！', '2018-07-11', '456');
INSERT INTO `news` VALUES ('1', '震惊！某大学女生为借钱竟然做出这种举动！', '2018-07-25', '123');
INSERT INTO `news` VALUES ('10', '震惊！资金宝竟然免费送钱！', '2018-06-13', '789');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_time` datetime NOT NULL,
  `record_money` double NOT NULL,
  `user_account` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2018-07-09 11:42:04', '756.1199951171875', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-07-11 11:19:56', '-1000', '666');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '10', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '50', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '500', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '10', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '10', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '123', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1', '123');
INSERT INTO `record` VALUES ('2018-08-01 00:00:00', '1', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '1', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '999');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '999');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '3000', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '200', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '12', '666');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '20', '666');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-02 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '100', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1000', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-100', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '2', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1000', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '200', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-500', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1010', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '-1', '123');
INSERT INTO `record` VALUES ('2018-08-03 00:00:00', '1000', '123');

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `out_account` varchar(255) NOT NULL,
  `in_account` varchar(255) NOT NULL,
  `transfer_fund` double NOT NULL,
  `transfer_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('123', '888', '1000', '2018-08-01 00:00:00');
INSERT INTO `transfer` VALUES ('666', '888', '1000', '2018-07-11 11:19:56');
INSERT INTO `transfer` VALUES ('123', '888', '2000', '2018-08-01 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '39', '2018-08-02 00:00:00');
INSERT INTO `transfer` VALUES ('123', '999', '1000', '2018-08-02 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '500', '2018-08-02 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '500', '2018-08-02 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '500', '2018-08-02 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '123', '2018-08-03 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '1', '2018-08-03 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '100', '2018-08-03 00:00:00');
INSERT INTO `transfer` VALUES ('123', '888', '1', '2018-08-03 00:00:00');
INSERT INTO `transfer` VALUES ('888', '123', '555', '2018-08-03 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_account` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_fund` float NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_state` int(1) NOT NULL,
  PRIMARY KEY (`user_account`),
  KEY `FK_userinfo` (`user_id`),
  CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111222333', '111222333444555666', '1234567', '1000', '杨超越', '1');
INSERT INTO `user` VALUES ('123', '789789', '123', '3358', '周东', '1');
INSERT INTO `user` VALUES ('1233', '123', '123', '0', '123', '1');
INSERT INTO `user` VALUES ('2016415256', '23432122', '11', '0', '杜文丽', '1');
INSERT INTO `user` VALUES ('435674', '12321753', '11', '123', '杜文丽2', '1');
INSERT INTO `user` VALUES ('65465465', '12346587', '1234', '0', '465645', '1');
INSERT INTO `user` VALUES ('666', '123789789', '666', '1256', '王伟', '1');
INSERT INTO `user` VALUES ('764', '3213431', '12', '0', '杜文丽', '1');
INSERT INTO `user` VALUES ('777', '5123647985', 'zijinbao123', '8974560', '李晓明', '0');
INSERT INTO `user` VALUES ('888', '745621', 'zijin！', '9011', '赵小刚', '1');
INSERT INTO `user` VALUES ('999', '895416', 'money23', '10561', '李华', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_addr` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_gender` varchar(255) NOT NULL,
  `user_birth` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('111222333444555666', '杨超越', '川大', '15800001111', '123456789@qq.com', '女', '2011-03-10');
INSERT INTO `user_info` VALUES ('123', '123', '123', '123', '12321@163.com', '男', '2018-08-15');
INSERT INTO `user_info` VALUES ('12321753', '杜文丽2', '231', '12432', '12@qq.com', '男', '2018-08-16');
INSERT INTO `user_info` VALUES ('12346587', '465645', '123', '123', '12321@163.com', '男', '2018-08-16');
INSERT INTO `user_info` VALUES ('123789789', '王伟', '青羊区', '17785946321', '666@123.com', '男', '2018-07-03');
INSERT INTO `user_info` VALUES ('20180726', '小白', '青羊区', '111111', '123@qq.com', '女', '2018-07-05');
INSERT INTO `user_info` VALUES ('213', '534', '123', '123', 'ds@66.com', '男', '2018-08-22');
INSERT INTO `user_info` VALUES ('23432122', '杜文丽', '2321', '12321232', '12@qq.com', '女', '2018-08-22');
INSERT INTO `user_info` VALUES ('3213431', '杜文丽', '123', '123', '12@qq.com', '男', '2018-08-08');
INSERT INTO `user_info` VALUES ('5123647985', '李晓明', '武侯区', '18945621574', '777@qq.com', '男', '2018-07-02');
INSERT INTO `user_info` VALUES ('745621', '赵小刚', '金牛区', '15674688946', 'zijin@zijin.com', '女', '2018-07-08');
INSERT INTO `user_info` VALUES ('789789', '周东', '双流区', '17711048381', '402376637@qq.com', '男', '2018-07-05');
INSERT INTO `user_info` VALUES ('895416', '李华', '锦江区', '15896542576', 'money@qq.com', '男', '2018-07-05');
