/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : security01

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-04-02 09:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `mdContent` longtext COMMENT 'markdown内容',
  `htmlContent` longtext COMMENT 'html内容',
  `uid` bigint(20) DEFAULT NULL COMMENT '作者id',
  `cid` bigint(20) DEFAULT NULL COMMENT '类别id',
  `publishTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(11) DEFAULT NULL COMMENT '文章状态，1-已发布，2-草稿箱，3-回收站',
  `views` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) DEFAULT '-1',
  `cname` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '-1', '前端', '2021-03-26 09:32:19');
INSERT INTO `category` VALUES ('2', '-1', '后端', '2021-03-26 09:32:34');
INSERT INTO `category` VALUES ('3', '-1', 'Android', '2021-03-26 09:32:41');
INSERT INTO `category` VALUES ('4', '-1', '人工智能', '2021-03-26 09:32:46');
INSERT INTO `category` VALUES ('5', '2', 'Java', '2021-03-26 09:33:42');
INSERT INTO `category` VALUES ('6', '2', 'SpringBoot', '2021-03-26 09:33:54');
INSERT INTO `category` VALUES ('7', '2', 'Python', '2021-03-26 09:34:00');
INSERT INTO `category` VALUES ('8', '2', '算法', '2021-03-26 09:34:04');
INSERT INTO `category` VALUES ('9', '2', '数据库', '2021-03-26 09:34:11');
INSERT INTO `category` VALUES ('10', '1', 'JavaScript', '2021-03-26 09:34:40');
INSERT INTO `category` VALUES ('11', '1', 'Vue.js', '2021-03-26 09:34:47');
INSERT INTO `category` VALUES ('12', '1', 'Node.js', '2021-03-26 09:34:57');
INSERT INTO `category` VALUES ('13', '1', '微信小程序', '2021-03-26 09:35:04');
INSERT INTO `category` VALUES ('14', '3', 'Flutter', '2021-03-26 09:35:47');
INSERT INTO `category` VALUES ('15', '3', '性能优化', '2021-03-26 09:35:52');
INSERT INTO `category` VALUES ('16', '3', '架构', '2021-03-26 09:35:57');
INSERT INTO `category` VALUES ('17', '4', '机器学习', '2021-03-26 09:36:32');
INSERT INTO `category` VALUES ('18', '4', '深度学习', '2021-03-26 09:36:36');
INSERT INTO `category` VALUES ('19', '4', '大数据', '2021-03-26 09:36:50');
INSERT INTO `category` VALUES ('20', '4', '计算机视觉', '2021-03-26 09:37:01');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pattern` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/article/**');
INSERT INTO `menu` VALUES ('2', '/category/**');
INSERT INTO `menu` VALUES ('3', '/user/**');

-- ----------------------------
-- Table structure for `menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('8', '11', '1');
INSERT INTO `menu_role` VALUES ('9', '11', '2');
INSERT INTO `menu_role` VALUES ('10', '11', '3');
INSERT INTO `menu_role` VALUES ('11', '12', '2');
INSERT INTO `menu_role` VALUES ('12', '13', '1');
INSERT INTO `menu_role` VALUES ('13', '14', '3');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  `rnameZh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('11', 'ROLE_admin', '超级管理员');
INSERT INTO `role` VALUES ('12', 'ROLE_category', '栏目管理员');
INSERT INTO `role` VALUES ('13', 'ROLE_article', '文章管理员');
INSERT INTO `role` VALUES ('14', 'ROLE_user', '用户管理员');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `nonLocked` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9001', 'root', '$2a$10$yTBBVJixGGGLpPNoPGOpp.gA4xqfwMNdE4bslSuLt1h71xg3rRGtG', 'ROOT', 'root@163.com', '0', '1', '1');
INSERT INTO `user` VALUES ('9002', 'libai', '$2a$10$UHEvSqmhmKSlkat5dGiIQeGgxq0iMEO9eX43U3Ovt89K/6z7UkSge', '李白', 'libai@qq.com', '0', '1', '1');
INSERT INTO `user` VALUES ('9003', 'dufu', '$2a$10$Rh0N/.kEWFXG/e1v9ewEfe4efQ5pWdRdCRh859Nxd9Q9mym222iUW', '杜甫', 'dufu@163.com', '0', '1', '1');
INSERT INTO `user` VALUES ('9004', 'liqingzhao', '$2a$10$veZni1A3hgc4YXs5hwdZZ.P2S43DICXC97.EKxDNtfUa8SSXO5ZqS', '李清照', 'liqingzhao@qq.com', '1', '1', '1');
INSERT INTO `user` VALUES ('9005', 'lishangyin', '$2a$10$veZni1A3hgc4YXs5hwdZZ.P2S43DICXC97.EKxDNtfUa8SSXO5ZqS', '李商隐', 'lishangyin@neuedu.com', '0', '1', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '9001', '11');
INSERT INTO `user_role` VALUES ('3', '9002', '12');
INSERT INTO `user_role` VALUES ('4', '9003', '13');
INSERT INTO `user_role` VALUES ('5', '9004', '14');
INSERT INTO `user_role` VALUES ('6', '9005', '14');
